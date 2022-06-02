package services;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;





import ejbs.Trip;

@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TripService {
	@EJB
	Trip trip;
	
	@PersistenceContext(unitName = "Goto Bus Ejbs")
	private EntityManager em;
	
	@Resource
	private UserTransaction ut;
	
	@POST
	@Path("/trip")
	public void createTrip(Trip trip) throws IllegalStateException, SecurityException, SystemException
	{
		try
		{
			ut.begin();
			em.persist(trip);
			ut.commit();
		}
		catch(Exception e) {
			ut.rollback();
		}
	}
	@GET
    @Path("/viewtrips/{id}")
    public List<Trip> retrieveTrip(@PathParam("id") int user_id)
    {
        TypedQuery<Trip> query = em.createQuery("SELECT t from Trip t, User u where u.user_id = t.trip_id and u.user_id >? 1 ", Trip.class);
        query.setParameter(1, user_id);
        List<Trip> trips = query.getResultList();
        return trips;
    }
	
	//@POST
	//@Path("/searchtrips")
	//public List<Trip> searchTrips(Trip trip)
	//{
	//	Date from_date=trip.getDepature_time();
	//}

}
