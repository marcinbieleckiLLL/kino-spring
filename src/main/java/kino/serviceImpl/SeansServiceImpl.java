package kino.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.Film;
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
	public List<Seans> getSeansByFilmNameAndDay(Film film, String dzien) {
		return seansRepository.getSeansByFilmNameAndDay(film, dzien);
	}

	@Override
	public List<String> createList(String atrybut1, String atrybut2, String atrybut3, String atrybut4) {
		return seansRepository.createList(atrybut1, atrybut2, atrybut3, atrybut4);
	}

	@Override
	public Seans getSeansByFilmNameAndDayAndHour(String godzina) {
		return seansRepository.getSeansByFilmNameAndDayAndHour(godzina);
	}

	@Override
	public Seans getTwojSeans() {
		return seansRepository.getTwojSeans();
	}

	@Override
	public void update(Seans seans) {
		seansRepository.update(seans);
	}

}
