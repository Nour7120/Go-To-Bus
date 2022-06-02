package ejbs;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Stateless
@Entity
public class Station implements Serializable {

	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String name;
	private Double longitude;
	private Double latitude;   
	
	private static final long serialVersionUID = 1L;

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public Station(@NotNull int iD, String name, Double longitude, Double latitude, Set<Trip> trip) {
		super();
		ID = iD;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.trip = trip;
	}
	public Station() {
		super();
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}   
	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}   
	
	//OneToMany relation between station & Trip in class Station
    @OneToMany(mappedBy="station",fetch=FetchType.LAZY)
    private Set<Trip> trip;
}
