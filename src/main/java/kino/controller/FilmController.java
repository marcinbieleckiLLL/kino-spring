package kino.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import kino.insert.FilmInsert;
import kino.service.FilmService;



@Controller
@SessionAttributes("Filmy")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	
	@RequestMapping("/")
	public String start(Model model){
		
		FilmInsert filmInsert = new FilmInsert();
		filmInsert.insert(filmService);	
		model.addAttribute("filmy", filmService.getAll());
		
		return "index";
	}
	
	@RequestMapping("/{nazwa}")
	public String Film(Model model, @PathVariable("nazwa") String nazwa){
		
		model.addAttribute("film", filmService.getFilmByName(nazwa));
		model.addAttribute("dniTygodnia", filmService.days());
			
		return "StronaFilmu2";
	}
	
}
