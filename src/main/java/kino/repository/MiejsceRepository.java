package kino.repository;

import java.util.List;

import kino.domain.Miejsce;
import kino.domain.Seans;

public interface MiejsceRepository {
	
	public List<Miejsce> getAllFromOneSeanse(Seans seans);
	public void save(Miejsce miejsce, int dlugosc, Seans seans);
	public List<Miejsce> getColumn(String decydujaca, Seans seans);
	public void updateDostepnosc(Miejsce miejsce, String dostepnosc);
	public Miejsce getMiejsce(String rzad, String miejsce, Seans seans);
	public void addChwilowoZajeteMiejsceToList(String rzad, String miejsce);
	public void deleteChwilowoZajeteMiejsceFromList();
	public Miejsce getOstatnieZajeteMiejsce();
	public List<Miejsce> getListaChwilowoZajetychMiejsc();
	public void setListaChwilowoZajetychMiejsc(List<Miejsce> listaChwilowoZajetychMiejsc);
	public void deleteAllChwilowoZajeteMiejscaFromList();
	public void update(Miejsce miejsce);
	public List<Miejsce> getZajeteMiejsca(Seans seans);
	public void deleteChwilowoZajeteMiejscaFromDatabase(Seans seans);
	
}
