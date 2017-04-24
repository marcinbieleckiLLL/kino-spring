package kino.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Film.findByName", query = "SELECT f FROM Film f WHERE f.nazwa = :nazwa")
@Table(name="Film")
public class Film implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="Film_id")
	private Long id;
	@Column(name="Nazwa_Filmu")
	private String nazwa;
	@Column(name="Czas_Trwania")
	private String czasTrwania;
	@Column(name="Obsada")
	private String obsada;
	@Column(name="Gatunek")
	private String gatunek;
	@Column(name="Opis")
	private String opis;
	@Column(name="Dozwolone_od_lat")
	private String minWiekKlienta;
	@Column(name="Rezyser")
	private String rezyser;
	@Column(name="Ocena")
	private String ocena;
	@Column(name="Rok_Produkcji")
	private String rokProdukcji;
	@OneToMany(mappedBy="film")
    private List<Seans> seanse;
	
	public Film(){}
	
	public Film(String nazwa, String czasTrwania, String obsada, String gatunek, String minWiekKlienta, String rezyser,String ocena,String rokProdkucji, String opis) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.gatunek = gatunek;
		this.minWiekKlienta = minWiekKlienta;
		this.rezyser = rezyser;
		this.ocena = ocena;
		this.rokProdukcji = rokProdkucji;
		this.czasTrwania = czasTrwania;
		this.obsada = obsada;
		this.opis = opis;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getCzasTrwania() {
		return czasTrwania;
	}

	public void setCzasTrwania(String czasTrwania) {
		this.czasTrwania = czasTrwania;
	}

	public String getObsada() {
		return obsada;
	}

	public void setObsada(String obsada) {
		this.obsada = obsada;
	}

	public String getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(String rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}

	public String getOcena() {
		return ocena;
	}

	public void setOcena(String ocena) {
		this.ocena = ocena;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getGatunek() {
		return gatunek;
	}

	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}

	public String getMinWiekKlienta() {
		return minWiekKlienta;
	}

	public void setMinWiekKlienta(String minWiekKlienta) {
		this.minWiekKlienta = minWiekKlienta;
	}

	public String getRezyser() {
		return rezyser;
	}

	public void setRezyser(String rezyser) {
		this.rezyser = rezyser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", nazwa=" + nazwa + ", gatunek=" + gatunek + ", minWiekKlienta=" + minWiekKlienta
				+ ", rezyser=" + rezyser + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
