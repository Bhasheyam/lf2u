package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.Customerdetails;
import DataGeneration.Idgen;
import DataGeneration.catalogmange;
import DataGeneration.corders;
import DataGeneration.place_order;
import DataGeneration.supportdc;
import LF2UService.Customersupport;
import ServiceSupport.cid;
import dataList.gcpid;
import dataList.oid;
import dataList.orderget;

public class Customerser implements Customersupport {
public static List<Customerdetails> col=new ArrayList<Customerdetails>();
public static List<place_order> col1=new ArrayList<place_order>();
public static List<corders> col2=new ArrayList<corders>();
public static List<orderget> col3=new ArrayList<orderget>();
 List<corders> col4=new ArrayList<corders>();


	@Override
	public String createaccount(StringBuilder b) {
		String out;
		Customerdetails h;
		//mapping the value
		Gson f = new Gson();
		h=f.fromJson(b.toString(), Customerdetails.class);
		//adding to a list to have concolidated one.
		
		col.add(h);
		cid g=new cid();
		
		//to print the json
		//sending json out
		String p=h.getcid();
		g.set(p);
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(g);
		 return out;	
		 
	}
	@Override
	public boolean update(String s, StringBuilder b) {
		
		boolean a=false;
		for(Customerdetails h:col)
		{ 
			String check=h.getcid();
			if(check.equals(s))
			{
				Customerdetails d;
				int i=col.indexOf(h);
				
				
				Gson f = new Gson();
	
					d=f.fromJson(b.toString(),Customerdetails.class);
				d.setcid(check);
				col.set(i,d);
				a=true;
			}
		}
		
		return a;
		
	}
	@Override
	public String getcustomer(String s) {
		 List<Customerdetails> use1=new ArrayList<Customerdetails>();
		String out;
		for(Customerdetails h:col)
		{ 
			String check=h.getcid();
			if(check.equals(s))
			{
			use1.add(h);
			}
		}
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(use1);
		 return out;	
	}
	@Override
	public String createorder(String s, StringBuilder b) {
	      String out;
	      place_order p;
	      boolean b1=false;
	      for(Customerdetails h:col)
			{ 
				String check=h.getcid();
				if(check.equals(s))
				{
				b1=true;
				}
			}
	      if(b1==true){
	    	  
	      
	Gson f=new Gson();
	p=f.fromJson(b.toString(), place_order.class);
	col1.add(p);
	
	//mapping th order details
	corders o=new corders();
	String t=p.getFid();
	String t1=p.getoid();
	o.setFid(t);
	o.setOid(t1);
	col2.add(o);
	
	//sending json class
	oid o1=new oid();
	String g=p.getoid();
	o1.set(g);
	
	//update view order
	orderget k=new orderget();
	k.set(s);
	k.setoid(g);
	k.setorders(o);
	col3.add(k);
	//getClass.converting json
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(o1);
		 return out;
		
	}
	      else {
	    	  return "[]";
	      }
	}

@Override
public String Showorder(String s) {
	String out;
	String c,c1;
	
	for(orderget p:col3)
	{
		c=p.getcid();
		if(c.equals(s))
		{
			col4.add(p.getorders());
			
		}
	}
	Gson f1 = new GsonBuilder().setPrettyPrinting().create();
	 out=f1.toJson(col4);
	 return out;
}
@Override
public String cancel(String s, String s1) {
	String out;
	String g,ck,ck1;
	Idgen i=new Idgen();
	for(corders e1:col2)
	{
		g=e1.getOid();
		if(g.equals(s1))
		{
			ck=i.getcurrentdate();
			ck1=e1.getOrder_date();
			if(ck.equals(ck1))
			{
				e1.setStatus("cancelled");
			supportdc d=new supportdc();
			d.Support("cancelled");
			Gson f1 = new GsonBuilder().setPrettyPrinting().create();
			 out=f1.toJson(d);
			 return out;
			}
			else 
			{
				return "no";
			}
		}
	}
	
	return "[]";
	 
	
}

	

	
}
	

