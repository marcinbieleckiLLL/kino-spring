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
@Table(name="BasketItem")
public class BasketItem {

	
	
	@Id
	@GeneratedValue
	@Column(name="BasketItem_id")
	private Long id;
	@ManyToOne(targetEntity = Seans.class, optional=false)
	private Seans seans; 
	@ManyToOne(targetEntity = Position.class, optional=false)
	private Position position; 
	@ManyToOne(targetEntity = Basket.class, optional=false)
	private Basket basket;
	@Column(name="Price")
	private int price;

	public BasketItem(){}
	

	public BasketItem(Seans seans, Position miejsce, int cena) {
		super();
		this.seans = seans;
		this.position = miejsce;
		this.price = cena;
	}


	
	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Seans getSeans() {
		return seans;
	}
	public void setSeans(Seans seanse) {
		this.seans = seanse;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
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
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		BasketItem other = (BasketItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (seans == null) {
			if (other.seans != null)
				return false;
		} else if (!seans.equals(other.seans))
			return false;
		return true;
	}


	
	
	
}
