package dataList;
import java.util.ArrayList;
import java.util.List;

import DataGeneration.*;

public class managerreportlis {
	
	private int[] mrid={1,2,3,4,5};
    private String[] name={ "Orders placed today","Orders placed yesterday","Revenue for previous month","Revenue yesterday","Revenue yesterday by zip code"};
    managerreport mr =new managerreport();
    managerreport mr1 =new managerreport();
    managerreport mr2 =new managerreport();
    managerreport mr3 =new managerreport();
    managerreport mr4 =new managerreport();
    List<managerreport> m=new ArrayList<managerreport>();
    public managerreportlis()
    {
    	
    }
    public void setreplist()
    {
    	
    	mr.setMrid(mrid[0]);
    	mr.setName(name[0]);
    	mr1.setMrid(mrid[1]);
    	mr1.setName(name[1]);
    	mr2.setMrid(mrid[2]);
    	mr2.setName(name[2]);
    	mr3.setMrid(mrid[3]);
    	mr3.setName(name[3]);
    	mr4.setMrid(mrid[4]);
    	mr4.setName(name[4]);
    	m.add(mr);
    	m.add(mr1);
    	m.add(mr2);
    	m.add(mr3);
    	m.add(mr4);
    }
    public List<managerreport> getrepmana()
    
    {
    return this.m;	
    }
    
}
