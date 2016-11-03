package DataGeneration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class orderdetails {
	 int id;
	 int poid;
	 double amount;
	 String date1;
	 String date2;
	 String[] or={"open","cancelled", "delivered"};
	 String ors;
	 
	public orderdetails()
	{
		this.ors=this.or[0];
		this.date1=Idgen.getorderdate();
		this.date2=Idgen.getdeliveryday();
		this.id=Idgen.oid();
	}
	public void setors(int n)
	{
		ors=or[n];
	}
	public void setpoid(int ind)
	{
		this.poid=ind;
	}
public void setamount(double mon)
{
	this.amount=mon;
}
public int getpoid()
{
	return this.poid;
}
public double getamount()
{
	return this.amount;
}

public String getorderdate()
{
	return this.date1;
}

public String getdeliverydate() 
{

	return date2 ;
}

public String getors()
{
	return this.ors;
}
public void deliveried()
{
	ors=or[2];
}
public boolean cancelo()
{
	DateFormat df = new SimpleDateFormat("yyyyMMdd ");
	Date dateobj = new Date();
	String ch= df.format(dateobj);
	if(ch==date2)
	{
		return false;
	}
	ors=or[1];
	
	return true;

}


}



