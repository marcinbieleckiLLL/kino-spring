package kino.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kino.domain.Film;
import kino.repository.FilmRepository;

@Repository
@Transactional
public class FilmRepositoryImpl implements FilmRepository {
	
	@PersistenceContext
	private EntityManager emManager;
	
	public FilmRepositoryImpl(){
		
	}
	
	public void save(Film film, String nazwa) {	
		
		List<Film> listaFilmow = getAll();
		boolean zapisz = true;
		
		for(Film f: listaFilmow){
			if(f.getNazwa().equals(film.getNazwa())){
				zapisz = false;
			}
		}
		
		if(zapisz)
			emManager.persist(film);
	}

	public List<Film> getAll() {
		
		return emManager.createQuery("SELECT f FROM Film f", Film.class).getResultList();
	}
	
	
	public Film getFilmById(Long id) {
		Film film = new Film();
		
		if(getAll().size() > 0)
			film = emManager.find(Film.class, id);
		
		return film;
	}
	
	public Film getFilmByName(String nazwa){
		
		Film film = new Film();
		
		if(getAll().size() > 0){
			TypedQuery<Film> query = emManager.createNamedQuery("Film.findByName", Film.class);
			query.setParameter("nazwa", nazwa);
			try{
				List<Film> listaFilmow = query.getResultList();
				if(listaFilmow != null && !listaFilmow.isEmpty())
					film = listaFilmow.get(0);
			}catch(NoResultException nre){
				
			}
		}
        return film;
	}

	@Override
	public List<String> dniTygodnia() {
		
		List<String> dniTygodnia = new ArrayList<String>();
		
		dniTygodnia.add("poniedzia³ek");
		dniTygodnia.add("wtorek");
		dniTygodnia.add("œroda");
		dniTygodnia.add("czwartek");
		dniTygodnia.add("pi¹tek");
		dniTygodnia.add("sobota");
		dniTygodnia.add("niedziela");
		
		return dniTygodnia;
	}
}
