package kino.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity(name="Seans")
@NamedQuery(name = "Seans.findByNameAndDay", query = "SELECT s FROM Seans s WHERE s.film.nazwa = :nazwa AND s.dzien = :dzien")
@Table(name="Seans")
public class Seans implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="Seans_id")
	private Long id;
	@Column(name="Dzien_tygodnia")
	private String dzien;
	@Column(name="Godzina")
	private String godzina;
	@ManyToOne(targetEntity = Film.class)
	@JoinColumn(name = "Film")
	private Film film;
	@Column(name="Typ_Filmu")
	private String typ;
	@Column(name="Jêzyk_Filmu")
	private String jezyk;
	@Column(name="Napisy_Lektor")	
	private String napisy; 
	@OneToMany(mappedBy="seans", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<KoszykCzesc> koszykCzesci;
	@ManyToMany(mappedBy="seanse", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonBackReference
	private List<Miejsce> miejsca;
	
	public Seans(){}
	
	public Seans(String dzien, Film film, String jezyk) {
		super();
		this.dzien = dzien;	
		this.jezyk = jezyk;
		this.film = film;
	}
	
	
	
	public List<KoszykCzesc> getKoszykCzesci() {
		return koszykCzesci;
	}

	public void setKoszykCzesci(List<KoszykCzesc> koszykCzesci) {
		this.koszykCzesci = koszykCzesci;
	}

	public Film getFilm() {
		return this.film;
	}


	public void setFilm(Film film) {
		this.film = film;
	}
	

	public String getTyp() {
		return typ;
	}


	public void setTyp(String typ) {
		this.typ = typ;
	}


	public String getJezyk() {
		return jezyk;
	}


	public void setJezyk(String jezyk) {
		this.jezyk = jezyk;
	}


	public String getNapisy() {
		return napisy;
	}


	public void setNapisy(String napisy) {
		this.napisy = napisy;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDzien() {
		return dzien;
	}


	public void setDzien(String dzien) {
		this.dzien = dzien;
	}


	public String getGodzina() {
		return godzina;
	}


	public void setGodzina(String godzina) {
		this.godzina = godzina;
	}

	

	public List<Miejsce> getMiejsca() {
		return miejsca;
	}

	public void setMiejsca(List<Miejsce> miejsca) {
		this.miejsca = miejsca;
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
		Seans other = (Seans) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
