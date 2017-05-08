package kino.service;

import java.util.List;

import kino.domain.Movie;

public interface MovieService  {
	public List<Movie> getAll();
	public void save(Movie movie, String name);
	public Movie getFilmById(Long id);
	public Movie getFilmByName(String name);
	public List<String> days();
}
