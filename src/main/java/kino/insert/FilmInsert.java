package kino.insert;

import org.springframework.beans.factory.annotation.Autowired;

import kino.domain.Film;
import kino.service.FilmService;

public class FilmInsert {
	
	public FilmInsert() {
		super();
	}
	
	public void insert(FilmService filmService){
		
		Film film1 = new Film("Pi�kna i Bestia","129 min", "Emma Watson, Dan Stevens", "Fantasy, Musical, Romans", "+ 12", "Bill Condon", "7,4", "2017", "Bella gotowa jest zamieszka� w zamku potwora, aby ratowa� ojca. Z czasem mi�dzy dziewczyn� a besti� zaczyna rodzi� si� uczucie. Jednocze�nie o r�k� Belli zabiega przystojny my�liwy Gaston. ");
		Film film2 = new Film("Wszystko albo nic", "107 min", "Tatiana Pauhofov�, Kl�ra Issov�", "Komedia Romantyczna", "+ 12", "Marta Ferencov�", "5,0", "2017", "Dw�ch przystojnych m�czyzn walczy o serce pi�knej dziewczyny. ");
		Film film3 = new Film("Logan Wolverine", "137 min", "Hugh Jackman, Patrick Stewart", "Dramat, Akcja, Sci-Fi", "+ 15", "James Mangold", "8,1", "2017", "Trac�cy moc Logan staje si� mentorem ma�ej dziewczynki, kt�ra posiada podobne zdolno�ci.");
		Film film4 = new Film("Porady na zdrady", "97 min", "Magdalena Lamparska, Miko�aj Roznerski", "Komedia Romantyczna", "+ 12", "Ryszard Zatorski", "5,5", "2016", "Dwie kobiety, Kalina i Fretka, zostawione przez swoich partner�w zak�adaj� firm�, w kt�rej chc� zajmowa� si� rozwi�zywaniem problem�w z niewierno�ci� facet�w. Gdy ta pierwsza ma uwie�� coacha Macieja, ca�y plan spala na panewce. ");
		Film film5 = new Film("Amok", "108 min" , "Mateusz Ko�ciukiewicz, �ukasz Simlat" ,"Krymina�", "+ 15", "Kasia Adamik", "6,0", "2017", "Architekt Roszewski zostaje zamordowany. Kilka lat p�niej inspektor Jacek Sokolski odnajduje dowody, kt�re wi��� si� z motywem opisanym w powie�ci kryminalnej pod tytu�em Amok. ");
		Film film6 = new Film("By� sobie pies", "100 min", "Dennis Quaid, Peggy Lipton", "Familijny, Komedia", "Brak ogranicze�", "Lasse Hallstr�m", "7,6", "2017", "Pies odnajduje sens swego istnienia, gdy po odej�ciu z tego �wiata niespodziewanie odradza si� ponownie w kolejnym psim wcieleniu.");
		Film film7 = new Film("Azyl", "126 min", "Jessica Chastain, Johan Heldenbergh", "Biograficzny, Dramat", "+ 15", "Niki Caro", "7,2", "2017", "Opiekunowie warszawskiego zoo, pa�stwo �abi�scy, pr�buj� ocali� setki ludzi i zwierz�t podczas niemieckiej okupacji. ");
		Film film8 = new Film("Chata", "132 min", "Sam Worthington, Octavia Spencer", "Dramat", "+ 15", "Stuart Hazeldine", "7,0", "2017", "M�czyzna pogr��ony w �a�obie po �mierci najm�odszej c�rki otrzymuje list, kt�ry zmienia jego �ycie.");
		
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
