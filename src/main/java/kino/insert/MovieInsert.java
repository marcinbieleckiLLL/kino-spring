package kino.insert;

import org.springframework.beans.factory.annotation.Autowired;

import kino.domain.Movie;
import kino.service.MovieService;

public class MovieInsert {
	
	public MovieInsert() {
		super();
	}
	
	public void insert(MovieService filmService){
		
		Movie movie1 = new Movie("Pi�kna i Bestia","129 min", "Emma Watson, Dan Stevens", "Fantasy, Musical, Romans", "+ 12", "Bill Condon", "7,4", "2017", "Bella gotowa jest zamieszka� w zamku potwora, aby ratowa� ojca. Z czasem mi�dzy dziewczyn� a besti� zaczyna rodzi� si� uczucie. Jednocze�nie o r�k� Belli zabiega przystojny my�liwy Gaston. ");
		Movie movie2 = new Movie("Wszystko albo nic", "107 min", "Tatiana Pauhofov�, Kl�ra Issov�", "Komedia Romantyczna", "+ 12", "Marta Ferencov�", "5,0", "2017", "Dw�ch przystojnych m�czyzn walczy o serce pi�knej dziewczyny. ");
		Movie movie3 = new Movie("Logan Wolverine", "137 min", "Hugh Jackman, Patrick Stewart", "Dramat, Akcja, Sci-Fi", "+ 15", "James Mangold", "8,1", "2017", "Trac�cy moc Logan staje si� mentorem ma�ej dziewczynki, kt�ra posiada podobne zdolno�ci.");
		Movie movie4 = new Movie("Porady na zdrady", "97 min", "Magdalena Lamparska, Miko�aj Roznerski", "Komedia Romantyczna", "+ 12", "Ryszard Zatorski", "5,5", "2016", "Dwie kobiety, Kalina i Fretka, zostawione przez swoich partner�w zak�adaj� firm�, w kt�rej chc� zajmowa� si� rozwi�zywaniem problem�w z niewierno�ci� facet�w. Gdy ta pierwsza ma uwie�� coacha Macieja, ca�y plan spala na panewce. ");
		Movie movie5 = new Movie("Amok", "108 min" , "Mateusz Ko�ciukiewicz, �ukasz Simlat" ,"Krymina�", "+ 15", "Kasia Adamik", "6,0", "2017", "Architekt Roszewski zostaje zamordowany. Kilka lat p�niej inspektor Jacek Sokolski odnajduje dowody, kt�re wi��� si� z motywem opisanym w powie�ci kryminalnej pod tytu�em Amok. ");
		Movie movie6 = new Movie("By� sobie pies", "100 min", "Dennis Quaid, Peggy Lipton", "Familijny, Komedia", "Brak ogranicze�", "Lasse Hallstr�m", "7,6", "2017", "Pies odnajduje sens swego istnienia, gdy po odej�ciu z tego �wiata niespodziewanie odradza si� ponownie w kolejnym psim wcieleniu.");
		Movie movie7 = new Movie("Azyl", "126 min", "Jessica Chastain, Johan Heldenbergh", "Biograficzny, Dramat", "+ 15", "Niki Caro", "7,2", "2017", "Opiekunowie warszawskiego zoo, pa�stwo �abi�scy, pr�buj� ocali� setki ludzi i zwierz�t podczas niemieckiej okupacji. ");
		Movie movie8 = new Movie("Chata", "132 min", "Sam Worthington, Octavia Spencer", "Dramat", "+ 15", "Stuart Hazeldine", "7,0", "2017", "M�czyzna pogr��ony w �a�obie po �mierci najm�odszej c�rki otrzymuje list, kt�ry zmienia jego �ycie.");
		
		if(filmService != null){
			filmService.save(movie1, movie1.getName());
			filmService.save(movie2, movie2.getName());
			filmService.save(movie3, movie3.getName());
			filmService.save(movie4, movie4.getName());
			filmService.save(movie5, movie5.getName());
			filmService.save(movie6, movie6.getName());
			filmService.save(movie7, movie7.getName());
			filmService.save(movie8, movie8.getName());
		}
	}
}
