package DataGeneration;

public class catalogmange {
	private String name;

    private int gcpid;
    public catalogmange()
    {
    	this.gcpid=Idgen.gcpid();
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public int getGcpid ()
    {
        return gcpid;
    }

   

}
