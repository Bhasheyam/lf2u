package Service;

import java.util.ArrayList;
import java.util.List;

import DataGeneration.corders;
import LF2UService.Deliversupport;
import dataList.orderget;

public class deliverystatus implements Deliversupport {
	public static List<corders> temp1=new ArrayList<corders>();
	public static List<orderget> temp2=new ArrayList<orderget>();
	@Override
	public String Delivery(String id) {
		String a="no";
		
		temp1=Customerser.getcorder();
		temp2=Customerser.getorderget();
		String s1,s2,s3;
		for(corders s:temp1)
		{ s1=s.getOid();
		if(s1.equals(id))
		{
			s3=s.getStatus();
			if(s3.equals("open"))
			{	
			s.setStatus("Delivered");
			for(orderget f:temp2)
			{
				s2=f.getoid();
						if(s2.equals(id))
						{
							f.setorders(s);
							a="done"
;						}
			}
			}
			else 
			{
				return "can";
			}
			}
		}
		Customerser.setcorder(temp1);
		Customerser.setorderget(temp2);
		return a;
	}

}