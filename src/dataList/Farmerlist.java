package dataList;
import java.util.ArrayList;
import java.util.List;

import DataGeneration.*;

public class Farmerlist {
	
public static ArrayList<Farmerdata>  farmer=new ArrayList();
	public Farmerlist()
	{
		
	}

public List<Farmerdata> getlist()
{
	return this.farmer;
}


public void add(Farmerdata k)
{
	farmer.add(k);
}

}
