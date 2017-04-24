package kino.service;

import java.util.List;

import kino.domain.User;
import kino.domain.UserRoles;

public interface UserRolesService {

	public List<UserRoles> getAllUserRoles();
	public void save(UserRoles rola);
	public UserRoles getUserRoleById(Long id);
}
