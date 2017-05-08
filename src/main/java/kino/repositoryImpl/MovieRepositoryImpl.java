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

import kino.domain.Movie;
import kino.repository.MovieRepository;

@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepository {
	
	@PersistenceContext
	private EntityManager emManager;
	
	public MovieRepositoryImpl(){
		
	}
	
	public void save(Movie movie, String name) {	
		
		List<Movie> listOfMovies = getAll();
		boolean save = true;
		
		for(Movie f: listOfMovies){
			if(f.getName().equals(movie.getName())){
				save = false;
			}
		}
		
		if(save)
			emManager.persist(movie);
	}

	public List<Movie> getAll() {
		
		return emManager.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
	}
	
	
	public Movie getFilmById(Long id) {
		Movie movie = new Movie();
		
		if(getAll().size() > 0)
			movie = emManager.find(Movie.class, id);
		
		return movie;
	}
	
	public Movie getFilmByName(String name){
		
		Movie movie = new Movie();
		
		if(getAll().size() > 0){
			TypedQuery<Movie> query = emManager.createNamedQuery("Movie.findByName", Movie.class);
			query.setParameter("name", name);
			try{
				List<Movie> listOfMovies = query.getResultList();
				if(listOfMovies != null && !listOfMovies.isEmpty())
					movie = listOfMovies.get(0);
			}catch(NoResultException NRE){
				
			}
		}
        return movie;
	}

	@Override
	public List<String> days() {
		
		List<String> daysOfWeek = new ArrayList<String>();
		
		daysOfWeek.add("poniedzia³ek");
		daysOfWeek.add("wtorek");
		daysOfWeek.add("œroda");
		daysOfWeek.add("czwartek");
		daysOfWeek.add("pi¹tek");
		daysOfWeek.add("sobota");
		daysOfWeek.add("niedziela");
		
		return daysOfWeek;
	}
}
