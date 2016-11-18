package Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.Customerdetails;
import DataGeneration.Farmerdata;
import DataGeneration.Productdetails;
import DataGeneration.Report;
import LF2UService.Farmersupport;
import dataList.*;
import DataGeneration.Farmerdata;

public class Farmservice implements Farmersupport {
	
public static List<Farmerdata> col=new ArrayList<Farmerdata>();
public static List<Productdetails> col1=new ArrayList<Productdetails>();
public static List<Productlist> col2=new ArrayList<Productlist>();
List<Productdetails> temp=new ArrayList<Productdetails>();
List<zipfarm> temp2=new ArrayList<zipfarm>();
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
		String ss,c,c1,c2,c3,c4,c5,k,k1;
		Productdetails pd;
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
				if(c1!=null)
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
		return a;
	}
	@Override
	public String getfarmdetails(String s, String s1) {
		
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
	
	
	
	

}
