package kino.repository;

import java.util.List;
import java.util.Map;

import kino.domain.Film;
import kino.domain.Seans;



public interface SeansRepository {
	
	public List<Seans> getAll();
	public void save(Seans seans);
	public List<Seans> getSeansByFilmNameAndDay(Film film, String dzien);
	public Seans getSeansByFilmNameAndDayAndHour(String godzina);
	public List<String> TworzenieListy(String atrybut1, String atrybut2, String atrybut3, String atrybut4);
	public Seans getTwojSeans();
	public void update(Seans seans);
}
