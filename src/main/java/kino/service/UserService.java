package kino.service;

import java.util.List;

import kino.domain.User;
import kino.domain.UserRoles;

public interface UserService {
	
	public void save(User user);
	public List<User> getAllUsers();
	public User getUserByNameAndUserRole(User user,UserRoles userRole);
	public User getUserById(Long id);
	public void setAktualnyUzytkownik(User aktualnyUzytkownik);
	public User getAktualnyUzytkownik();
	public void update(User user);
	public User getUserByName(String nazwa);
}
