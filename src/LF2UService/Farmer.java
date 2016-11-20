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

import DataGeneration.Farmerdata;
import Service.Farmservice;

@Path("/Farmer")
public class Farmer {
	
	Farmersupport use=new Farmservice();
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
	public Response createfarm(InputStream incomingData)
	{
		String out;
		StringBuilder b=ExtractString(incomingData);
		if(b==null)
		{
			return Response.status(Response.Status.NOT_FOUND).entity("no Json input").build();
		}
		out=use.create(b);
		
		
		return Response.status(201).entity(out).build();
		
	}
	
	@Path("/{fid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatefarmaccount(@PathParam("fid")String fid ,InputStream incomingData, @Context UriInfo i)
	{boolean a;
	StringBuilder b;
	b=ExtractString(incomingData);
	if(b==null)
	{
		return Response.status(Response.Status.NOT_FOUND).entity("no Json input").build();
	}
	a=use.update(fid,b);
		if(a==false)
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Farm not found for ID: " + fid).build();
		}
		
	else{
		UriBuilder builder = i.getAbsolutePathBuilder();
	       builder.path(fid);
		return Response.created(builder.build()).build();
	}
	}
	
	
	@Path("/{fid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response showfarmdetails(@PathParam("fid")String fid)
	{ 
		String out;
	out=use.getfarm(fid);
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Farmer account not found for ID: " +fid).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response showfarmzip(@QueryParam("zip")String zi)
	{
		if(zi==null)
		{
			return Response.status(Response.Status.NOT_FOUND).entity("No input zip code").build();
		}
		String out;
		out=use.zip(zi);
		System.out.println(zi+"is checked");
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Farm not found for ID: " + zi).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
		
	}
	
	@Path("/{fid}/products")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response showproduct(@PathParam("fid")String s)
	{
		String out;
		out=use.productslist(s);
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("No product found in the farm with  ID: " + s).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
	}
	@Path("/{fid}/products")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addproduct(@PathParam("fid")String s,InputStream incomingData)
	{
		
		String out;
		StringBuilder b;
		b=ExtractString(incomingData);
		out=use.createprod(s,b);
		return Response.status(200).entity(out).build();
	}
	
	@Path("/{fid}/products/{fspid}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addprice(@PathParam("fid")String s,@PathParam("fspid")String s1,InputStream incomingData, @Context UriInfo i)
	{
		boolean a;
		 StringBuilder b;
		 b=ExtractString(incomingData);
		a=use.updateproductinfo(s,s1,b);
		if(a==false)
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Product  not found for ID: " + s1).build();
		}
		
	else{
		UriBuilder builder = i.getAbsolutePathBuilder();
	       builder.path("s/s1");
		return Response.created(builder.build()).build();
	}
		
		
	}
	
	@Path("/{fid}/products/{fspid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getproddetails(@PathParam("fid")String s,@PathParam("fspid")String s1)
	{
		String out;
		out=use.getproductdetails(s,s1);
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("product details  not found for FID: " +s+" FSPID :"+s1).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
		
	}
	@Path("/{fid}/reports")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getreportlist(@PathParam("fid")String s)
	
	{
		String out;
		out=use.getreportlist();
		return Response.status(200).entity(out).build();
	}
	@Path("/{fid}/reports/{frid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getreportlistda(@PathParam("fid")String s,@PathParam("frid")int s1,@QueryParam("start_date") String st1,@QueryParam("end_date") String st2)
	
	{ String out;
		if(s1==701||s1==702)
		{
			out=use.getreport(s,s1);
			return Response.status(200).entity(out).build();
		}
		if(s1==(703)||s1==704)
		{
			if(st1==null||st2==null)
			{
				
				out=use.getreport1(s,s1);
				if(out.equals("[]"))
				{
					return Response.status(Response.Status.NOT_FOUND).entity("No Report records found").build();
				}
				return Response.status(200).entity(out).build();
			}
			out=use.getreport1(s,s1,st1,st2);
			if(out.equals("[]"))
			{
				return Response.status(Response.Status.NOT_FOUND).entity("No Report records found").build();
			}
			return Response.status(200).entity(out).build();
		}
		
			return Response.status(Response.Status.NOT_FOUND).entity("No Report records found").build();
		
		
	}
	
@Path("/{fid}/delivery_charge")
@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response setdeleiverycharges(@PathParam("fid")String s,InputStream incomingData, @Context UriInfo i)
{
	
	boolean a;
	StringBuilder b;
	
	b=ExtractString(incomingData);
	if(b==null)
	{
		return Response.status(Response.Status.NOT_FOUND).entity("no Json input").build();
	}
    a=use.deliverycharge(s,b);
	if(a==false)
	{
		return Response.status(Response.Status.NOT_FOUND).entity("Farm not found for ID: " + s).build();
	}
	
else{
	UriBuilder builder = i.getAbsolutePathBuilder();
      builder.path(s);
	return Response.created(builder.build()).build();
}
}
@Path("/{fid}/delivery_charge")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response setdeleiverycharges(@PathParam("fid")String s)
{
	System.out.print("delvery charge");
	String out;
	out=use.getdeliverycharges(s);
	if(out.equals("[]"))
	{
		return Response.status(Response.Status.NOT_FOUND).entity("Farm   not found for ID: " +s).build();
	}
	else
	{
		return Response.status(200).entity(out).build();
	}
	
}
}
	

