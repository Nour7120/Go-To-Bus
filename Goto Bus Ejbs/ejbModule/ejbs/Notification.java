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

public class Notification implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Integer notification_id;
	private String message;
	@Temporal(TemporalType.DATE)
	private Date notification_datetime;   
	
	private static final long serialVersionUID = 1L;

	public Notification() {
		super();
	}   
	
	public Integer getId() {
		return notification_id;
	}

	public void setId(Integer id) {
		notification_id = id;
	}
	
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}   
	public Date getNotification_datetime() {
		return this.notification_datetime;
	}

	public void setNotification_datetime(Date notification_datetime) {
		this.notification_datetime = notification_datetime;
	}   
	
	//Relation between User and Notification in class Notification
    @ManyToOne
    @JoinColumn(name="userID")
    private User user;
}
