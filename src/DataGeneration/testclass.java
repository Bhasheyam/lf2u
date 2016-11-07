package DataGeneration;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import dataList.*;

import java.util.Iterator;
public class testclass {

	public static void main(String[] args)  {
	 List<managerreport> mh=new ArrayList<managerreport>();
		managerreportlis m=new managerreportlis();
		m.setreplist();
		mh=m.getrepmana();
		
		Gson f = new GsonBuilder().setPrettyPrinting().create();
		String out=f.toJson(mh);
		System.out.println(out);
		for(managerreport n:mh)
		{
			System.out.println(n.toString());
		}
		
		order o=new order();
		supportdc k=new supportdc();
		if(o.cancel())
		{
			k.Support("cancelled");
			
			List<supportdc> lk=new ArrayList<supportdc>();
			k.getstatus();
			lk.add(k);
			Gson f1 = new GsonBuilder().setPrettyPrinting().create();
			String out1=f.toJson(lk);
			System.out.println(out1);
			
			
		}
		
				
	}
	
}
