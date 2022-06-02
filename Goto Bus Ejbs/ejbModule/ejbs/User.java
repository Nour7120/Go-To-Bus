package ejbs;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Stateless
@Entity
public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Integer user_id;
	private String username;
	private String password;
	private String full_name;
	private String role;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public Integer getId() {
		return user_id;
	}

	public void setId(Integer id) {
		user_id = id;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getFull_name() {
		return this.full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
   
}
