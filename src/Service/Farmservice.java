package Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.Customerdetails;
import DataGeneration.Farmerdata;
import DataGeneration.Idgen;
import DataGeneration.OrderReport;
import DataGeneration.Ordered_by;
import DataGeneration.Productdetails;
import DataGeneration.Report;
import DataGeneration.Report1;
import DataGeneration.orders;
import DataGeneration.report3;
import LF2UService.Farmersupport;
import dataList.*;
import DataGeneration.Farmerdata;

public class Farmservice implements Farmersupport {
	
public static List<Farmerdata> col=new ArrayList<Farmerdata>();
public static List<Productdetails> col1=new ArrayList<Productdetails>();
public static List<Productlist> col2=new ArrayList<Productlist>();
public static List<Delivery> col3=new ArrayList<Delivery>();
List<Productdetails> temp=new ArrayList<Productdetails>();
List<zipfarm> temp2=new ArrayList<zipfarm>();
public static List<Farmerdata> getfarmlist()
{
	return col;
}
public static List<Delivery> getdeliverylist()
{
	return col3;
}public static List<Productdetails> getproductlist()
{
	return col1;
}

	@Override
	public String create(StringBuilder b) {
		String out;
		String use1;
		Farmerdata f;
		Gson use=new Gson();
		f=use.fromJson(b.toString(),Farmerdata.class );
		col.add(f);
		fid op=new fid();
		use1=f.getfid();
		op.set(use1);
		
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(op);
		 return out;
		
		
	}
	@Override
	public boolean update(String fid, StringBuilder b) {
		boolean a=false;
		String s;
		for(Farmerdata g:col)
		{
			s=g.getfid();
			if(s.equals(fid))
			{
				Farmerdata f1;
				int i=col.indexOf(g);
				
				
				Gson f = new Gson();
	
					f1=f.fromJson(b.toString(),Farmerdata.class);
				f1.setfid(s);
				col.set(i,f1);
				a=true;
			}
		}
		
		return a;
		
	}
	@Override
	public String getfarm(String fid) {
		String out,u;
		for(Farmerdata t:col)
		{
			u=t.getfid();
			if(u.equals(fid))
			{
			Gson f1 = new GsonBuilder().setPrettyPrinting().create();
			 out=f1.toJson(t);
			 return out;
			}
		}
	return"[]";
		
	}
	@Override
	public String zip(String zi) throws NullPointerException {
		
		String out,c,c1;
		
		
	for(Farmerdata e:col)
	{
		String[] z=new String[100];
		z=e.getDelivers_to();
		for(String d:z)
			{
				if(zi.equals(d))
				{
					zipfarm f=new zipfarm();
					f.setfid(e.getfid());
					f.setname(e.getFarm_info().getName());
					temp2.add(f);
					
				}
			}	
		}
		
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(temp2);
		 return out;
		
	}
	@Override
	public String productslist(String s) {
		String out,c;
		for(Productlist h:col2)
		{
			c=h.getid();
			if(c.equals(s))
			{
				temp.add(h.getprod());
			}
		}
		Gson f=new GsonBuilder().setPrettyPrinting().create();
		out=f.toJson(temp);
		return out;
	}
	@Override
	public String createprod(String s, StringBuilder b) {
		String out,c;
		Productdetails prod;
		Gson f1=new Gson();
		prod=f1.fromJson(b.toString(),Productdetails.class );
		c=prod.getfspid();
		col1.add(prod);
		Productlist prodl=new Productlist();
		prodl.setid(s);
		prodl.setpid(c);
		prodl.setprod(prod);
		col2.add(prodl);
				
		fspid fs=new fspid();
		fs.setfspid(c);
		Gson f=new GsonBuilder().setPrettyPrinting().create();
		out=f.toJson(fs);
		return out;
		
	}
	@Override
	public boolean updateproductinfo(String s, String s1, StringBuilder b) {
		boolean a=false;
		String ss,c,c2,c3,c4,c5,k,k1,z;
		double c1;
		Productdetails pd;
		for(Productlist prod:col2)
		{
			z=prod.getid();
			if(z.equals(s))
			{
		Gson g=new Gson();
		pd=g.fromJson(b.toString(),Productdetails.class);
		for(Productdetails g1:col1)
		{
			ss=g1.getfspid();
			if(ss.equals(s1))
			{
				c=pd.getNote();
				if(c!=null)
				{
					g1.setNote(c);
				}
				c1=pd.getPrice();
				if(c1!=0.0d)
				{
					g1.setPrice(c1);
				}
				c2=pd.getStart_date();
				if(c2!=null)
				{
					g1.setStart_date(c2);
				}
				c3=pd.getEnd_date();
				if(c3!=null)
				{
					g1.setEnd_date(c3);
				}
				c4=pd.getProduct_unit();
				if(c4!=null)
				{
					g1.setProduct_unit(c4);
				}
				c5=pd.getImage();
				if(c5!=null)
				{
					g1.setImage(c5);
				} 
				for(Productlist h:col2)
				{
					k=h.getpid();
					if(k.equals(s1))
					{
						h.setprod(g1);
						a=true;
					}
					
				}
			}
			
		}
		}
		}
		return a;
	}
	@Override
	public String getproductdetails(String s, String s1) {
		
	String out,k,k1;
	Productdetails temp;
		for(Productlist h:col2)
		{
			k=h.getpid();
			k1=h.getid();
			if(k1.equals(s) && k.equals(s1))
			{
				temp=h.getprod();
				Gson f=new GsonBuilder().setPrettyPrinting().create();
				out=f.toJson(temp);
				return out;
				
			}
		
	}
		return "[]";
	}
	@Override
	public String getreportlist() {
		String out;
		FarmerReport report=new FarmerReport();
		List<Report> h=new ArrayList<Report>();
		h=report.getlist();
        Gson f=new GsonBuilder().setPrettyPrinting().create();
		out=f.toJson(h);
		return out;
				
				
		
	}
	@Override
	public boolean deliverycharge(String s,StringBuilder b) {
		boolean a=false;
		String l;
		
		Delivery d1=new Delivery();
		
		for(Farmerdata r:col)
		{
			l=r.getfid();
			if(s.equals(l))
	        {
				Gson g=new Gson();
				d1=g.fromJson(b.toString(),Delivery.class);
				r.setdeliverycharges(d1.getcharges());
				d1.setfid(s);
				col3.add(d1);
				a=true;
	      }
	  	}
    	
		return a;
	}
	@Override
	public String getdeliverycharges(String s) {
		String out,c;
		deliverysup d1=new deliverysup();
		for(Delivery j:col3)
		{
			c=j.getid();
			if(c.equals(s))
			{
	           d1.setcharge(j.getcharges());
	           Gson f=new GsonBuilder().setPrettyPrinting().create();
	           out=f.toJson(d1);
	           return out;
			}
		
		}
		
		return"[]";
	}
	public  String getcurrentdate()
	{
		DateFormat df = new SimpleDateFormat("yyyyMMdd ");
		Date dateobj = new Date();
		return df.format(dateobj);
	}
	
	
	public String getcid(String s)
	{ String out="",c1;
		List<orderget> temp4=new ArrayList<orderget>();
		
		temp4=Customerser.getorderget();
		for(orderget k:temp4)
		{
			c1=k.getoid();
			if(c1.equals(s))
			{
				out=k.getcid();
			}
		}
		return out;
		
	}
	@Override
	public String getreport(String s, int s1) {
		String out, key,cid,c1,c2,c3;
		String l1,l2;
		List<Report1> temp=new ArrayList<Report1>();
		List<orders> ordl=new ArrayList<orders>();
		
		
		
		List<OrderReport> temp1=new ArrayList<OrderReport>();
		List<Customerdetails> temp2=new ArrayList<Customerdetails>();
		temp1=Customerser.getorderlist();
		temp2=Customerser.getcustomer();
		
		if(s1==701)
		{
			key=getcurrentdate();
			l1="Orders to deliver today";
		}
		else
		{
			key=getnextday();
			l1="Orders to deliver tomorrow";
		}
		Report1 rep1=new Report1();
		rep1.setFrid(s1);
		rep1.setName(l1);
		for(OrderReport o:temp1)
		{
			orders ord=new orders();
			Ordered_by ord1=new Ordered_by();
			cid=getcid(o.getOid());
			c1=o.getPlanned_delivery_date();
			c2=o.getFarm_info().getfid();
			if(c2.equals(s)&& c1.equals(key))
			{
				
				ord.setOrder_detail(o.getOrder_detail());
				ord.setoid(o.getOid());
				ord.setActual_delivery_date(o.getActual_delivery_date());
				ord.setDelivery_charge(o.getDelivery_charge());
				ord.setOrder_date(o.getOrder_date());
				ord.setOrder_total(o.getOrder_total());
				ord.setProducts_total(o.getProducts_total());
				ord.setPlanned_delivery_date(o.getPlanned_delivery_date());
				ord.setNote(o.getDelivery_note());
				ord.setStatus(o.getStatus());
				for(Customerdetails c:temp2)
				{
					c3=c.getcid();
					if(c3.equals(cid))
					{
						ord1.setName(c.getName());
						ord1.setEmail(c.getEmail());
						ord1.setPhone(c.getPhone());
						ord.setDelivery_address(c.getStreet()+" "+c.getZip());	
				}
				}
				ord.setOrdered_by(ord1);

			}
			ordl.add(ord);
		}
		rep1.setOrders(ordl);	
		temp.add(rep1);
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(temp);
		return out;
	}
	public   String getnextday()
	{
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd ");
		Date dateobj = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dateobj);
	    cal.add(Calendar.DATE, 1); 
	    dateobj=cal.getTime();
		return df.format(dateobj);
	}
	@Override
	public String getreport1(String s,int s1, String st1, String st2) {
		String out;
		Date enddate=null;
		Date startdate=null;
		String l1,l2;
		int t1=0,t2=0,t3=0;
		double d1=0.0d,d2=0.0d;
		report3 rep1=new report3();
		List<OrderReport> temp=new ArrayList<OrderReport>();
		temp=Customerser.getorderlist();
		List<OrderReport> temp1=new ArrayList<OrderReport>();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		DateFormat df1 = new SimpleDateFormat("yyyyMMdd");
		try {
			 startdate=df.parse(st1);
			 enddate=df.parse(st2);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		if(s1==703)
		{
		rep1.setFrid(s1);
		rep1.setName("Revenue report");
		int i=startdate.compareTo(enddate);
		while(i!=0)
		{
			String g=df1.format(startdate);
			for(OrderReport f:temp)
			{
				if(g.equals(f.getOrder_date())&&s.equals(f.getFarm_info().getfid()))
				{
					t1=t1+1;
					String st=f.getStatus();
							if(st.equals("cancelled"))
							{
								t2=t2+1;
							}
					if(st.equals("delivered"))
					{
						t3=t3+1;
						d1=d1+f.getProducts_total();
						d2=d2+f.getDelivery_charge();
					}
					
				}
			}
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(startdate);
		    cal.add(Calendar.DATE, 1); 
		    startdate=cal.getTime();
		}
		rep1.setDelivery_revenue(d2);
		rep1.setOrders_cancelled(t2);
		rep1.setOrders_placed(t1);
		rep1.setDelivery_revenue(d1);
		rep1.setOrders_delivered(t3);
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(rep1);
		return out;
		
		}
		if(s1==704)
		{
			while(startdate.compareTo(enddate)!=0)
			{
				String g=df.format(startdate);
				for(OrderReport f:temp)
				{
					if(g.equals(f.getOrder_date())&&s.equals(f.getFarm_info().getfid())){
						if(f.getStatus().equals("delivered")){
							temp1.add(f);
						}
					}
			}
				
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(startdate);
			    cal.add(Calendar.DATE, 1); 
			    startdate=cal.getTime();
			}
			Gson f1 = new GsonBuilder().setPrettyPrinting().create();
			 out=f1.toJson(temp1);
			return out;
		}
		return "";
	}
	@Override
	public String getreport1(String s, int s1) {
		
		String out;
		int t1=0,t2=0,t3=0;
		double d1=0.0d,d2=0.0d;
		report3 rep1=new report3();
		List<OrderReport> temp=new ArrayList<OrderReport>();
		temp=Customerser.getorderlist();
		List<OrderReport> temp1=new ArrayList<OrderReport>();

		if(s1==703)
		{
		rep1.setFrid(s1);
		rep1.setName("Revenue report");
			for(OrderReport f:temp)
			{
				if(s.equals(f.getFarm_info().getfid()))
				{
					t1=t1+1;
					String st=f.getStatus();
							if(st.equals("cancelled"))
							{
								t2=t2+1;
							}
					if(st.equals("delivered"))
					{
						t3=t3+1;
						d1=d1+f.getProducts_total();
						d2=d2+f.getDelivery_charge();
					}
					
				}
			}
		rep1.setDelivery_revenue(d2);
		rep1.setOrders_cancelled(t2);
		rep1.setOrders_placed(t1);
		rep1.setDelivery_revenue(d1);
		rep1.setOrders_delivered(t3);
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(rep1);
		return out;
		
		}
		if(s1==704)
		{
		
				for(OrderReport f:temp)
				{
					if(s.equals(f.getFarm_info().getfid())){
						if(f.getStatus().equals("delivered")){
							temp1.add(f);
						}
					}
			}
		}
			
			Gson f1 = new GsonBuilder().setPrettyPrinting().create();
			 out=f1.toJson(temp1);
			return out;
	}
}
