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

import kino.domain.Movie;
import kino.domain.Seans;
import kino.repository.SeansRepository;

@Repository
@Transactional
public class SeansRepositoryImpl implements SeansRepository{

	@PersistenceContext
	private EntityManager emManager;
	private String day;
	private Movie movie = new Movie();
	public Seans yourSeans = new Seans();
	
	public SeansRepositoryImpl(){
		
	}
	
	
	
	public Seans getYourSeans() {
		return yourSeans;
	}



	public void setYourSeans(Seans yourSeans) {
		this.yourSeans = yourSeans;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public Movie getMovie() {
		return movie;
	}



	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	@Override
	public List<Seans> getAll() {
		
		return emManager.createQuery("SELECT s FROM Seans s", Seans.class).getResultList();
	}

	@Override
	public void save(Seans seans) {
		
		List<Seans> listOfSeanses = getSeansByFilmNameAndDay(seans.getMovie(),seans.getDay());
		boolean save = true;
		
		for(Seans s: listOfSeanses){
			if(s.getHour().equals(seans.getHour())){
				save = false;
			}
		}
		
		if(save)
			emManager.persist(seans);
		
	}

	@Override
	public List<Seans> getSeansByFilmNameAndDay(Movie movie, String day) {
		
		this.day = day;
		this.movie = movie;
		
		String name = null;
		
		if(movie != null)
				name = movie.getName();
		
		List<Seans> listaSeansow = new ArrayList<Seans>();
		
		if(name != null){
			TypedQuery<Seans> query = emManager.createNamedQuery("Seans.findByNameAndDay", Seans.class);
			query.setParameter("name", name);
			query.setParameter("day", day);
			try{
				listaSeansow = query.getResultList();
			}catch(NullPointerException exception){
				
			}
		}
		
		return listaSeansow;
	}

	
	public List<String> createList(String attribute1, String attribute2, String attribute3, String attribute4){
		List<String> lista = new ArrayList<String>();
		lista.add(attribute1);
		lista.add(attribute2);
		lista.add(attribute3);
		
		if(!attribute4.equals("false"))
			lista.add(attribute4);
		
		return lista;
	}


	@Override
	public Seans getSeansByFilmNameAndDayAndHour(String hour) {
		List<Seans> listOfSeanses = getSeansByFilmNameAndDay(movie,day);
		
		for(Seans s: listOfSeanses){
			if(s.getHour().equals(hour)){
				this.yourSeans = s;
			}
		}
		
		return yourSeans;
	}



	@Override
	public void update(Seans seans) {
		emManager.merge(seans);
		
	}
}
