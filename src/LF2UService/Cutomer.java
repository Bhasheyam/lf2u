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

import Service.Customerser;



@Path("/Customer")
public class Cutomer {
	Customersupport use=new Customerser();
	
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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createaccount(InputStream incomingData)
	{
		String out;
		StringBuilder b=ExtractString(incomingData);
		out=use.createaccount(b);
		
		
		return Response.status(201).entity(out).build();
		
	}
	@Path("/{cid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateaccount(@PathParam("cid")String s,InputStream incomingData)
	{
		String out;
		StringBuilder b=ExtractString(incomingData);
		use.update(s,b);
		
	}
	@Path("/{cid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response Getcustomeraccount(@PathParam("cid")String s)
	{
		String out;
		out=use.getcustomer(s);
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("customer account not found for ID: " + s).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
		
	}
	
	@Path("/{cid}/orders")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response order(@PathParam("cid")String s,InputStream incomingData)
	{
		String out;
		StringBuilder b;
		b=ExtractString(incomingData);
		out=use.createorder(s,b);
		return Response.status(200).entity(out).build();
	}
	
	@Path("/{cid}/orders")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getorders(@PathParam("cid")String s)
	{
		return null;
	}
	
	@Path("/{cid}/orders/{oid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getorderswithid(@PathParam("cid")String s,@PathParam("oid")String s1)
	{
		return null;
	}
	
	@Path("/{cid}/orders/{oid}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancel(@PathParam("cid")String s,@PathParam("oid")String s1)
	{
		return null;
	}
	
	

	
}
