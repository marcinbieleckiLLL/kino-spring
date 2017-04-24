package kino.repositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kino.domain.Film;
import kino.domain.Seans;
import kino.repository.SeansRepository;

@Repository
@Transactional
public class SeansRepositoryImpl implements SeansRepository{

	@PersistenceContext
	private EntityManager emManager;
	private String dzien;
	private Film film = new Film();
	public Seans TwojSeans = new Seans();
	
	public SeansRepositoryImpl(){
		
	}
	
	
	
	public Seans getTwojSeans() {
		return TwojSeans;
	}



	public void setTwojSeans(Seans twojSeans) {
		TwojSeans = twojSeans;
	}



	public String getDzien() {
		return dzien;
	}



	public void setDzien(String dzien) {
		this.dzien = dzien;
	}



	public Film getFilm() {
		return film;
	}



	public void setFilm(Film film) {
		this.film = film;
	}


	@Override
	public List<Seans> getAll() {
		
		return emManager.createQuery("SELECT s FROM Seans s", Seans.class).getResultList();
	}

	@Override
	public void save(Seans seans) {
		
		List<Seans> listaSeansow = getSeansByFilmNameAndDay(seans.getFilm(),seans.getDzien());
		boolean zapisz = true;
		
		for(Seans s: listaSeansow){
			if(s.getGodzina().equals(seans.getGodzina())){
				zapisz = false;
			}
		}
		
		if(zapisz)
			emManager.persist(seans);
		
	}

	@Override
	public List<Seans> getSeansByFilmNameAndDay(Film film, String dzien) {
		
		this.dzien = dzien;
		this.film = film;
		
		String nazwa = null;
		
		if(film != null)
				nazwa = film.getNazwa();
		
		List<Seans> listaSeansow = new ArrayList<Seans>();
		
		if(nazwa != null){
			TypedQuery<Seans> query = emManager.createNamedQuery("Seans.findByNameAndDay", Seans.class);
			query.setParameter("nazwa", nazwa);
			query.setParameter("dzien", dzien);
			try{
				listaSeansow = query.getResultList();
			}catch(NullPointerException exception){
				
			}
		}
		
		return listaSeansow;
	}

	
	public List<String> TworzenieListy(String atrybut1, String atrybut2, String atrybut3, String atrybut4){
		List<String> lista = new ArrayList<String>();
		lista.add(atrybut1);
		lista.add(atrybut2);
		lista.add(atrybut3);
		
		if(!atrybut4.equals("false"))
			lista.add(atrybut4);
		
		return lista;
	}


	@Override
	public Seans getSeansByFilmNameAndDayAndHour(String godzina) {
		List<Seans> listaSeansow = getSeansByFilmNameAndDay(film,dzien);
		
		for(Seans s: listaSeansow){
			if(s.getGodzina().equals(godzina)){
				this.TwojSeans = s;
			}
		}
		
		return TwojSeans;
	}



	@Override
	public void update(Seans seans) {
		emManager.merge(seans);
		
	}
}
