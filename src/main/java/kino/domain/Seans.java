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
@NamedQuery(name = "Seans.findByNameAndDay", query = "SELECT s FROM Seans s WHERE s.movie.name = :name AND s.day = :day")
@Table(name="Seans")
public class Seans implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="Seanse_id")
	private Long id;
	@Column(name="Day")
	private String day;
	@Column(name="Hour")
	private String hour;
	@ManyToOne(targetEntity = Movie.class)
	private Movie movie;
	@Column(name="Type_of_Film")
	private String type;
	@Column(name="Language")
	private String language;
	@Column(name="Subtitles_or_Lector")	
	private String subtitlesOrLector; 
	@OneToMany(mappedBy="seans", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BasketItem> basketItems;
	@ManyToMany(mappedBy="seanse", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonBackReference
	private List<Position> positions;
	
	public Seans(){}
	
	public Seans(String day, Movie movie, String language) {
		super();
		this.day = day;	
		this.language = language;
		this.movie = movie;
	}
	
	
	
	public List<BasketItem> getBasketItems() {
		return basketItems;
	}

	public void setBasketItems(List<BasketItem> basketItems) {
		this.basketItems = basketItems;
	}

	public Movie getMovie() {
		return this.movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getSubtitlesOrLector() {
		return subtitlesOrLector;
	}


	public void setSubtitlesOrLector(String subtitlesOrLector) {
		this.subtitlesOrLector = subtitlesOrLector;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getHour() {
		return hour;
	}


	public void setHour(String hour) {
		this.hour = hour;
	}

	

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> postions) {
		this.positions = postions;
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
