package kino.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kino.domain.User;
import kino.domain.UserRoles;
import kino.repository.UserRepository;
import kino.repository.UserRolesRepository;

@Repository
@Transactional
public class UserRolesRepositoryImpl implements UserRolesRepository {

	@PersistenceContext
	private EntityManager emManager;
	
	public UserRolesRepositoryImpl(){
		
	}
	
	@Override
	public List<UserRoles> getAllUserRoles() {
		
		 return emManager.createQuery("SELECT u FROM UserRoles u", UserRoles.class).getResultList();
	}

	@Override
	public void save(UserRoles role) {
		
		emManager.persist(role);
	
	}

	@Override
	public UserRoles getUserRoleById(Long id) {
		
		return emManager.find(UserRoles.class, id);
	}

}
