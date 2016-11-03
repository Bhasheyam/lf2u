package DataGeneration;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class testclass {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		List<Customerdetails> dc = new ArrayList<Customerdetails>();
Customerdetails c=new Customerdetails();
Customerdetails c1=new Customerdetails();


orderdetails d=new orderdetails();
String s1,s2;
s1=d.getorderdate();
s2=d.getdeliverydate();
System.out.println(s1);
System.out.println(s2);
c.setfaddress("southstreet");
c.setphone("9003203629");
c.setemail("bhash@gmail.com");
c.zipset(12345);
c1.setname("boss1");
c1.setfaddress("southstreet23");
c1.setphone("9003290629");
c1.setemail("bhashjwh@gmail.com");
c1.zipset(12395);
orderdetails j=new orderdetails();
String p=j.getorderdate();
System.out.println(p);
dc.add(c);
dc.add(c1);
c.zipset(99999);
Report r=new Report();
String l;
l=r.getreportname(701);
System.out.println(l);
for(Customerdetails f:dc)
{ 
	
	System.out.println(f.getcname());
	System.out.println(f.getzip());
	System.out.println(f.cgetid());
	
	
}

//@SuppressWarnings("unchecked")
//Iterator<Customerdetails> l1 = ((List<Customerdetails>) c1).iterator();
//while(l1.hasNext())
//{
//	System.out.println(l1.next());
//}

int i=c.cgetid();
int i2=c1.cgetid();
String s=c.getcname();


System.out.println(s + i + i2);
	}

}
