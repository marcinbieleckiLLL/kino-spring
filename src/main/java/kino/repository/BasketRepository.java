package kino.repository;

import java.util.List;

import kino.domain.Basket;
import kino.domain.BasketItem;
import kino.domain.Position;
import kino.domain.Seans;
import kino.domain.User;

public interface BasketRepository {

	public void update(Basket basket);
	public Basket deleteBasketItem(BasketItem basketItem, User user);
	public void create(User user, Basket basketToSave);
	public List<Basket> read();
	public Basket read(User user);
	public void daleteBasket(User user);
}
