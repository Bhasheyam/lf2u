package dataList;

public class Delivery {
	private String fid;
	private double charges;
	public void setcharge(double d)
	{
		this.charges=d;
	}
public void setfid(String s)
{
	this.fid=s;
}
public double getcharges()
{
	return this.charges;
}
public String getid()
{
	return this.fid;
}
}
