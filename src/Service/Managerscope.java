package Service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.Manageraccount;
import DataGeneration.managerreport;
import LF2UService.Managersupport;
import dataList.managerreportlis;

public class Managerscope implements Managersupport {
	
	
	public String getreplist()
	{
		List<managerreport> mh=new <managerreport>ArrayList();
		managerreportlis m=new managerreportlis();
		m.setreplist();
		mh=m.getrepmana();
		Gson f = new GsonBuilder().setPrettyPrinting().create();
		String out=f.toJson(mh);
		return out;
		
	}

	@Override
	public String getmlist() {
	String out;
	List<Manageraccount> man=new ArrayList<Manageraccount>();
	managerreportlis m=new managerreportlis();
	m.setaccount();
	man=m.getaccount();
	Gson f = new GsonBuilder().setPrettyPrinting().create();
	 out=f.toJson(man);
	return out;
	}

	@Override
	public String getmanager(int mid) {
		String out;
		List<Manageraccount> man=new ArrayList<Manageraccount>();
		List<Manageraccount> man1=new ArrayList<Manageraccount>();
		managerreportlis m=new managerreportlis();
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

	@Override
	public String getreportt1(String s, String s1) {
		String out=0;
		return out;
	}
	@Override
	public String getreportt2(String s, String s1, String st, String ft) {
		
		return null;
	}

	@Override
	public String getreportt3(String s, String s1, String st, String ft) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
