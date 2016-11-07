package Service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.managerreport;
import dataList.managerreportlis;

public class Managerscope {
	
	
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

}
