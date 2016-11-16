package LF2UService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Service.Searchresuts;
@Path("search")
public class Search {
	
	searchsupport use=new Searchresuts();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getdetails(@QueryParam("topic")String topic,@QueryParam("key")String key)
	{
		String out;
		out=use.search(topic,key);
		
		
		 return Response.status(200).entity(out).build();
	}

	
	

}
