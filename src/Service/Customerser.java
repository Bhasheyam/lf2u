package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.Customerdetails;
import DataGeneration.Farm_info;
import DataGeneration.Farmerdata;
import DataGeneration.Idgen;
import DataGeneration.OrderReport;
import DataGeneration.Order_detail;
import DataGeneration.Order_details;
import DataGeneration.Productdetails;
import DataGeneration.catalogmange;
import DataGeneration.corders;
import DataGeneration.place_order;
import DataGeneration.supportdc;
import LF2UService.Customersupport;
import LF2UService.Deliversupport;
import ServiceSupport.cid;
import dataList.Delivery;
import dataList.gcpid;
import dataList.oid;
import dataList.orderget;

public class Customerser implements Customersupport {
public static List<Customerdetails> col=new ArrayList<Customerdetails>();
public static List<place_order> col1=new ArrayList<place_order>();
public static List<corders> col2=new ArrayList<corders>();
public static List<orderget> col3=new ArrayList<orderget>();
public static List<OrderReport> col5=new ArrayList<OrderReport>();
 List<corders> col4=new ArrayList<corders>();

public static List<corders> getcorder()
{
	return col2;
}
public static List<orderget> getorderget()
{
	return col3;
}
public static void setcorder(List<corders> s)
{
	col2=s;
}
public static void setorderget(List<orderget> s)
{
	col3=s;
}

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
	      String out,c,c1,c2,c3,c4,c5,c6,c7,c8,c9;
	      place_order p;
	      Farm_info far=new Farm_info();
	      List<Farmerdata> temp=new ArrayList<Farmerdata>();
	      List<Productdetails> temp2=new ArrayList<Productdetails>();
	      List<Delivery> temp3=new ArrayList<Delivery>();
	      List<catalogmange> temp4=new ArrayList<catalogmange>();
	      List<Order_details> orderlist = new ArrayList<Order_details>();
	      Order_detail[] order;
	      double d1,d2,d3,d4=0.0d;
	      OrderReport rep=new OrderReport();
	      Order_details repo=new Order_details();
	      	  
	      //mapping
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
	      	o1.set(t1);
	//updating the order report
	      	 rep.setOid(t1);
	      	 rep.setOrder_date(o.getOrder_date());
	      	 rep.setPlanned_delivery_date(o.getPlanned_delivery_date());
	      	 rep.setActual_delivery_date(o.getActual_delivery_date());
	      	 rep.setStatus(o.getStatus());
	      	 temp=Farmservice.getfarmlist();
	      	temp2=Farmservice.getproductlist();
	      	temp3=Farmservice.getdeliverylist();
	      	temp4=Managerscope.getlist();
	      order=p.getOrder_detail();
	      	 for(Farmerdata fa:temp)
	      	 {
	      		 c=fa.getfid();
	      		 if(c.equals(t1))
	      		 {
	      			 far=fa.getFarm_info();
	      		 }
	      	 }
	      	 far.setfid(t1);
	      	 rep.setFarm_info(far);
	      	 rep.setDelivery_note(p.getDelivery_note());
	      	 for(Delivery dp:temp3)
	      	 {
	      		 c2=dp.getid();
	      		 if(c2.equals(t))
	      		 {
	      			 rep.setDelivery_charge(dp.getcharges());
	      		 }
	      	 }
	      	 for(Order_detail h:order)
	      	 {
	      		 c4=h.getFspid();
	      		 d1=h.getamount();
	      	 
	      	 for(Productdetails gg:temp2)
	      	 {
	      		 c3=gg.getfspid();
	      		 if(c3.equals(c4))
	      		 {
	      			 repo.setFspid(c3);
	      			 d2=gg.getPrice();
	      			 d3=d2*d1;
	      			 repo.setLine_item_total(d3);
	      			 d4=d4+d3;
	      			 c5=gg.getPrice()+"per "+gg.getProduct_unit();
	      			 repo.setPrice(c5);
	      			 c6=d1+" "+gg.getProduct_unit();
	      			 repo.setOrder_size(c6);
	      			 c8=gg.getGcpid();
	      			 for(catalogmange lk:temp4)
	      			 {
	      				 c7=lk.getGcpid();
	      				 if(c8.equals(c7))
	      				 {
	      					 repo.setName(lk.getName());
	      					 orderlist.add(repo);
	      					 
	      				 }
	      			 }
	      		 } 
	      		 
	      	 }
	      	 
	      	 }
	      	 rep.setProducts_total(d4);
			 col5.add(rep);
	//update view order
	      	orderget k=new orderget();
	      	k.set(s);
	      	k.setoid(t1);
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
	String g,ck,ck1,ck2;
	Idgen i=new Idgen();
	for(corders e1:col2)
	{
		g=e1.getOid();
		if(g.equals(s1))
		{
			ck=i.getcurrentdate();
			ck1=e1.getOrder_date();
			ck2=e1.getStatus();
			if(ck2.equals("open"))
			{
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
			else
			{
				return "can";
			}
		}
	}
	
	return "[]";
	 
	
}
@Override
public String getorderdetails(String s, String s1) {
	String out,c,c1,c2;
	boolean a=false;
	OrderReport use=new OrderReport();
	
	for(orderget k:col3)
	{
		c=k.getcid();
		c1=k.getoid();
		if(c.equals(s)&&c1.equals(s1))
		{
			a=true;
		}
		else
		{
			return "invalid";
		}
	}
	if(a==true)
	{
	for(OrderReport o:col5)
	{
		c=o.getOid();
		if(c.equals(s1))
		{
			use=o;
		}
	}
	}
	Gson f1 = new GsonBuilder().setPrettyPrinting().create();
	 out=f1.toJson(use);
	 return out;
}
}

	

	

	

