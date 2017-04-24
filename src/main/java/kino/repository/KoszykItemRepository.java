package kino.repository;

import java.util.List;

import kino.domain.KoszykItem;
import kino.domain.Seans;

public interface KoszykItemRepository {

	public void save(KoszykItem koszykItem);
	public KoszykItem find(Long id);
	public List<KoszykItem> getAll();
	public void update(KoszykItem koszykItem);
	public void delete();
}
