package DataGeneration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class orderdetails {
	 int id;
	 int poid;
	 double amount;
	 
	public orderdetails()
	{
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
	DateFormat df = new SimpleDateFormat("yyyyMMdd ");
	Date dateobj = new Date();
	return df.format(dateobj);
}
public String getplannedorderdate()
{
	DateFormat df = new SimpleDateFormat("yyyyMMdd ");
	Date dateobj = new Date();
	
	return "";
}

	
}



