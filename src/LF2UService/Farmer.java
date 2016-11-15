package LF2UService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import DataGeneration.Farmerdata;

@Path("/Farmer")
public class Farmer {
	ObjectMapper mapper = new ObjectMapper();
	
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

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response check1(InputStream incomingData, @Context UriInfo i)throws Exception
	{
		String s;
		s=incomingData.toString();
		return Response.status(200).entity(s).build();	
	}
	
//Consumes(MediaType.TEXT_PLAIN)
//	public Response check(InputStream incomingData, @Context UriInfo i)throws Exception
//	{
//		Farmerdata f;
//		StringBuilder jsonInString = ExtractString(incomingData);
//		f=mapper.readValue(jsonInString.toString(),Farmerdata.class);
//		String s=f.getfid();
//		System.out.println("s val " + s);
//		return Response.status(200).entity(s).build();	
//	}
	
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response createfarm(String json)
//	{
//		return null;
//		
//	}
//	
//	@Path("/{fid}")
//	@PUT
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response updatefarmaccount(@PathParam("id")int id ,String s)
//	{
//		return null;
//	}
//	@Path("/{fid}")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response showfarmdetails()
//	{
//		return null;
//	}
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response showfarmzip()
//	{
//		return null;
//	}
//	
}
