package DataGeneration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Idgen {
	static int counter =0;
	static int counterc=0;
	static int countero=0;
	static int counterp=0;
	
	public static int fid()
	{
		counter++;
		return counter;
	}
	public static int cid()
	{
		counterc++;
		return counterc;
	}
	public static int oid()
	{
		countero++;
		return countero;
	}
	public static int pid()
	{
		counterp++;
		return counterp;
	}
	public static String getorderdate()
	{
		DateFormat df = new SimpleDateFormat("yyyyMMdd ");
		Date dateobj = new Date();
		return df.format(dateobj);
	}
}
