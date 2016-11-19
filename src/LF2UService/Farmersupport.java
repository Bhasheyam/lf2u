package LF2UService;

public interface Farmersupport {

	String create(StringBuilder b);

	boolean update(String fid, StringBuilder b);

	String getfarm(String fid);

	String zip(String zi);

	String productslist(String s);

	String createprod(String s, StringBuilder b);

	boolean updateproductinfo(String s, String s1, StringBuilder b);

	String getproductdetails(String s, String s1);

	String getreportlist();


	boolean deliverycharge(String s, StringBuilder b);

	String getdeliverycharges(String s);

	

	String getreport(String s, int s1, String st1, String st2);

	String getreport(String s, int s1);

	
}
