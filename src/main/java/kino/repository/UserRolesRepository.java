package kino.repository;

import java.util.List;

import kino.domain.User;
import kino.domain.UserRoles;

public interface UserRolesRepository {
	
	public List<UserRoles> getAllUserRoles();
	public void save(UserRoles rola);
	public UserRoles getUserRoleById(Long id);
}
