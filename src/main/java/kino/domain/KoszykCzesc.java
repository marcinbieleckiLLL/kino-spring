package kino.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="KoszykCzesc")
public class KoszykCzesc {

	
	
	@Id
	@GeneratedValue
	@Column(name="KoszykCzesc_id")
	private Long id;
	@ManyToOne(targetEntity = Seans.class, optional=false)
	private Seans seans; 
	@ManyToOne(targetEntity = Miejsce.class, optional=false)
	private Miejsce miejsce; 
	@ManyToOne(targetEntity = Koszyk.class, optional=false)
	private Koszyk koszyk;
	@Column(name="Cena")
	private int cena;

	public KoszykCzesc(){}
	

	public KoszykCzesc(Seans seans, Miejsce miejsce, int cena) {
		super();
		this.seans = seans;
		this.miejsce = miejsce;
		this.cena = cena;
	}


	
	public int getCena() {
		return cena;
	}


	public void setCena(int cena) {
		this.cena = cena;
	}


	public Seans getSeans() {
		return seans;
	}
	public void setSeans(Seans seans) {
		this.seans = seans;
	}
	public Miejsce getMiejsce() {
		return miejsce;
	}
	public void setMiejsce(Miejsce miejsce) {
		this.miejsce = miejsce;
	}
	public Koszyk getKoszyk() {
		return koszyk;
	}
	public void setKoszyk(Koszyk koszyk) {
		this.koszyk = koszyk;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((miejsce == null) ? 0 : miejsce.hashCode());
		result = prime * result + ((seans == null) ? 0 : seans.hashCode());
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
		KoszykCzesc other = (KoszykCzesc) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (miejsce == null) {
			if (other.miejsce != null)
				return false;
		} else if (!miejsce.equals(other.miejsce))
			return false;
		if (seans == null) {
			if (other.seans != null)
				return false;
		} else if (!seans.equals(other.seans))
			return false;
		return true;
	}


	
	
	
}
