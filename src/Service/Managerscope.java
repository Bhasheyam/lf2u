package Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.xml.internal.resolver.CatalogManager;

import DataGeneration.Manageraccount;
import DataGeneration.catalogmange;
import DataGeneration.managereport12;
import DataGeneration.managerreport;
import DataGeneration.managerreport45;
import LF2UService.Managersupport;
import dataList.gcpid;
import dataList.managerreportlis;

public class Managerscope implements Managersupport {
	ObjectMapper mapper = new ObjectMapper();
	managerreportlis m=new managerreportlis();
	public static List<catalogmange> col=new ArrayList<catalogmange>();
	//manager report list
	public String getreplist()
	{
		
		List<managerreport> mh=new <managerreport>ArrayList();
		
		m.setreplist();
		mh=m.getrepmana();
		Gson f = new GsonBuilder().setPrettyPrinting().create();
		String out=f.toJson(mh);
		return out;
		
	}
//manager account list
	@Override
	public String getmlist() {
	String out;
	List<Manageraccount> man=new ArrayList<Manageraccount>();
	
	m.setaccount();
	man=m.getaccount();
	Gson f = new GsonBuilder().setPrettyPrinting().create();
	 out=f.toJson(man);
	return out;
	}
//manager with an id
	@Override
	public String getmanager(int mid) {
		String out;
		List<Manageraccount> man=new ArrayList<Manageraccount>();
		List<Manageraccount> man1=new ArrayList<Manageraccount>();
		
		m.setaccount();
		man=m.getaccount();
		
		
	for(Manageraccount mn:man)
	{
		if(mn.getmid()==mid)
		{
			man1.add(mn);
			
		}
		
	}
	
	Gson f = new GsonBuilder().setPrettyPrinting().create();
	 out=f.toJson(man1);
	return out;
	}
//manager report type 1 and 2
	@Override
	public String getreportt1(String s, String s1) {
		String out;
		List<managereport12> m2=new ArrayList<managereport12>();
	   
		m2=m.getrep1();
		Gson f = new GsonBuilder().setPrettyPrinting().create();
		 out=f.toJson(m2);
		return out;
	}
	//manager report type 4 and 5
	@Override
	public String getreportt2(String s, String s1, String s2, String s3) {
		String out;
		 List<managerreport45> m3=new ArrayList<managerreport45>();
		 m3=m.getrep2();
		Gson f = new GsonBuilder().setPrettyPrinting().create();
		 out=f.toJson(m3);
		return out;
	}
	//manager report type 3
	@Override
	public String getreportt3(String s, String s1, String s2, String s3) {
		String out;
		 List<managerreport45> m3=new ArrayList<managerreport45>();
		 m3=m.getrep2();
			Gson f = new GsonBuilder().setPrettyPrinting().create();
			 out=f.toJson(m3);
			 return out;		 
	}
//catalog add
	@Override
	public String addcat(StringBuilder out1) {
	
	String out;
	catalogmange use1;
	//mapping the value
	Gson f = new Gson();
	use1=f.fromJson(out1.toString(), catalogmange.class);
	//adding to a list to have concolidated one.
	col.add(use1);
	
	gcpid g=new gcpid();
	//to print the json
	//sending json out
	String p=use1.getGcpid();
	g.set(p);
	Gson f1 = new GsonBuilder().setPrettyPrinting().create();
	 out=f1.toJson(g);
	 return out;	
	 
	}
//catalog list
	@Override
	public String getcatlist() {
		String out;
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(col);
		 return out;
	}
	//catalog search
	@Override
	public boolean update(String s, StringBuilder b)  {
		boolean b1=false;
		
		for(catalogmange h:col)
		{ 
			String check=h.getGcpid();
			if(check.equals(s))
			{
				int i=col.indexOf(h);
				
				Gson f = new Gson();
	
					h= mapper.readValue(b.toString(),catalogmange.class);
				
				col.set(i,h);
				b1=true;
			}
		}
		
		return b1;
	}
	

	
	
	
	

}
