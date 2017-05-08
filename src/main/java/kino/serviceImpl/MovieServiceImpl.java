package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.Movie;
import kino.repository.MovieRepository;
import kino.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieRepository filmRepository;
	
	@Override
	public List<Movie> getAll() {
		return filmRepository.getAll();
	}

	@Override
	public void save(Movie film, String nazwa) {
		filmRepository.save(film, nazwa);
	}

	@Override
	public Movie getFilmById(Long id) {
		return filmRepository.getFilmById(id);
	}

	@Override
	public Movie getFilmByName(String nazwa) {
		return filmRepository.getFilmByName(nazwa);
	}

	@Override
	public List<String> days() {
		
		return filmRepository.days();
	}

}
