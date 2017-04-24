package kino.insert;

import java.util.ArrayList;
import java.util.List;

import kino.domain.Miejsce;
import kino.domain.Seans;
import kino.service.MiejsceService;

public class MiejsceInsert {

	public MiejsceInsert(){};
	
	public void insert(MiejsceService miejsceService ,Seans seans){
		
		String[] listaRzedow = {"A","B","C","D","E","F"};
		String[] listaMiejsc = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		int dlugosc = listaMiejsc.length * listaRzedow.length;
		List<Seans> listaSeansow = new ArrayList<Seans>();
		listaSeansow.add(seans);
		
		for(String rzad: listaRzedow){
			for(String m: listaMiejsc){
				Miejsce miejsce = new Miejsce(rzad, m, "wolne");
				miejsce.setSeanse(listaSeansow);
				miejsceService.save(miejsce, dlugosc, seans);					
			}
		}
		
		String[] listaMiejsc2 = {"4","5","6","7","8"};
		dlugosc = dlugosc + listaMiejsc2.length;
		
		for(String m: listaMiejsc2){
			Miejsce miejsce = new Miejsce("G", m, "wolne");
			miejsce.setSeanse(listaSeansow);
			miejsceService.save(miejsce, dlugosc, seans);	
		}
		
	}
}
