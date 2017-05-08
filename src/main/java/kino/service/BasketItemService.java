package kino.service;

import java.util.List;

import kino.domain.BasketItem;

public interface BasketItemService {

	public void save(BasketItem basketItem);
	public BasketItem find(Long id);
	public List<BasketItem> getAll();
	public void update(BasketItem basketItem);
	public void delete();
}
