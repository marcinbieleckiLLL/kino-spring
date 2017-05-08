package kino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kino.domain.Position;
import kino.domain.Seans;
import kino.domain.User;
import kino.service.BasketItemService;
import kino.service.BasketService;
import kino.service.PositionService;
import kino.service.SeansService;
import kino.service.UserService;

@Controller
public class EndController {

	@Autowired
	private PositionService positionService;
	
	@Autowired
	private SeansService seansService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BasketItemService basketItemService;
	
	@Autowired
	private BasketService basketService;
	
	@RequestMapping("/koniec")
	public String koniec(Model model){
		
		User user = userService.getCurrentUser();
		user.setBasket(null);
		userService.update(user);
		
		Seans seans = seansService.getCurrentSeans();
		
		basketItemService.delete();
		basketService.deleteBasket(user);
		List<Position> listOfBusyPositions = positionService.getBusyPositions(seans);
		for(Position miejsce: listOfBusyPositions){
			positionService.updateAvailability((positionService.getPosition(miejsce.getRaw(), miejsce.getPlace(), seans)), "zajête");
		}
		positionService.deleteAllTemporaryBusyPositionsFromList();
		

		seans.setBasketItems(null);
		seansService.update(seans);
		
		return "end";
	}
}
