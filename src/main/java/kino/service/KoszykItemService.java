package kino.service;

import java.util.List;

import kino.domain.KoszykItem;

public interface KoszykItemService {

	public void save(KoszykItem koszykItem);
	public List<KoszykItem> getAll();
	public void update(KoszykItem koszykItem);
	public KoszykItem find(Long id);
	public void delete();
}
