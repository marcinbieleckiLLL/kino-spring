package kino.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kino.domain.KoszykItem;
import kino.domain.Seans;
import kino.repository.KoszykItemRepository;

@Repository
@Transactional
public class KoszykItemRepositoryImpl implements KoszykItemRepository {

	@PersistenceContext
	private EntityManager emManager;
	
	public KoszykItemRepositoryImpl(){};
	
	@Override
	public void save(KoszykItem koszykItem) {
		List<KoszykItem> listaKoszykItemow = getAll();
		boolean zapisz = true;
		
		if(!listaKoszykItemow.isEmpty()){
			for(KoszykItem item: listaKoszykItemow){
				if(item.getSeans().equals(koszykItem.getSeans())){ 
					if(item.getMiejsce().getMiejsce().equals(koszykItem.getMiejsce().getMiejsce())){
						if(item.getMiejsce().getRzad().equals(koszykItem.getMiejsce().getRzad())){
							zapisz = false;
						}
					}
				}
			}
		}
		
		if(zapisz){
			emManager.persist(koszykItem);
		}
		
	}

	@Override
	public List<KoszykItem> getAll() {
		return emManager.createQuery("SELECT k FROM KoszykItem k", KoszykItem.class).getResultList();
	}

	@Override
	public void update(KoszykItem koszykItem) {
		emManager.merge(koszykItem);	
	}

	@Override
	public KoszykItem find(Long id) throws NullPointerException{
		
		KoszykItem koszykItem = emManager.find(KoszykItem.class, id);
		
		if(koszykItem == null){
			throw new NullPointerException("Podany Item nie istnieje!");
		}
		return koszykItem; 
	}

	
	
	
	@Override
	public void delete() {
			
		if(emManager == null){
				throw new NullPointerException("emManager null!");
			}else{
				final Query query = emManager.createQuery("DELETE FROM KoszykItem k");
				final int executeUpdate = query.executeUpdate();
				
			}
		
	}

}
