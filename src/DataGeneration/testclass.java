package DataGeneration;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.Iterator;
public class testclass {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		List<Customerdetails> dc = new ArrayList<Customerdetails>();
		List<String> n=new ArrayList<String>();	
Customerdetails c=new Customerdetails();
Customerdetails c1=new Customerdetails();


order d=new order();
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
order j=new order();
String p=j.getorderdate();
System.out.println(p);
dc.add(c);
dc.add(c1);
c.zipset(99999);
Report r=new Report();
String l;
l=r.getreportname(701);
System.out.println(l);
Gson mp = new GsonBuilder().setPrettyPrinting().create();
String hp=mp.toJson(c);
String hp1=mp.toJson(c1);
n.add(hp);
n.add(hp1);
String hpm=mp.toJson(n);
Gson nm=new Gson();
JsonObject g=nm.fromJson(hp,JsonObject.class );
int m=g.get("id").getAsInt();
System.out.println(m+"here it is");
System.out.println(hp);
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
