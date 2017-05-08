package kino.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import kino.insert.MovieInsert;
import kino.service.MovieService;



@Controller
@SessionAttributes("Filmy")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	
	@RequestMapping("/")
	public String start(Model model){
		
		MovieInsert filmInsert = new MovieInsert();
		filmInsert.insert(movieService);	
		model.addAttribute("movies", movieService.getAll());
		
		return "index";
	}
	
	@RequestMapping("/{name}")
	public String Film(Model model, @PathVariable("name") String name){
		
		model.addAttribute("movie", movieService.getFilmByName(name));
		model.addAttribute("days", movieService.days());
			
		return "movie2";
	}
	
}
