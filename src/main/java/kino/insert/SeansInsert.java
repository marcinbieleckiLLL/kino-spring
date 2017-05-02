package kino.insert;

import java.util.List;

import kino.domain.Film;
import kino.domain.Seans;
import kino.service.FilmService;
import kino.service.SeansService;

public class SeansInsert {

	public SeansInsert(){};
	
	public void seansInsert(SeansService seansService, FilmService filmService, String dzien, String nazwa){
		
		Film film = filmService.getFilmByName(nazwa);

		List<String> dniTygodnia = filmService.days();
		List<String> napisy = seansService.createList("napisy", "lektor", "dubbing", "napisy");
		List<String> typ = seansService.createList("2d", "2d", "3d", "3d");
		List<String> godziny = seansService.createList("12:00", "13:30", "16:00", "19:15");
		int iloscSeansowWDanymDniu = godziny.size();
		
		for(String dzienTyg: dniTygodnia){
			for(int i=0;i<iloscSeansowWDanymDniu;i++){
				Seans seans = new Seans(dzienTyg, film, "PL");
				seans.setGodzina(godziny.get(i));
				seans.setNapisy(napisy.get(i));
				seans.setTyp(typ.get(i));
				seansService.save(seans);
			}
		}
	}
}
