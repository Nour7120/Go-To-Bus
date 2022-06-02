package services;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import ejbs.Station;
import ejbs.User;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@RequestScoped
@Path("/station")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StationService {

    @EJB
    Station station;

    @PersistenceContext(unitName = "Goto Bus Ejbs")
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    @POST
    public void createStation(Station station) throws IllegalStateException, SecurityException, SystemException
    {
        try
        {
            ut.begin();
            em.persist(station);
            ut.commit();
        
        }
        catch(Exception e) {
            ut.rollback();
           
        }
    }

    @GET
    @Path("/{id}")
    public String retrieveStation(@PathParam("id") int id) throws IllegalStateException, SecurityException, SystemException
    {
        List<Station> stations = retrievestations();
       station = stations.get(id);
        return station.toString();
    }
    
	@GET
	@Path("/getstations")
	public List<Station> retrievestations() throws IllegalStateException, SecurityException, SystemException
	{
		TypedQuery<Station> query = em.createQuery("SELECT s from Station s", Station.class);
		List<Station> stations = query.getResultList();
		return stations;
	}
	
}