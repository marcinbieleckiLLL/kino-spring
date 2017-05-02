package kino.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@NamedQuery(name = "Koszyk.deleteKoszyk", query = "DELETE FROM Koszyk k WHERE k.user.id = :id")
@Table(name="Koszyk")
public class Koszyk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="Koszyk_id")
	private Long id;
	@Cascade({CascadeType.SAVE_UPDATE})
	@OneToOne(optional=false)
	private User user;
	@Column(name="Cena")
	private int cena;
	@Column(name="KoszykItems")
	@OneToMany(mappedBy="koszyk", fetch = FetchType.EAGER)
	private List<KoszykCzesc> koszykCzesci;
	
	public Koszyk(){}
	
	public Koszyk(User user) {
		super();
		this.user = user;
		
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}

	public List<KoszykCzesc> getKoszykCzesci() {
		return koszykCzesci;
	}

	public void setKoszykCzesci(List <KoszykCzesc> koszykCzesci) {
		this.koszykCzesci = koszykCzesci;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((koszykCzesci == null) ? 0 : koszykCzesci.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Koszyk other = (Koszyk) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (koszykCzesci == null) {
			if (other.koszykCzesci != null)
				return false;
		} else if (!koszykCzesci.equals(other.koszykCzesci))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
	
	

}
