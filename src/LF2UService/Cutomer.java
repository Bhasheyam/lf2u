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
import javax.ws.rs.core.UriBuilder;
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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createaccount(InputStream incomingData)
	{
		String out;
		StringBuilder b=ExtractString(incomingData);
		if(b==null)
		{
			return Response.status(Response.Status.NOT_FOUND).entity("no Json input").build();
		}
		out=use.createaccount(b);
		
		
		return Response.status(201).entity(out).build();
		
	}
	@Path("/{cid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateaccount(@PathParam("cid")String s,InputStream incomingData,@Context UriInfo i)
	{
		
		boolean a;
		StringBuilder b=ExtractString(incomingData);
		if(b==null)
		{
			return Response.status(Response.Status.NOT_FOUND).entity("no Json input").build();
		}
		a=use.update(s,b);
		if(a==false)
		{
			 return Response.status(Response.Status.NOT_FOUND).entity("product not found for ID: " + s).build();
		}
		else
		{
			UriBuilder builder = i.getAbsolutePathBuilder();
		       builder.path(s);
			return Response.created(builder.build()).build();
		}
		
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
		if(b==null)
		{
			return Response.status(Response.Status.NOT_FOUND).entity("no Json input").build();
		}
		out=use.createorder(s,b);
		
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Invalid entry order cannot be processed, Either product or customer id is invalid ").build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
	}
	
	@Path("/{cid}/orders")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getorders(@PathParam("cid")String s)
	{
		String out;
		out=use.Showorder(s);
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("customer account not found for ID: " + s).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
	}
	
	@Path("/{cid}/orders/{oid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getorderswithid(@PathParam("cid")String s,@PathParam("oid")String s1)
	{  
		String out;
		out=use.getorderdetails(s,s1);
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("order not found for ID: " + s1).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
		
	
	}
	
	@Path("/{cid}/orders/{oid}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancel(@PathParam("cid")String s,@PathParam("oid")String s1)
	{
		String out;
		out=use.cancel(s,s1);
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Order  not found for ID: " + s).build();
		}
		else if (out.equals("no"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Order ID: " + s+" cannot be cancelled as the order need to be cancelled within the same day ").build();	
		}
		else if(out.equals("can"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Order ID: " + s+"  is already delivered kindly check the status.").build();
			
		}
		else
			{
			return Response.status(200).entity(out).build();
		}
		
	}
	
	

	
}
