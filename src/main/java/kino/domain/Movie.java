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
@NamedQuery(name = "Movie.findByName", query = "SELECT m FROM Movie m WHERE m.name = :name")
@Table(name="Movie")
public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="Movie_id")
	private Long id;
	@Column(name="Movie_Name")
	private String name;
	@Column(name="Time")
	private String time;
	@Column(name="Cast")
	private String cast;
	@Column(name="Type")
	private String type;
	@Column(name="Description")
	private String description;
	@Column(name="Age_Of_Client")
	private String ageOfClient;
	@Column(name="Director")
	private String director;
	@Column(name="Rating")
	private String rating;
	@Column(name="Year_Of_Production")
	private String yearOfProduction;
	@OneToMany(mappedBy="movie")
    private List<Seans> seanses;
	
	public Movie(){}
	
	public Movie(String name, String time, String cast, String type, String ageOfClient, String director,String rating,String yearOfProduction, String description) {
		super();
		this.name = name;
		this.type = type;
		this.ageOfClient = ageOfClient;
		this.director = director;
		this.rating = rating;
		this.yearOfProduction = yearOfProduction;
		this.time = time;
		this.cast = cast;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(String yearOfProdcution) {
		this.yearOfProduction = yearOfProdcution;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAgeOfClient() {
		return ageOfClient;
	}

	public void setAgeOfClient(String ageOfClient) {
		this.ageOfClient = ageOfClient;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
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
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
