package DataGeneration;
import java.lang.reflect.Array;
import Service.*;
import dataList.*;
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
		String c1,c2;
		String zip[]={"11111","22222"};
		List<simpledatgen> fd=new ArrayList<simpledatgen>();
		List<Farmerdata> fina=new ArrayList<Farmerdata>();
		simpledatgen f1=new simpledatgen();
		Farm_info f2=new Farm_info();
		Personal_info f3= new Personal_info();
		simpledatgen f4=new simpledatgen();
		Farm_info f5=new Farm_info();
		Personal_info f6= new Personal_info();
		
		f3.setEmail("check@123");
		f3.setName("one");
		f3.setPhone("111111");
		f2.setAddress("onefarm");
		f2.setAddress("oneaddfa");
		f2.setPhone("1212121");
		f2.setWeb("check@123f");
		f1.setDelivers_to(zip);
		f1.setFarm_info(f2);
		f1.setPersonal_info(f3);
		f6.setEmail("check@12");
		f6.setName("two");
		f6.setPhone("222222");
		f5.setAddress("twofarm");
		f5.setAddress("twoaddfarm");
		f5.setPhone("22222222222");
		f5.setWeb("check@12f");
		f4.setDelivers_to(zip);
		f4.setFarm_info(f5);
		f4.setPersonal_info(f6);
		fd.add(f1);
		Gson fw=new Gson();
		c1=fw.toJson(fd);
		fd.remove(f1);
		fd.add(f4);
		c2=fw.toJson(fd);
		Farmservice fk=new Farmservice();
		String ck1=fk.Addaccount(c1);
		String ck2=fk.Addaccount(c2);
		System.out.println(ck1);
		System.out.println(ck2);
		Farmerlist pk=new Farmerlist();
		
		
		
		
		fina=pk.getlist();
		System.out.println(pk);
		
		
		Gson f = new GsonBuilder().setPrettyPrinting().create();
		String out=f.toJson(mh);
		System.out.println(out);
		for(managerreport n:mh)
		{
			System.out.println(n.toString());
		}
		
		
		
		
		
		
		
				
	}
	
}
