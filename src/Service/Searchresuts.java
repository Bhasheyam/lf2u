package Service;

import LF2UService.searchsupport;

public class Searchresuts implements searchsupport {
	
	String Result;

	public void Searchf(String key)
	{
		
		
	}
	public void Searchc(String key)
	{
		
	}
	public void Searcho(String key)
	{
		
	}
	@Override
	public String search(String s, String s2) {
		if(s=="farm")
		{
			Searchf(s2);
		}
		else if (s=="customer")
		{
			Searchc(s2);
		}
		else if(s=="order")
		{
			Searcho(s2);
		}
		else
		{
			Result="wrong";
		}
		return Result;
	}

}
