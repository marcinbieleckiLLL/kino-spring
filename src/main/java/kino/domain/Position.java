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
@Table(name="Position")
public class Position {
	
	@Id
	@GeneratedValue
	@Column(name="Position_id")
	private Long id;
	@Column(name="Raw")
	private String raw;
	@Column(name="Place")
	private String place;
	@Column(name="Availability")
	private String availability;
	@OneToMany(mappedBy="position", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BasketItem> basketItems;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Seans> seanse;
	
	public List<BasketItem> getBasketItems() {
		return basketItems;
	}

	public void setBasketItems(List<BasketItem> basketItems) {
		this.basketItems = basketItems;
	}

	public Position(){}
	
	public Position(String raw, String place, String availability) {
		super();
		this.raw = raw;
		this.place = place;
		this.availability = availability;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((raw == null) ? 0 : raw.hashCode());
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
		Position other = (Position) obj;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (raw == null) {
			if (other.raw != null)
				return false;
		} else if (!raw.equals(other.raw))
			return false;
		if (seanse == null) {
			if (other.seanse != null)
				return false;
		} else if (!seanse.equals(other.seanse))
			return false;
		return true;
	}

	public String getRaw() {
		return raw;
	}
	public void setRaw(String raw) {
		this.raw = raw;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String av) {
		this.availability = av;
	}

	public List<Seans> getSeanse() {
		return seanse;
	}

	public void setSeanse(List<Seans> seanse) {
		this.seanse = seanse;
	}
	
	
	
}
