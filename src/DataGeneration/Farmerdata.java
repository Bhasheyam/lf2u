package DataGeneration;

public class Farmerdata {
	String fn;
	String n;
	String fadd;
	String email;
    String ph,fph;
    int [] zip;
    int farmid;
    double charge;
    public Farmerdata()
    {
    	this.farmid=Idgen.fid();
    }
    public double getcharges()
	{
		return charge;
	}
	
public void setname(String name)
{
	this.n=name;
}
public void setfname(String fname)
{
	this.fn=fname;
}
public void setfaddress(String add)
{
	this.fadd=add;
}
public void setfphone(String phn)
{
	this.fph=phn;
}
public void setemail(String em)
{
	this.email=em;
}
public void setphone(String phn)
{
	this.ph=phn;
}

public void zipset(int[] z)
{
this.zip=z;

}

public String getfname()
{
	return this.fn;
}
public String getfmname()
{
	return this.n;
}

public String getemail()
{
	return this.email;
}
public String getphonenumber()
{
	return this.ph;
}
public String getfphonenumber()
{
	return this.fph;
}
public int[]  getfzip()
{
	return zip;
}
public int getfid()
{
	return this.farmid;
}
public void setcharge(double cha)
{
	this.charge=cha;
}

}
