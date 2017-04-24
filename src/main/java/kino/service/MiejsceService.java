package kino.service;

import java.util.List;

import kino.domain.Miejsce;
import kino.domain.Seans;

public interface MiejsceService {
	
	public List<Miejsce> getAllFromOneSeanse(Seans seans);
	public void save(Miejsce miejsce, int dlugosc, Seans seans);
	public List<Miejsce> getColumn(String decydujaca, Seans seans);
	public void updateDostepnosc(Miejsce miejsce, String dostepnosc);
	public Miejsce getMiejsce(String rzad, String miejsce, Seans seans);
	public void dodajChwilowoZajeteMiejsceDoListy(String rzad, String miejsce);
	public void usunChwilowoZajeteMiejsceZListyZajetychMiejsc();
	public Miejsce getOstatnieZajeteMiejsce();
	public List<Miejsce> getListaChwilowoZajetychMiejsc();
	public void setListaChwilowoZajetychMiejsc(List<Miejsce> listaChwilowoZajetychMiejsc);
	public void UsuwanieWszystkichZajetychMiejscZListyZajetychMiejsc();
	public void update(Miejsce miejsce);
	public List<Miejsce> getZajeteMiejsca(Seans seans);
	public void UsuwanieChwilowoZajetychMiejscZBazyDanych();
}
