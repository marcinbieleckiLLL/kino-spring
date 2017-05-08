package kino.repository;

import java.util.List;

import kino.domain.Movie;

public interface MovieRepository  {
	public List<Movie> getAll();
	public void save(Movie movie, String name);
	public Movie getFilmById(Long id);
	public Movie getFilmByName(String name);
	public List<String> days();
}
