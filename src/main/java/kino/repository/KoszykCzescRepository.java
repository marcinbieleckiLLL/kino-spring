package kino.repository;

import java.util.List;

import kino.domain.KoszykCzesc;
import kino.domain.Seans;

public interface KoszykCzescRepository {

	public void save(KoszykCzesc koszykCzesc);
	public KoszykCzesc find(Long id);
	public List<KoszykCzesc> getAll();
	public void update(KoszykCzesc koszykCzesc);
	public void delete();
}
