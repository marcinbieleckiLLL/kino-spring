package kino.repository;

import java.util.List;

import kino.domain.BasketItem;
import kino.domain.Seans;

public interface BasketItemRepository {

	public void save(BasketItem basketItem);
	public BasketItem find(Long id);
	public List<BasketItem> getAll();
	public void update(BasketItem basketItem);
	public void delete();
}
