package Service;
import DataGeneration.*;

public class testsupport {
public static void main(String[] sl){
	Customerser s=new Customerser();
	deliverystatus d=new deliverystatus();
	Farmservice f=new Farmservice();
	Managerscope m=new Managerscope();
	Searchresuts sr=new Searchresuts();
	
	
	Farmerdata fr=new Farmerdata();
	Farm_info fi=new Farm_info();
	Personal_info pl=new Personal_info();
	
	Customerdetails c=new Customerdetails();
	
	catalogmange ca=new catalogmange();
	Productdetails pr= new Productdetails();
	
	place_order p=new place_order();
	Order_detail o=new Order_detail();
	Order_detail[] oa=new Order_detail[5];
	
	
	String[] fp={"60010", "60011"};
	fi.setName("boss");
	fi.setPhone("8089842432");
	fi.setWeb("bhasheyam@gmail.com");
	fi.setAddress("napervile");
	pl.setName("bhasheyam");
	pl.setPhone("873982738");
	pl.setEmail("bhasheyam@gmai.com");
	fr.setDelivers_to(fp);
	fr.setFarm_info(fi);
	fr.setPersonal_info(pl);
	c.setName("sriram");
	c.setPhone("9003203629");
	c.setStreet("woodie drive");
	c.setEmail("sriram@gmail.com");
	c.setZip("60010");
	p.setDelivery_note("successu");
	p.setFid("1");
	o.setamount(2);
	o.setFspid("1");
	oa[0]=o;
	p.setOrder_detail(oa);
	pr.setStart_date("20161110");
	pr.setEnd_date("");
	pr.setNote("sucess");
	pr.setPrice(0.10d);
	pr.setGcpid("1");
	pr.setImage("");
	pr.setProduct_unit("lb");
	ca.setName("potato");
	

}
}