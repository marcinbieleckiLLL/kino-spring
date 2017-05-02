package kino.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kino.domain.KoszykCzesc;
import kino.domain.Seans;
import kino.repository.KoszykCzescRepository;

@Repository
@Transactional
public class KoszykCzescRepositoryImpl implements KoszykCzescRepository {

	@PersistenceContext
	private EntityManager emManager;
	
	public KoszykCzescRepositoryImpl(){};
	
	@Override
	public void save(KoszykCzesc koszykCzesc) {
		List<KoszykCzesc> listaKoszykItemow = getAll();
		boolean zapisz = true;
		
		if(!listaKoszykItemow.isEmpty()){
			for(KoszykCzesc item: listaKoszykItemow){
				if(item.getSeans().equals(koszykCzesc.getSeans())){ 
					if(item.getMiejsce().getMiejsce().equals(koszykCzesc.getMiejsce().getMiejsce())){
						if(item.getMiejsce().getRzad().equals(koszykCzesc.getMiejsce().getRzad())){
							zapisz = false;
						}
					}
				}
			}
		}
		
		if(zapisz){
			emManager.persist(koszykCzesc);
		}
		
	}

	@Override
	public List<KoszykCzesc> getAll() {
		return emManager.createQuery("SELECT k FROM KoszykCzesc k", KoszykCzesc.class).getResultList();
	}

	@Override
	public void update(KoszykCzesc koszykCzesc) {
		emManager.merge(koszykCzesc);	
	}

	@Override
	public KoszykCzesc find(Long id) throws NullPointerException{
		
		KoszykCzesc koszykCzesc = emManager.find(KoszykCzesc.class, id);
		
		if(koszykCzesc == null){
			throw new NullPointerException("Podany Item nie istnieje!");
		}
		return koszykCzesc; 
	}

	
	
	
	@Override
	public void delete() {
			
		if(emManager == null){
				throw new NullPointerException("emManager null!");
			}else{
				final Query query = emManager.createQuery("DELETE FROM KoszykCzesc k");
				final int executeUpdate = query.executeUpdate();
				
			}
		
	}

}
