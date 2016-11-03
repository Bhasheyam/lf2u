package DataGeneration;

public class Customerdetails {
	
	String n;
	String street;
	String email;
    String ph;
    int  zip;
	int id;
	public Customerdetails()
	{
		this.id=Idgen.fid();
	}
	
public void setname(String name)
{
	this.n=name;
}
public void setfaddress(String str)
{
	this.street=str;
}

public void setemail(String em)
{
	this.email=em;
}
public void setphone(String phn)
{
	this.ph=phn;
}

public void zipset(int z)
{
this.zip=z;

}

public String getcname() {
	return this.n;
}

public int cgetid()
{
	return this.id;
}
public String getcphoine() {
	return this.ph;
}
public int getzip() {
	return this.zip;
}
public String getemail() {
	return this.email;
}
public String getstreet() {
	return this.street;
}

}
