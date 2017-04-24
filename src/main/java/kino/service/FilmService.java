package kino.service;

import java.util.List;

import kino.domain.Film;

public interface FilmService {
	public List<Film> getAll();
	public void save(Film film, String nazwa);
	public Film getFilmById(Long id);
	public Film getFilmByName(String nazwa);
	public List<String> dniTygodnia();
}
