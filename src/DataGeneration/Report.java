package DataGeneration;

import java.util.Arrays;

public class Report {
	int[] id={701,702,703,704};
	String[] s={"Orders to deliver today", "Orders to deliver tomorrow","Revenue report","Orders delivery report" };
public int getid(int in)
{
	return id[in+1];
}
	public String getreportname(int n) {
		int n1=Arrays.asList(id).indexOf(n);
		return s[n1+1];
	
}
}