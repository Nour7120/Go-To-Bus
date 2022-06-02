package services;


import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.security.auth.spi.Users.User;



@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService {
	
	@EJB
	User user;
	
	@PersistenceContext(unitName = "Goto Bus Ejbs")
	private EntityManager em;
	
	@Resource
	private UserTransaction ut;
	
	
	
	@POST
	@Path("/user")
	public void register_user(User user) throws IllegalStateException, SecurityException, SystemException
	{
		try
		{
			ut.begin();
			em.persist(user);
			ut.commit();
		}
		catch(Exception e) {
			ut.rollback();
		}
	}
	
	@GET
	@Path("/getusers")
	public List<User> retrieveusers() throws IllegalStateException, SecurityException, SystemException
	{
		TypedQuery<User> query = em.createQuery("SELECT u from User u", User.class);
		List<User> users = query.getResultList();
		return users;
	}
}
