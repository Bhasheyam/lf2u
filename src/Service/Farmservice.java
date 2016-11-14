package Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.Farmerdata;
import dataList.*;
import DataGeneration.Farmerdata;

public class Farmservice {
	
	
	public String Addaccount(String s)
	{
		String s1;
		Gson d=new GsonBuilder().setPrettyPrinting().create();
		Farmerdata f=(Farmerdata) d.fromJson(s,Farmerdata.class);
		
		Farmerlist l=new Farmerlist();
		l.add(f);
		s1=f.getfid();
		
		return s1;
	}

}
