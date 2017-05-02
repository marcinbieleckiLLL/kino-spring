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

import kino.domain.Koszyk;
import kino.domain.KoszykCzesc;
import kino.domain.Miejsce;
import kino.domain.Seans;
import kino.domain.User;
import kino.repository.KoszykRepository;

@Repository
@Transactional
public class KoszykRepositoryImpl implements KoszykRepository {

	
	@PersistenceContext
	private EntityManager emManager;
	
	public KoszykRepositoryImpl(){
		
	}
	
	@Override
	public void update(Koszyk koszyk) {
		emManager.merge(koszyk);
		
	}
	
	@Override
	public Koszyk deleteKoszykCzesc(KoszykCzesc koszykCzesc, User user) {
		
		Koszyk koszyk = read(user);
		List<KoszykCzesc> listaItemow = koszyk.getKoszykCzesci();	
		listaItemow.remove(koszykCzesc);
		koszyk.setKoszykCzesci(listaItemow);
		update(koszyk);
		
		return koszyk;
		
	}
	
	public void deleteKoszyk(User user) throws NullPointerException{
		
		if(user != null){
			if(emManager != null){
				final Query query = emManager.createNamedQuery("Koszyk.deleteKoszyk");
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
	public void create(User user, Koszyk koszykDoZapisu) {
		
		List<Koszyk> ListaKoszykow = read();
		boolean zapisz = true;
		
		if(user == null){
			throw new NullPointerException("Zaloguj siê!");
		}else if(!ListaKoszykow.isEmpty() && ListaKoszykow != null){
				for(Koszyk koszyk: ListaKoszykow){
					if(koszyk.getUser().getId() == user.getId()){
						zapisz = false;
						break;
					}		
				}
			}
		
			if(zapisz){
				koszykDoZapisu.setUser(user);
				emManager.persist(koszykDoZapisu);
			}
		}	
	

	@Override
	public List<Koszyk> read() {
		
		return emManager.createQuery("SELECT k FROM Koszyk k", Koszyk.class).getResultList();
	}

	@Override
	public Koszyk read(User user) {
		
		List<Koszyk> ListaKoszykow = read();
		Koszyk zwracany = new Koszyk();
		
		if(user == null){
			throw new NullPointerException("Zaloguj siê!");
		}
		
		if(ListaKoszykow.isEmpty() || ListaKoszykow == null){
				
			}else{
				for(Koszyk koszyk: ListaKoszykow){
					if(koszyk.getUser().equals(user)){
						zwracany = koszyk;
						
					}
				}
		}	
		
		return zwracany; 
	}

}
