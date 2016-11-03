package DataGeneration;

public class Productdetails {
	

	
	double price;
	String produnit,cgid;
	int fpid;
	
	public Productdetails()
	{
		this.fpid=Idgen.pid();
	}
	
	public void setprice(double price)
	{
		this.price=price;
	}
	public void setprodunit(String produnit)
	{
		this.produnit=produnit;
	}
	public void setcgid(String cgid)
	{
		this.cgid=cgid;
	}
	
	public String getprodunit()
	{
		return produnit;
	}
	public String getunit()
	{
		return cgid;
	}
	public double getprodprice()
	{
		return price;
		
	}
}
