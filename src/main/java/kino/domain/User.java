package kino.domain;

import java.io.Serializable;

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

@Entity(name="User")
@NamedQuery(name = "User.findUser", query = "SELECT u FROM User u WHERE u.nazwa = :nazwa AND u.userRole.id = :id" )
@Table(name="User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	
	@Id
	@GeneratedValue
	@Column(name="User_id")
	private Long id;
	@Column(name="password")
	private String haslo;
	@Column(name="username")
	private String nazwa;
	@Column(name="enabled")
	private String enabled;
	@ManyToOne(targetEntity = UserRoles.class)
	@JoinColumn(name = "Rola_Uzytkownika")
	private UserRoles userRole;
	@OneToOne(mappedBy="user")
	private Koszyk koszyk;
	
	public Koszyk getKoszyk() {
		return koszyk;
	}

	public void setKoszyk(Koszyk koszyk) {
		this.koszyk = koszyk;
	}

	public User(){}
	
	public UserRoles getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public User(String haslo, String nazwa, String enbled, UserRoles userRole) {
		super();
		this.nazwa = nazwa;
		this.haslo = haslo;
		this.enabled = enbled;
		this.userRole = userRole;
	}
	
	public String getNazwa() {
		return nazwa;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enbled) {
		this.enabled = enbled;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHaslo() {
		return this.haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((haslo == null) ? 0 : haslo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
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
		User other = (User) obj;
		if (haslo == null) {
			if (other.haslo != null)
				return false;
		} else if (!haslo.equals(other.haslo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		return true;
	}

	

	
	
	
	
}
