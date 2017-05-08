package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.User;
import kino.domain.UserRoles;
import kino.repository.UserRepository;
import kino.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public User getUserByNameAndUserRole(User user, UserRoles userRole){
		return userRepository.getUserByNameAndUserRole(user, userRole);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getUserById(id);
	}

	@Override
	public void setCurrentUser(User currentUser) {
		userRepository.setCurrentUser(currentUser);
		
	}

	@Override
	public User getCurrentUser() {
		return userRepository.getCurrentUser();
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public User getUserByName(String name) {
		return userRepository.getUserByName(name);
	}

}
