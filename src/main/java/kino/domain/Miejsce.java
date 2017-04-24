package kino.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Miejsce")
public class Miejsce {
	
	@Id
	@GeneratedValue
	@Column(name="Miejsce_id")
	private Long id;
	@Column(name="Rzad")
	private String rzad;
	@Column(name="Miejsce")
	private String miejsce;
	@Column(name="Dostepnosc")
	private String dostepnosc;
	@OneToMany(mappedBy="miejsce", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<KoszykItem> koszykItem;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Seans> seanse;
	
	public List<KoszykItem> getKoszykItem() {
		return koszykItem;
	}

	public void setKoszykItem(List<KoszykItem> koszykItem) {
		this.koszykItem = koszykItem;
	}

	public Miejsce(){}
	
	public Miejsce(String rzad, String miejsce, String dostepnosc) {
		super();
		this.rzad = rzad;
		this.miejsce = miejsce;
		this.dostepnosc = dostepnosc;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dostepnosc == null) ? 0 : dostepnosc.hashCode());
		result = prime * result + ((miejsce == null) ? 0 : miejsce.hashCode());
		result = prime * result + ((rzad == null) ? 0 : rzad.hashCode());
		result = prime * result + ((seanse == null) ? 0 : seanse.hashCode());
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
		Miejsce other = (Miejsce) obj;
		if (dostepnosc == null) {
			if (other.dostepnosc != null)
				return false;
		} else if (!dostepnosc.equals(other.dostepnosc))
			return false;
		if (miejsce == null) {
			if (other.miejsce != null)
				return false;
		} else if (!miejsce.equals(other.miejsce))
			return false;
		if (rzad == null) {
			if (other.rzad != null)
				return false;
		} else if (!rzad.equals(other.rzad))
			return false;
		if (seanse == null) {
			if (other.seanse != null)
				return false;
		} else if (!seanse.equals(other.seanse))
			return false;
		return true;
	}

	public String getRzad() {
		return rzad;
	}
	public void setRzad(String rzad) {
		this.rzad = rzad;
	}
	public String getMiejsce() {
		return miejsce;
	}
	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}
	public String getDostepnosc() {
		return dostepnosc;
	}
	public void setDostepnosc(String dostepnosc) {
		this.dostepnosc = dostepnosc;
	}

	public List<Seans> getSeanse() {
		return seanse;
	}

	public void setSeanse(List<Seans> seanse) {
		this.seanse = seanse;
	}
	
	
	
}
