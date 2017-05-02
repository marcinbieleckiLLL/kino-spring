package kino.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import kino.domain.Seans;
import kino.insert.MiejsceInsert;
import kino.insert.SeansInsert;
import kino.model.Godziny;
import kino.service.FilmService;
import kino.service.MiejsceService;
import kino.service.SeansService;

@Controller
@SessionAttributes("Seans")
@RequestMapping("/seans")
public class SeansController {

	@Autowired
	private FilmService filmService;
	
	@Autowired
	private SeansService seansService;
	
	@Autowired
	private MiejsceService miejsceService;
	
	
	@RequestMapping(value = "/rest", method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody List<Seans> seans(@RequestBody Godziny request){
		
		String dzien = request.getDzien().toString();
		String nazwa = request.getNazwa().toString();
		
		SeansInsert seansInsert = new SeansInsert();
		seansInsert.seansInsert(seansService, filmService, dzien, nazwa);
		
		return seansService.getSeansByFilmNameAndDay(filmService.getFilmByName(nazwa), dzien);
		
	}
	
	
	@RequestMapping("/{godzina}")
	public String miejsce(Model model, @PathVariable("godzina") String godzina){
		
		Seans seans = seansService.getSeansByFilmNameAndDayAndHour(godzina);
		MiejsceInsert miejsceInsert = new MiejsceInsert();
		miejsceInsert.insert(miejsceService, seans);
		
		model.addAttribute("seans", seans);
		model.addAttribute("miejsca1", miejsceService.getColumn("1", seans));
		model.addAttribute("miejsca2", miejsceService.getColumn("2", seans));
		model.addAttribute("miejsca3", miejsceService.getColumn("3", seans));
		
		return "miejsca";
		
	}
}
