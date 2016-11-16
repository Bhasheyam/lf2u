package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.Customerdetails;
import DataGeneration.catalogmange;
import DataGeneration.corders;
import DataGeneration.place_order;
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
public static List<corders> use1=new ArrayList<corders>();


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
	public void update(String s, StringBuilder b) {
		
		
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

@Override
public String Showorder(String s) {
	String out;
	
	for(orderget p:col3)
	{
		if(p.get()==s)
		{
			corders k;
			k=p.getorders();
			use1.add(k);
		}
	}
	Gson f1 = new GsonBuilder().setPrettyPrinting().create();
	 out=f1.toJson(use1);
	 return out;
	
}
	
}
