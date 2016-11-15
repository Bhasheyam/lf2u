package LF2UService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/delivery")
public class Delivery {

	@Path("/{oid}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response Deliverysta(@PathParam("oid")String s)
	{
		return null;
	}
}
