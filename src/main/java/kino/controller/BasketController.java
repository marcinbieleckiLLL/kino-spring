package kino.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kino.domain.Basket;
import kino.domain.BasketItem;
import kino.domain.Position;
import kino.domain.Seans;
import kino.domain.User;
import kino.model.BasketItemModel;
import kino.model.PositionModel;
import kino.service.BasketItemService;
import kino.service.BasketService;
import kino.service.PositionService;
import kino.service.SeansService;
import kino.service.UserService;

@Controller
@SessionAttributes("Koszyk")
@RequestMapping("/koszyk")
public class BasketController{

	@Autowired
	private PositionService positionService;
	
	@Autowired
	private SeansService seansService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BasketItemService basketkItemService;
	
	@Autowired
	private BasketService basketkService;
	
	private boolean ifSetUserBasket = true;
	
	@RequestMapping("/index")
	public String KoszykIndex(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		
		if(userService.getCurrentUser() == null){
			userService.setCurrentUser(userService.getUserByName(name));
		}
		
		Seans seans = seansService.getCurrentSeans();
			
		List<Position> listOfTemporaryBusyPositions = positionService.getListOfTemporaryBusyPositions();
		
		if(!listOfTemporaryBusyPositions.isEmpty()){
			List<BasketItem> basketItems = new ArrayList<BasketItem>();
			
			int priceBasketItem = 20;
			int priceBasket = 0;
			Basket basket = new Basket();
			
			for(Position position: listOfTemporaryBusyPositions){
				BasketItem basketItem = new BasketItem(seansService.getCurrentSeans(), positionService.getPosition(position.getRaw(), position.getPlace(), seans), priceBasketItem);
				basketItems.add(basketItem);
				priceBasket = priceBasket + basketItem.getPrice();
			}
			basket.setPrice(priceBasket);
			basket.setBasketItems(basketItems);
			basket.setUser(userService.getCurrentUser());
			basketkService.create(userService.getCurrentUser(), basket);
			
			if(ifSetUserBasket){
				userService.getCurrentUser().setBasket(basketkService.read(userService.getCurrentUser()));
			}else{
				userService.getCurrentUser().setBasket(null);
				ifSetUserBasket = true;
			}
			userService.update(userService.getCurrentUser());
			
			seansService.getCurrentSeans().setBasketItems(basketItems);
			
			for(Position m:listOfTemporaryBusyPositions){
				m.setBasketItems(basketItems);
			}
			
			for(BasketItem item:basketItems){
				item.setBasket(basketkService.read(userService.getCurrentUser()));
				basketkItemService.save(item);
			}
		}
		
		model.addAttribute("basket", basketkService.read(userService.getCurrentUser()));
		
		return "basket";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)	
	public void DeleteKoszyk(){
		
		User user = userService.getCurrentUser();
		user.setBasket(null);
		userService.update(user);
		this.ifSetUserBasket = false;
		
		Seans seans = seansService.getCurrentSeans();
		seans.setBasketItems(null);
		seansService.update(seans);
		
		List<Position> listOfPositions = positionService.getListOfTemporaryBusyPositions();
		for(Position m: listOfPositions){
			m.setBasketItems(null);
			positionService.update(m);
		}
		basketkItemService.delete();
		basketkService.deleteBasket(user);
		positionService.deleteTemporaryBusyPositionsFromDatabase(seansService.getCurrentSeans());
		positionService.deleteAllTemporaryBusyPositionsFromList();
		positionService.getListOfTemporaryBusyPositions();
		
		
	}
	
}

