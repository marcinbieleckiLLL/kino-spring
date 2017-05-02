package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.Film;
import kino.repository.FilmRepository;
import kino.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	FilmRepository filmRepository;
	
	@Override
	public List<Film> getAll() {
		return filmRepository.getAll();
	}

	@Override
	public void save(Film film, String nazwa) {
		filmRepository.save(film, nazwa);
	}

	@Override
	public Film getFilmById(Long id) {
		return filmRepository.getFilmById(id);
	}

	@Override
	public Film getFilmByName(String nazwa) {
		return filmRepository.getFilmByName(nazwa);
	}

	@Override
	public List<String> days() {
		
		return filmRepository.days();
	}

}
