package kino.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kino.domain.BasketItem;
import kino.domain.Seans;
import kino.repository.BasketItemRepository;

@Repository
@Transactional
public class BasketItemRepositoryImpl implements BasketItemRepository {

	@PersistenceContext
	private EntityManager emManager;
	
	public BasketItemRepositoryImpl(){};
	
	@Override
	public void save(BasketItem basketItem) {
		List<BasketItem> basketItemList = getAll();
		boolean save = true;
		
		if(!basketItemList.isEmpty()){
			for(BasketItem item: basketItemList){
				if(item.getSeans().equals(basketItem.getSeans())){ 
					if(item.getPosition().getPlace().equals(basketItem.getPosition().getPlace())){
						if(item.getPosition().getRaw().equals(basketItem.getPosition().getRaw())){
							save = false;
						}
					}
				}
			}
		}
		
		if(save){
			emManager.persist(basketItem);
		}
		
	}

	@Override
	public List<BasketItem> getAll() {
		return emManager.createQuery("SELECT b FROM BasketItem b", BasketItem.class).getResultList();
	}

	@Override
	public void update(BasketItem basketItem) {
		emManager.merge(basketItem);	
	}

	@Override
	public BasketItem find(Long id) throws NullPointerException{
		
		BasketItem basketItem = emManager.find(BasketItem.class, id);
		
		if(basketItem == null){
			throw new NullPointerException("Podany Item nie istnieje!");
		}
		return basketItem; 
	}

	
	
	
	@Override
	public void delete() {
			
		if(emManager == null){
				throw new NullPointerException("emManager null!");
			}else{
				final Query query = emManager.createQuery("DELETE FROM BasketItem b");
				final int executeUpdate = query.executeUpdate();
				
			}
		
	}

}
