package LF2UService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("Manager")

public class Manager {
	public StringBuilder ExtractString(InputStream incomingData)
	{
		StringBuilder jsonInString = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				jsonInString.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		return jsonInString;
	}
	
	public JsonNode ExtractJSONNODE(String jsonInString)
	{
		JsonNode jNode = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
		   jNode = mapper.readTree(jsonInString.toString());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	   return jNode;
	}
	
	
	
	
	@Path("/catalog")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response catalog()
	{
		return null;
	}
	@Path("/catalog")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createcat(InputStream incomingData)
	{
		return null;
	}
	@Path("/catalog/{gcpid}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Updatecat(InputStream incomingData,@PathParam("gcpid")String s)
	{
		return null;
	}
	@Path("/accounts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response account()
	{
		return null;
	}
	@Path("/accounts/{mid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response accountwid(@PathParam("mid")String s)
	{
		return null;
	}	
	
	@Path("/{fid}/reports")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getreportlist(@PathParam("fid")String s)
	
	{
		return null;
		
	}
	@Path("/{fid}/reports/{mrid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getreportlistda(@PathParam("fid")String s,@PathParam("frid")String s1,@QueryParam("start_date") String st1,@QueryParam("end_date") String st2)
	
	{
		return null;
		
	}

	
}
