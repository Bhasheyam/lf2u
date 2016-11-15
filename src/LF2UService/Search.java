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
@Path("search")
public class Search {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getdetails(@QueryParam("topic")String topic,@QueryParam("key")String key)
	{
		return null;
	}

}
