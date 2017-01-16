package ud.paintings.projectud2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "painting.select.all", 
			query = "SELECT p FROM Painting p"),
	@NamedQuery(name = "painting.select.byName",
			query = "SELECT p FROM Painting p WHERE p.name = :name")
})
public class Painting {
	
	private Long id;
	
	private String name;
	private int yoc;
	private int cost;
	private String artist;
	private String originArtist;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	//@Column(unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYoc() {
		return yoc;
	}

	public void setYoc(int yoc) {
		this.yoc = yoc;
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getOriginArtist() {
		return originArtist;
	}

	public void setOriginArtist(String origin_artist) {
		this.originArtist = origin_artist;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}