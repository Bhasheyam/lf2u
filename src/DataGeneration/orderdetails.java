package DataGeneration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class orderdetails {
	 int id;
	 int poid;
	 double amount;
	 String date1;
	 String date2;
	 
	public orderdetails()
	{
		this.date1=Idgen.getorderdate();
		this.id=Idgen.oid();
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
	return this.date2;
}

}



