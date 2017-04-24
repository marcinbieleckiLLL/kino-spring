package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.User;
import kino.domain.UserRoles;
import kino.repository.UserRepository;
import kino.repository.UserRolesRepository;
import kino.service.UserRolesService;


@Service
public class UserRolesServiceImpl implements UserRolesService {

	@Autowired
	UserRolesRepository userRolesRepository;
	

	@Override
	public List<UserRoles> getAllUserRoles() {
		return userRolesRepository.getAllUserRoles();
	}

	@Override
	public void save(UserRoles rola) {
		userRolesRepository.save(rola);
		
	}

	@Override
	public UserRoles getUserRoleById(Long id) {
		return userRolesRepository.getUserRoleById(id);
	}

}