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
import kino.insert.PositionInsert;
import kino.insert.SeansInsert;
import kino.model.Hours;
import kino.service.MovieService;
import kino.service.PositionService;
import kino.service.SeansService;

@Controller
@SessionAttributes("Seans")
@RequestMapping("/seans")
public class SeansController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private SeansService seansService;
	
	@Autowired
	private PositionService positionService;
	
	
	@RequestMapping(value = "/rest", method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody List<Seans> seans(@RequestBody Hours request){
		
		String day = request.getDay().toString();
		String name = request.getName().toString();
		
		SeansInsert seansInsert = new SeansInsert();
		seansInsert.seansInsert(seansService, movieService, day, name);
		
		return seansService.getSeansByFilmNameAndDay(movieService.getFilmByName(name), day);
		
	}
	
	
	@RequestMapping("/{godzina}")
	public String miejsce(Model model, @PathVariable("godzina") String godzina){
		
		Seans seans = seansService.getSeansByFilmNameAndDayAndHour(godzina);
		PositionInsert miejsceInsert = new PositionInsert();
		miejsceInsert.insert(positionService, seans);
		
		model.addAttribute("seans", seans);
		model.addAttribute("positions1", positionService.getColumn("1", seans));
		model.addAttribute("positions2", positionService.getColumn("2", seans));
		model.addAttribute("positions3", positionService.getColumn("3", seans));
		
		return "positions";
		
	}
}
