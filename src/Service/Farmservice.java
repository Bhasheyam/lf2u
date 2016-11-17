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
	public String zip(String zi) {
		
		String out,c,c1;
		zipfarm f=new zipfarm();
		String[] z=new String[20];
		Farmerdata fg=new Farmerdata();
	for(Farmerdata e:col)
	{
		fg=e;
	}
//			for(String d:z)
//			{
//				if(zi.equals(d))
//				{
//					
//					f.setfid(e.getfid());
//					f.setname(e.getFarm_info().getName());
//					temp2.add(f);
//					
//				}
//			}	
//		}
		
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(fg.getDelivers_to());
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
	
	
	
	

}
