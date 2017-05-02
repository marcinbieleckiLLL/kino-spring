package kino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kino.domain.Film;
import kino.domain.Seans;
import kino.model.Godziny;
import kino.model.MiejsceModel;
import kino.service.MiejsceService;
import kino.service.SeansService;

@Controller
@SessionAttributes("Miejsce")
@RequestMapping("/miejsce")
public class MiejsceController {

	@Autowired
	private MiejsceService miejsceService;
	
	@Autowired
	private SeansService seansService;
	
	@RequestMapping(value = "/rest/dodaj", method = RequestMethod.POST, consumes = {"application/json"})
	public void DodajMiejsce(@RequestBody MiejsceModel request){
		
		String rzad = request.getRzad();
		String miejsce = request.getMiejsce();	
		Seans seans = seansService.getTwojSeans();
		miejsceService.addChwilowoZajeteMiejsceToList(rzad, miejsce);
		miejsceService.updateDostepnosc(miejsceService.getMiejsce(rzad, miejsce, seans), "chwilowoZajête");
	
	}
	
	@RequestMapping(value = "/rest/cofnij", method = RequestMethod.POST)
	public void Cofnij(){
		Seans seans = seansService.getTwojSeans();
		kino.domain.Miejsce miejsce = miejsceService.getOstatnieZajeteMiejsce();
		miejsceService.deleteChwilowoZajeteMiejsceFromList();
		miejsceService.updateDostepnosc(miejsceService.getMiejsce(miejsce.getRzad(), miejsce.getMiejsce(), seans), "wolne");
	}
}
