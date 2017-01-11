package ud.paintings.projectud2.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery (name = "reproduktor.select.all", 
			query = "SELECT r FROM Reproductor r"),
	@NamedQuery (name = "reproduktor.select.byName", 
			query = "SELECT r FROM Reproductor r WHERE r.name = :name"),
	//1
	@NamedQuery (name = "reproduktor.select.byId", 
			query = "SELECT r.id FROM Reproductor r WHERE r.name = :name"),
})
public class Reproductor {
	private Long id;
	
	private String name ;
	private String country ;
	private String city ;
	private String adress ;
	private String houseNumber ;
	private String telephone ;
	private String eMail ;
	
	private List<Painting> paintings = new ArrayList<Painting>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getHouse_number() {
		return houseNumber;
	}

	public void setHouse_number(String house_number) {
		this.houseNumber = house_number;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return eMail;
	}

	public void setEmail(String e_mail) {
		this.eMail = e_mail;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Painting> getPaintings() {
		return paintings;
	}

	public void setPaintings(List<Painting> paintings) {
		this.paintings = paintings;
	}	
}