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

import kino.domain.Movie;
import kino.domain.Seans;
import kino.model.Hours;
import kino.model.PositionModel;
import kino.service.PositionService;
import kino.service.SeansService;

@Controller
@SessionAttributes("Miejsce")
@RequestMapping("/miejsce")
public class PositionController {

	@Autowired
	private PositionService miejsceService;
	
	@Autowired
	private SeansService seansService;
	
	@RequestMapping(value = "/rest/dodaj", method = RequestMethod.POST, consumes = {"application/json"})
	public void DodajMiejsce(@RequestBody PositionModel request){
		
		String raw = request.getRaw();
		String position = request.getPlace();	
		Seans seans = seansService.getCurrentSeans();
		miejsceService.addTemporaryBusyPositionToList(raw, position);
		miejsceService.updateAvailability(miejsceService.getPosition(raw, position, seans), "chwilowoZajête");
	
	}
	
	@RequestMapping(value = "/rest/cofnij", method = RequestMethod.POST)
	public void Cofnij(){
		Seans seans = seansService.getCurrentSeans();
		kino.domain.Position position = miejsceService.getLastBusyPosition();
		miejsceService.deleteTemporaryBusyPositionFromList();
		miejsceService.updateAvailability(miejsceService.getPosition(position.getRaw(), position.getPlace(), seans), "wolne");
	}
}
