package kino.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.Movie;
import kino.domain.Seans;
import kino.repository.SeansRepository;
import kino.service.SeansService;

@Service
public class SeansServiceImpl implements SeansService {

	@Autowired
	SeansRepository seansRepository;
	
	
	@Override
	public List<Seans> getAll() {
		
		return seansRepository.getAll();
	}

	@Override
	public void save(Seans seans) {
		seansRepository.save(seans);
	}

	@Override
	public List<Seans> getSeansByFilmNameAndDay(Movie movie, String day) {
		return seansRepository.getSeansByFilmNameAndDay(movie, day);
	}

	@Override
	public List<String> createList(String attribute1, String attribute2, String attribute3, String attribute4) {
		return seansRepository.createList(attribute1, attribute2, attribute3, attribute4);
	}

	@Override
	public Seans getSeansByFilmNameAndDayAndHour(String hour) {
		return seansRepository.getSeansByFilmNameAndDayAndHour(hour);
	}

	@Override
	public Seans getCurrentSeans() {
		return seansRepository.getYourSeans();
	}

	@Override
	public void update(Seans seans) {
		seansRepository.update(seans);
	}

}
