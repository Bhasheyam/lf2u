package DataGeneration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Idgen {
	static int counter =0;
	static int counterc=0;
	static int countero=0;
	static int counterp=0;
	static int countercp=0;
	
	public static String gcpid()
	{
		countercp++;
		
		return countercp+"";
	}
	public static String fid()
	{
		counter++;
		return counter+"";
	}
	public static String cid()
	{
		counterc++;
		return counterc+"";
	}
	public static String oid()
	{
		countero++;
		return countero+"";
	}
	public static String pid()
	{
		counterp++;
		return counterp+"";
	}
	public static String getorderdate()
	{
		DateFormat df = new SimpleDateFormat("yyyyMMdd ");
		Date dateobj = new Date();
		return df.format(dateobj);
	}
	
	public static String getdeliveryday()
	{
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd ");
		Date dateobj = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dateobj);
	    cal.add(Calendar.DATE, 1); 
	    dateobj=cal.getTime();
		return df.format(dateobj);
	}
	
}
