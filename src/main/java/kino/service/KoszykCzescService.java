package kino.service;

import java.util.List;

import kino.domain.KoszykCzesc;

public interface KoszykCzescService {

	public void save(KoszykCzesc koszykItem);
	public List<KoszykCzesc> getAll();
	public void update(KoszykCzesc koszykItem);
	public KoszykCzesc find(Long id);
	public void delete();
}
