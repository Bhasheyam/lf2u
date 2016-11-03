package DataGeneration;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class testclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Customerdetails> dc = new ArrayList<Customerdetails>();
Customerdetails c=new Customerdetails();
Customerdetails c1=new Customerdetails();

c.setname("boss");
c.setfaddress("southstreet");
c.setphone("9003203629");
c.setemail("bhash@gmail.com");
c.zipset(12345);
c1.setname("boss1");
c1.setfaddress("southstreet23");
c1.setphone("9003290629");
c1.setemail("bhashjwh@gmail.com");
c1.zipset(12395);
//hey work
dc.add(c);
dc.add(c1);
for(Customerdetails f:dc)
{ int s;
s=f.getzip();
	if(s==12345){
	System.out.println(f.getcname());
	System.out.println(f.getzip());
	System.out.println(f.cgetid());
	}
	
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
