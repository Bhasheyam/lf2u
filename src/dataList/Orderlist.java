package dataList;

import java.util.ArrayList;
import java.util.List;

import DataGeneration.order;

public class Orderlist {
	List<order> mastero=new ArrayList<order>();
	
	
	public void addlist(order o)
	{
		mastero.add(o);
	}
	public List<order> getorderlist()
	{
		return this.mastero;
	}
	

}
