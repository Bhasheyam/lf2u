package LF2UService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.catalogmange;
import Service.Managerscope;

@Path("/Manager")

public class Manager {
	
	Managersupport use=new Managerscope();
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
		String out;
		out=use.getcatlist();
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Catalog is empty" ).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
		
	}
	
	@Path("/catalog")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createcat(InputStream incomingData)
	{
		String out;
		StringBuilder out1=ExtractString(incomingData);
		out=use.addcat(out1);
		
	return Response.status(201).entity(out).build();
	}
	
	@Path("/catalog/{gcpid}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Updatecat(InputStream incomingData,@PathParam("gcpid")String s, @Context UriInfo i)
	{
		String out;
		StringBuilder b;
		b=ExtractString(incomingData);
		boolean a=use.update(s,b);
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
	
	@Path("/accounts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response account()
	{
	
		String out;
		out=use.getmlist();
		return Response.status(200).entity(out).build();
		
	}
	@Path("/accounts/{mid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response accountwid(@PathParam("mid")int s)
	{
		String out;
		out=use.getmanager(s);
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("manager account not found for ID: " + s).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
	}	
	
	@Path("/reports")
	@	GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getreportlist()
	
	{
		String out;
		out=use.getreplist();
		return Response.status(200).entity(out).build();
		
	}
	@Path("/{fid}/reports/{mrid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getreportlistda(@PathParam("fid")String s,@PathParam("mrid")String s1,@QueryParam("start_date") String st1,@QueryParam("end_date") String st2)
	
	{
		String out;
		
		if(s1.equals("1") || s1.equals("2"))
		{
			out= use.getreportt1(s,s1);
		}
		else if(s1.equals("3") || s1.equals("4"))
		{
			out=use.getreportt2(s,s1,st1,st2);
		}
		else if(s1.equals("5"))
		{
			out=use.getreportt3(s,s1,st1,st2);
		}
		else
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Report  not found for MRID: " + s1).build();
		}
		return Response.status(200).entity(out).build();
	}

	
}
