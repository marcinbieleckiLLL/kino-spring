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

import kino.domain.Koszyk;
import kino.domain.KoszykCzesc;
import kino.domain.Miejsce;
import kino.domain.Seans;
import kino.domain.User;
import kino.model.KoszykItemModel;
import kino.model.MiejsceModel;
import kino.service.KoszykCzescService;
import kino.service.KoszykService;
import kino.service.MiejsceService;
import kino.service.SeansService;
import kino.service.UserService;

@Controller
@SessionAttributes("Koszyk")
@RequestMapping("/koszyk")
public class KoszykController{

	@Autowired
	private MiejsceService miejsceService;
	
	@Autowired
	private SeansService seansService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KoszykCzescService koszykItemService;
	
	@Autowired
	private KoszykService koszykService;
	
	private boolean czyUstawicUserowiKoszyk = true;
	
	@RequestMapping("/index")
	public String KoszykIndex(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		
		if(userService.getAktualnyUzytkownik() == null){
			userService.setAktualnyUzytkownik(userService.getUserByName(name));
		}
		
		Seans seans = seansService.getTwojSeans();
			
		List<Miejsce> listaChwilowoZajetychMiejsc = miejsceService.getListaChwilowoZajetychMiejsc();
		
		if(!listaChwilowoZajetychMiejsc.isEmpty()){
			List<KoszykCzesc> koszykItems = new ArrayList<KoszykCzesc>();
			
			int cenaKoszykItem = 20;
			int cenaKoszyk = 0;
			Koszyk koszyk = new Koszyk();
			
			for(Miejsce miejsce: listaChwilowoZajetychMiejsc){
				KoszykCzesc koszykItem = new KoszykCzesc(seansService.getTwojSeans(), miejsceService.getMiejsce(miejsce.getRzad(), miejsce.getMiejsce(), seans), cenaKoszykItem);
				koszykItems.add(koszykItem);
				cenaKoszyk = cenaKoszyk + koszykItem.getCena();
			}
			koszyk.setCena(cenaKoszyk);
			koszyk.setKoszykCzesci(koszykItems);
			koszyk.setUser(userService.getAktualnyUzytkownik());
			koszykService.create(userService.getAktualnyUzytkownik(), koszyk);
			
			if(czyUstawicUserowiKoszyk){
				userService.getAktualnyUzytkownik().setKoszyk(koszykService.read(userService.getAktualnyUzytkownik()));
			}else{
				userService.getAktualnyUzytkownik().setKoszyk(null);
				czyUstawicUserowiKoszyk = true;
			}
			userService.update(userService.getAktualnyUzytkownik());
			
			seansService.getTwojSeans().setKoszykCzesci(koszykItems);
			
			for(Miejsce m:listaChwilowoZajetychMiejsc){
				m.setKoszykCzesci(koszykItems);
			}
			
			for(KoszykCzesc item:koszykItems){
				item.setKoszyk(koszykService.read(userService.getAktualnyUzytkownik()));
				koszykItemService.save(item);
			}
		}
		
		model.addAttribute("koszyk", koszykService.read(userService.getAktualnyUzytkownik()));
		
		return "koszyk";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)	
	public void DeleteKoszyk(){
		
		User user = userService.getAktualnyUzytkownik();
		user.setKoszyk(null);
		userService.update(user);
		this.czyUstawicUserowiKoszyk = false;
		
		Seans seans = seansService.getTwojSeans();
		seans.setKoszykCzesci(null);
		seansService.update(seans);
		
		List<Miejsce> ListaMiejsc = miejsceService.getListaChwilowoZajetychMiejsc();
		for(Miejsce m: ListaMiejsc){
			m.setKoszykCzesci(null);
			miejsceService.update(m);
		}
		koszykItemService.delete();
		koszykService.deleteKoszyk(user);
		miejsceService.deleteChwilowoZajeteMiejscaFromDatabase(seansService.getTwojSeans());
		miejsceService.deleteAllChwilowoZajeteMiejscaFromList();
		miejsceService.getListaChwilowoZajetychMiejsc();
		
		
	}
	
}

