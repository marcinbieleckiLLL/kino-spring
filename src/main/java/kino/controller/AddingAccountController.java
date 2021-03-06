package kino.controller;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import kino.domain.User;
import kino.domain.UserRoles;
import kino.service.UserRolesService;
import kino.service.UserService;


@Controller
@SessionAttributes("User") 
public class AddingAccountController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRolesService userRolesService;
	
	@RequestMapping(value = "/addAccount", method = RequestMethod.GET)
	public String Add(Model model){
		User user =  new User();
		model.addAttribute("nowyUser", user);
		return "addingAccount";
	}
	
	@RequestMapping(value = "/addAccount", method=RequestMethod.POST)
	public String postAddNewProduct(@ModelAttribute("nowyUser") User user , BindingResult result){
		
		UserRoles userRoles = new UserRoles("ROLE_ADMIN");
		Set<User> userList = new HashSet<User>();
		user.setEnabled("true");
		userList.add(user);
		userRoles.setUsers(userList);
		user.setUserRole(userRoles);  
		userRolesService.save(userRoles);
		userService.save(user);
		userService.setCurrentUser(user);
	
		return "redirect:/login";
	}
}
