package ejbs;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Stateless
@Entity
public class Trip implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Integer trip_id;
	private String from_station;
	private String to_station;
	private Integer available_seats;
	@Temporal(TemporalType.DATE)
	private Date depature_time;
	@Temporal(TemporalType.DATE)
	private Date arrival_time;
	private static final long serialVersionUID = 1L;
	

	public Trip() {
		super();
	}   
	
	public Integer getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(Integer trip_id) {
		this.trip_id = trip_id;
	}
	
	public String getFrom_station() {
		return this.from_station;
	}

	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}   
	public String getTo_station() {
		return this.to_station;
	}

	public void setTo_station(String to_station) {
		this.to_station = to_station;
	}   
	public Integer getAvailable_seats() {
		return this.available_seats;
	}

	public void setAvailable_seats(Integer available_seats) {
		this.available_seats = available_seats;
	}
	
	public Date getDepature_time() {
		return depature_time;
	}
	public void setDepature_time(Date depature_time) {
		this.depature_time = depature_time;
	}
	public Date getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(Date arrival_time) {
		this.arrival_time = arrival_time;
	}
   
}
