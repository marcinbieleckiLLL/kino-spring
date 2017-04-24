package kino.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kino.domain.Miejsce;
import kino.domain.Seans;
import kino.repository.MiejsceRepository;
import kino.service.MiejsceService;

@Service
public class MiejsceServiceImpl implements MiejsceService {

	@Autowired
	MiejsceRepository miejsceRepository;

	@Override
	public void save(Miejsce miejsce, int dlugosc, Seans seans) {
		miejsceRepository.save(miejsce, dlugosc, seans);	
	}

	@Override
	public List<Miejsce> getColumn(String decydujaca, Seans seans) {
		return miejsceRepository.getColumn(decydujaca, seans);
	}

	@Override
	public void updateDostepnosc(Miejsce miejsce, String dostepnosc) {
		miejsceRepository.updateDostepnosc(miejsce, dostepnosc);
		
	}

	@Override
	public Miejsce getMiejsce(String rzad, String miejsce, Seans seans) {	
		return miejsceRepository.getMiejsce(rzad, miejsce, seans);
	}

	@Override
	public void dodajChwilowoZajeteMiejsceDoListy(String rzad, String miejsce) {
		miejsceRepository.dodajChwilowoZajeteMiejsceDoListy(rzad, miejsce);	
	}

	@Override
	public void usunChwilowoZajeteMiejsceZListyZajetychMiejsc() {
		miejsceRepository.usunChwilowoZajeteMiejsceZListyZajetychMiejsc();
		
	}

	@Override
	public Miejsce getOstatnieZajeteMiejsce() {	
		return miejsceRepository.getOstatnieZajeteMiejsce();
	}

	@Override
	public List<Miejsce> getListaChwilowoZajetychMiejsc() {
		return miejsceRepository.getListaChwilowoZajetychMiejsc();
	}

	@Override
	public void setListaChwilowoZajetychMiejsc(List<Miejsce> listaChwilowoZajetychMiejsc) {
		miejsceRepository.setListaChwilowoZajetychMiejsc(listaChwilowoZajetychMiejsc);		
	}

	@Override
	public void UsuwanieWszystkichZajetychMiejscZListyZajetychMiejsc() {
		miejsceRepository.UsuwanieWszystkichZajetychMiejscZListyZajetychMiejsc();		
	}

	@Override
	public void update(Miejsce miejsce) {
		miejsceRepository.update(miejsce);
	}

	@Override
	public List<Miejsce> getZajeteMiejsca(Seans seans) {
		return miejsceRepository.getZajeteMiejsca(seans);
	}

	@Override
	public void UsuwanieChwilowoZajetychMiejscZBazyDanych() {
		miejsceRepository.UsuwanieChwilowoZajetychMiejscZBazyDanych();	
	}

	@Override
	public List<Miejsce> getAllFromOneSeanse(Seans seans) {
		return miejsceRepository.getAllFromOneSeanse(seans);
	}

}
