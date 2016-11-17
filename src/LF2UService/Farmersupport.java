package LF2UService;

public interface Farmersupport {

	String create(StringBuilder b);

	boolean update(String fid, StringBuilder b);

	String getfarm(String fid);

	String zip(String zi);

	String productslist(String s);

	String createprod(String s, StringBuilder b);

	
}
