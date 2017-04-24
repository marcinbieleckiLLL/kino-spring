package kino.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kino.domain.Seans;
import kino.domain.User;
import kino.domain.UserRoles;
import kino.repository.UserRepository;


@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	private EntityManager emManager;
	private User aktualnyUzytkownik;
	
	public User getAktualnyUzytkownik() {
		return aktualnyUzytkownik;
	}

	public void setAktualnyUzytkownik(User aktualnyUzytkownik) {
		if(this.aktualnyUzytkownik == null)
			this.aktualnyUzytkownik = aktualnyUzytkownik;
	}

	public UserRepositoryImpl(){
		
	}
	
	public void save(User uzytkownik){
		List<User> listaUzytkownikow = getAllUsers();
		boolean zapisz = true;
		
		for(User user: listaUzytkownikow){
			if(user.getNazwa() == uzytkownik.getNazwa()){
				zapisz = false;
			}
		}
		if(zapisz){
			emManager.persist(uzytkownik);
		}
	}
	

	@Override
	public List<User> getAllUsers() {
		
		 return emManager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}
	
	public User getUserByNameAndUserRole(User user, UserRoles userRole){
		
		TypedQuery<User> query = emManager.createNamedQuery("User.findUser", User.class);
		query.setParameter("nazwa", user.getNazwa());
		query.setParameter("id", userRole.getId());
			
		User result = new User();
		try{
			result = query.getSingleResult();
		}catch(NoResultException exception){
			
		}
		
		return result;
	}

	@Override
	public User getUserById(Long id) {
		
		return emManager.find(User.class, id);
	}

	@Override
	public void update(User user) {
		emManager.merge(user);		
	}

	@Override
	public User getUserByName(String nazwa) {
		
		TypedQuery<User> query = emManager.createQuery("SELECT u FROM User u WHERE u.nazwa = :nazwa", User.class);
		query.setParameter("nazwa", nazwa);
		
		return query.getSingleResult();
	}	

}
