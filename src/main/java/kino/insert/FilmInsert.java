package kino.insert;

import org.springframework.beans.factory.annotation.Autowired;

import kino.domain.Film;
import kino.service.FilmService;

public class FilmInsert {
	
	public FilmInsert() {
		super();
	}
	
	public void insert(FilmService filmService){
		
		Film film1 = new Film("Piêkna i Bestia","129 min", "Emma Watson, Dan Stevens", "Fantasy, Musical, Romans", "+ 12", "Bill Condon", "7,4", "2017", "Bella gotowa jest zamieszkaæ w zamku potwora, aby ratowaæ ojca. Z czasem miêdzy dziewczyn¹ a besti¹ zaczyna rodziæ siê uczucie. Jednoczeœnie o rêkê Belli zabiega przystojny myœliwy Gaston. ");
		Film film2 = new Film("Wszystko albo nic", "107 min", "Tatiana Pauhofová, Klára Issová", "Komedia Romantyczna", "+ 12", "Marta Ferencová", "5,0", "2017", "Dwóch przystojnych mê¿czyzn walczy o serce piêknej dziewczyny. ");
		Film film3 = new Film("Logan Wolverine", "137 min", "Hugh Jackman, Patrick Stewart", "Dramat, Akcja, Sci-Fi", "+ 15", "James Mangold", "8,1", "2017", "Trac¹cy moc Logan staje siê mentorem ma³ej dziewczynki, która posiada podobne zdolnoœci.");
		Film film4 = new Film("Porady na zdrady", "97 min", "Magdalena Lamparska, Miko³aj Roznerski", "Komedia Romantyczna", "+ 12", "Ryszard Zatorski", "5,5", "2016", "Dwie kobiety, Kalina i Fretka, zostawione przez swoich partnerów zak³adaj¹ firmê, w której chc¹ zajmowaæ siê rozwi¹zywaniem problemów z niewiernoœci¹ facetów. Gdy ta pierwsza ma uwieœæ coacha Macieja, ca³y plan spala na panewce. ");
		Film film5 = new Film("Amok", "108 min" , "Mateusz Koœciukiewicz, £ukasz Simlat" ,"Krymina³", "+ 15", "Kasia Adamik", "6,0", "2017", "Architekt Roszewski zostaje zamordowany. Kilka lat póŸniej inspektor Jacek Sokolski odnajduje dowody, które wi¹¿¹ siê z motywem opisanym w powieœci kryminalnej pod tytu³em Amok. ");
		Film film6 = new Film("By³ sobie pies", "100 min", "Dennis Quaid, Peggy Lipton", "Familijny, Komedia", "Brak ograniczeñ", "Lasse Hallström", "7,6", "2017", "Pies odnajduje sens swego istnienia, gdy po odejœciu z tego œwiata niespodziewanie odradza siê ponownie w kolejnym psim wcieleniu.");
		Film film7 = new Film("Azyl", "126 min", "Jessica Chastain, Johan Heldenbergh", "Biograficzny, Dramat", "+ 15", "Niki Caro", "7,2", "2017", "Opiekunowie warszawskiego zoo, pañstwo ¯abiñscy, próbuj¹ ocaliæ setki ludzi i zwierz¹t podczas niemieckiej okupacji. ");
		Film film8 = new Film("Chata", "132 min", "Sam Worthington, Octavia Spencer", "Dramat", "+ 15", "Stuart Hazeldine", "7,0", "2017", "Mê¿czyzna pogr¹¿ony w ¿a³obie po œmierci najm³odszej córki otrzymuje list, który zmienia jego ¿ycie.");
		
		if(filmService != null){
			filmService.save(film1, film1.getNazwa());
			filmService.save(film2, film2.getNazwa());
			filmService.save(film3, film3.getNazwa());
			filmService.save(film4, film4.getNazwa());
			filmService.save(film5, film5.getNazwa());
			filmService.save(film6, film6.getNazwa());
			filmService.save(film7, film7.getNazwa());
			filmService.save(film8, film8.getNazwa());
		}
	}
}
