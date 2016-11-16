package DataGeneration;
public class catalogmange {
	private String name;

    private String id;
    public catalogmange()
    {
    	this.id=Idgen.gcpid();
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getGcpid ()
    {
        return this.id;
    }

   

}
