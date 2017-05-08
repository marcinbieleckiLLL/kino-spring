package kino.service;

import java.util.List;
import java.util.Map;

import kino.domain.Movie;
import kino.domain.Seans;

public interface SeansService {
	
	public List<Seans> getAll();
	public void save(Seans seans);
	public List<Seans> getSeansByFilmNameAndDay(Movie movie, String day);
	public Seans getSeansByFilmNameAndDayAndHour(String hour);
	public List<String> createList(String attribute1, String attribute2, String attribute3, String attribute4);
	public Seans getCurrentSeans();
	public void update(Seans seans);
}
