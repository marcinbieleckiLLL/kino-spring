package kino.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kino.domain.Miejsce;
import kino.domain.Seans;
import kino.repository.MiejsceRepository;

@Repository
@Transactional
public class MiejsceRepositoryImpl implements MiejsceRepository {

	@PersistenceContext
	private EntityManager emManager;
	public List<Miejsce> listaChwilowoZajetychMiejsc = new ArrayList<Miejsce>();
	
	
	
	public List<Miejsce> getListaChwilowoZajetychMiejsc(){
		return this.listaChwilowoZajetychMiejsc;
	}

	public void setListaChwilowoZajetychMiejsc(List<Miejsce> listaChwilowoZajetychMiejsc) {
		this.listaChwilowoZajetychMiejsc = listaChwilowoZajetychMiejsc;
	}
	

	@Override
	public void save(Miejsce miejsce, int dlugosc, Seans seans) {
		List<Miejsce> listaMiejsc = getAllFromOneSeanse(seans);
		
		if(listaMiejsc.size() < dlugosc){
			emManager.persist(miejsce);
		}
	}
	
	public List<Miejsce> getColumn(String decydujaca, Seans seans) throws NullPointerException{
		
		List<Miejsce> listaMiejsc = getAllFromOneSeanse(seans);
		List<Miejsce> listaPomocnicza = new ArrayList<Miejsce>();
		boolean czyPobierac = true;
		
		if(listaMiejsc.isEmpty() || listaMiejsc == null){
			czyPobierac = false;
		}
		
		if(czyPobierac){
			if(decydujaca.equals("1")){
				for(Miejsce miejsce: listaMiejsc){
					if(miejsce.getMiejsce() != null){
						if(miejsce.getMiejsce().equals("1") || miejsce.getMiejsce().equals("2") || miejsce.getMiejsce().equals("3")){
							listaPomocnicza.add(miejsce);
						}
					}
				}
				
			}else if(decydujaca.equals("2")){
				for(Miejsce miejsce: listaMiejsc){
					if(miejsce.getMiejsce() != null){
						if(miejsce.getMiejsce().equals("4") || miejsce.getMiejsce().equals("5") || miejsce.getMiejsce().equals("6") || miejsce.getMiejsce().equals("7") || miejsce.getMiejsce().equals("8")){
							listaPomocnicza.add(miejsce);
						}
					}
				}
			}if(decydujaca.equals("3")){
				for(Miejsce miejsce: listaMiejsc){
					if(miejsce.getMiejsce() != null){
						if(miejsce.getMiejsce().equals("9") || miejsce.getMiejsce().equals("10") || miejsce.getMiejsce().equals("11") || miejsce.getMiejsce().equals("12")){
							listaPomocnicza.add(miejsce);
						}
					}
				}
			}	
		}
		return listaPomocnicza;
	}

	@Override
	public void updateDostepnosc(Miejsce miejsce, String dostepnosc) {
		miejsce.setDostepnosc(dostepnosc);
		emManager.merge(miejsce);
		
	}

	@Override
	public Miejsce getMiejsce(String rzad, String miejsce, Seans seans) {
		
		Miejsce miejsceSzukane = new Miejsce();
		List<Miejsce> listaFromOneSeans = getAllFromOneSeanse(seans);
		
		for(Miejsce m: listaFromOneSeans){
			if(m.getMiejsce().equals(miejsce) && m.getRzad().equals(rzad)){
				miejsceSzukane = m;
			}
		}

	return miejsceSzukane;
		
	}

	public void dodajChwilowoZajeteMiejsceDoListy(String rzad, String miejsce) {
		
		Miejsce miejsceZajete = new Miejsce(rzad, miejsce, "chwilowoZajête");
		listaChwilowoZajetychMiejsc.add(miejsceZajete);
	}

	@Override
	public void usunChwilowoZajeteMiejsceZListyZajetychMiejsc() {
		
		if(!listaChwilowoZajetychMiejsc.isEmpty())
			listaChwilowoZajetychMiejsc.remove(listaChwilowoZajetychMiejsc.size() - 1);
		
	}

	@Override
	public Miejsce getOstatnieZajeteMiejsce() throws NoResultException{
		
		Miejsce miejsce = new Miejsce();
		
		if(listaChwilowoZajetychMiejsc.isEmpty()){
			throw new NoResultException("¯adne miejsce nie jest zajête!");
		}else{
			miejsce = listaChwilowoZajetychMiejsc.get(listaChwilowoZajetychMiejsc.size() - 1);
		}
		
		return miejsce;
	}

	@Override
	public void UsuwanieWszystkichZajetychMiejscZListyZajetychMiejsc() {
		setListaChwilowoZajetychMiejsc(new ArrayList<Miejsce>());
	}

	
	@Override
	public void update(Miejsce miejsce) {
		emManager.merge(miejsce);
		
	}

	@Override
	public List<Miejsce> getZajeteMiejsca(Seans seans) {
		List<Miejsce> listaWszystkichMiejsc = getAllFromOneSeanse(seans);
		List<Miejsce> listaZajetychMiejsc = new ArrayList<>();
		
		for(Miejsce miejsce: listaWszystkichMiejsc){
			if(miejsce.getDostepnosc().equals("chwilowoZajête")){
				listaZajetychMiejsc.add(miejsce);
			}
		}
		return listaZajetychMiejsc;
	}

	@Override
	public void UsuwanieChwilowoZajetychMiejscZBazyDanych(Seans seans) {
		List<Miejsce> listaZajetychMiejsc = getZajeteMiejsca(seans);
		
		for(Miejsce miejsce: listaZajetychMiejsc){
			updateDostepnosc(miejsce, "wolne");
		}
		
	}

	@Override
	public List<Miejsce> getAllFromOneSeanse(Seans seans) {
		
		TypedQuery<Miejsce> query = emManager.createQuery("SELECT m FROM Miejsce m", Miejsce.class);
		List<Miejsce> listaWszystkichMiejsc = query.getResultList();
		List<Miejsce> listaFromOneSeans = new ArrayList<Miejsce>();
		
		for(Miejsce miejsce: listaWszystkichMiejsc){
			for(Seans s: miejsce.getSeanse()){
				if(s.equals(seans)){
					listaFromOneSeans.add(miejsce);
				}
			}
		}
		
		return listaFromOneSeans;
	}
}
