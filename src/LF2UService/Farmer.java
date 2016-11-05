package LF2UService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Farmer")
public class Farmer {

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createfarm(String json)
	{
		return null;
		
	}
	
	@Path("/{fid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatefarmaccount(@PathParam("id")int id ,String s)
	{
		return null;
	}
	@Path("/{fid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response showfarmdetails()
	{
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response showfarmzip()
	{
		return null;
	}
	
}
