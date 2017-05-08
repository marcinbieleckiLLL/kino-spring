package kino.repositoryImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kino.domain.Basket;
import kino.domain.BasketItem;
import kino.domain.Position;
import kino.domain.Seans;
import kino.domain.User;
import kino.repository.BasketRepository;

@Repository
@Transactional
public class BasketRepositoryImpl implements BasketRepository {

	
	@PersistenceContext
	private EntityManager emManager;
	
	public BasketRepositoryImpl(){
		
	}
	
	@Override
	public void update(Basket basket) {
		emManager.merge(basket);
		
	}
	
	@Override
	public Basket deleteBasketItem(BasketItem basketItem, User user) {
		
		Basket basket = read(user);
		List<BasketItem> listOfItems = basket.getBasketItems();	
		listOfItems.remove(basketItem);
		basket.setBasketItems(listOfItems);
		update(basket);
		
		return basket;
		
	}
	
	public void daleteBasket(User user) throws NullPointerException{
		
		if(user != null){
			if(emManager != null){
				final Query query = emManager.createNamedQuery("Basket.deleteBasket");
				query.setParameter("id", user.getId());
				final int executeUpdate = query.executeUpdate();
			}else{
				throw new NullPointerException("emManager = null");
			}
		}else{
			throw new NullPointerException("Podany u¿ytkownik nie istnieje");
		}
	}

	@Override
	public void create(User user, Basket basketToSave) {
		
		List<Basket> listOfBaskets = read();
		boolean save = true;
		
		if(user == null){
			throw new NullPointerException("Zaloguj siê!");
		}else if(!listOfBaskets.isEmpty() && listOfBaskets != null){
				for(Basket koszyk: listOfBaskets){
					if(koszyk.getUser().getId() == user.getId()){
						save = false;
						break;
					}		
				}
			}
		
			if(save){
				basketToSave.setUser(user);
				emManager.persist(basketToSave);
			}
		}	
	

	@Override
	public List<Basket> read() {
		
		return emManager.createQuery("SELECT b FROM Basket b", Basket.class).getResultList();
	}

	@Override
	public Basket read(User user) {
		
		List<Basket> listOfBaskets = read();
		Basket result = new Basket();
		
		if(user == null){
			throw new NullPointerException("Zaloguj siê!");
		}
		
		if(listOfBaskets.isEmpty() || listOfBaskets == null){
				
			}else{
				for(Basket koszyk: listOfBaskets){
					if(koszyk.getUser().equals(user)){
						result = koszyk;
						
					}
				}
		}	
		
		return result; 
	}

}
