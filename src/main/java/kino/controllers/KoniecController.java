package kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kino.domain.Miejsce;
import kino.domain.Seans;
import kino.domain.User;
import kino.service.KoszykItemService;
import kino.service.KoszykService;
import kino.service.MiejsceService;
import kino.service.SeansService;
import kino.service.UserService;

@Controller
public class KoniecController {

	@Autowired
	private MiejsceService miejsceService;
	
	@Autowired
	private SeansService seansService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KoszykItemService koszykItemService;
	
	@Autowired
	private KoszykService koszykService;
	
	@RequestMapping("/koniec")
	public String koniec(Model model){
		
		User user = userService.getAktualnyUzytkownik();
		user.setKoszyk(null);
		userService.update(user);
		
		Seans seans = seansService.getTwojSeans();
		
		koszykItemService.delete();
		koszykService.deleteKoszyk(user);
		List<Miejsce> listaZajetychMiejsc = miejsceService.getZajeteMiejsca(seans);
		for(Miejsce miejsce: listaZajetychMiejsc){
			miejsceService.updateDostepnosc((miejsceService.getMiejsce(miejsce.getRzad(), miejsce.getMiejsce(), seans)), "zajête");
		}
		miejsceService.UsuwanieWszystkichZajetychMiejscZListyZajetychMiejsc();
		

		seans.setKoszykItem(null);
		seansService.update(seans);
		
		return "koniec";
	}
}
