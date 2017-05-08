package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.Basket;
import kino.domain.BasketItem;
import kino.domain.User;
import kino.repository.BasketRepository;
import kino.service.BasketService;

@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	BasketRepository koszykRepository;
	
	@Override
	public void update(Basket basket) {
		koszykRepository.update(basket);
		
	}

	@Override
	public Basket deleteBasketItem(BasketItem basketItem, User user) {
		return koszykRepository.deleteBasketItem(basketItem, user);
		
	}

	@Override
	public void create(User user, Basket basketToSave) {
		koszykRepository.create(user, basketToSave);
		
	}

	@Override
	public List<Basket> read() {
		return koszykRepository.read();
	}

	@Override
	public Basket read(User user) {
		return koszykRepository.read(user);
	}

	@Override
	public void deleteBasket(User user) {
		koszykRepository.daleteBasket(user);
	}

}
