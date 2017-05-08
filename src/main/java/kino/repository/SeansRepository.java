package kino.repository;

import java.util.List;
import java.util.Map;

import kino.domain.Movie;
import kino.domain.Seans;



public interface SeansRepository {
	
	public List<Seans> getAll();
	public void save(Seans seans);
	public List<Seans> getSeansByFilmNameAndDay(Movie movie, String day);
	public Seans getSeansByFilmNameAndDayAndHour(String hour);
	public List<String> createList(String atributte1, String atributte2, String atributte3, String atributte4);
	public Seans getYourSeans();
	public void update(Seans seans);
}
