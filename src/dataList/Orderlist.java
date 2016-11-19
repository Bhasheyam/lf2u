package dataList;

import java.util.ArrayList;
import java.util.List;

import DataGeneration.orders;

public class Orderlist {
	List<orders> mastero=new ArrayList<orders>();
	
	
	public void addlist(orders o)
	{
		mastero.add(o);
	}
	public List<orders> getorderlist()
	{
		return this.mastero;
	}
	

}
