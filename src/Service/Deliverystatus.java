package Service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.order;
import DataGeneration.supportdc;
import LF2UService.Deliversupport;
import dataList.Orderlist;

public class Deliverystatus implements Deliversupport{
	String d;
	List<order> os=new ArrayList<order>();
	supportdc k=new supportdc();
	Orderlist l=new Orderlist();
	public boolean Delivery(String id)
	{ 
		boolean d=false;
		os=l.getorderlist();
	for(order s:os)
	{
		if(id ==s.getOid())
		{
			s.delivered();
			d=true;

		}
	}
//	k.Support("Delivered");
//	List<supportdc> lk=new ArrayList<supportdc>();
//	k.getstatus();
//	lk.add(k);
//	Gson f1 = new GsonBuilder().setPrettyPrinting().create();
//	d=f1.toJson(lk);
	return d;
	}
	
}
	

