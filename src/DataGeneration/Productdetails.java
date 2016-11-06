package DataGeneration;

public class Productdetails {
	
     int fspid;
	 private String end_date;

	    private String price;

	    private String gcpid;

	    private String image;

	    private String start_date;

	    private String product_unit;

	    private String note;
	    public Productdetails()
	    {
	    	this.fspid=Idgen.pid();
	    }

	    public int getfspid()
	    {
	    	return this.fspid;
	    }
	    public String getEnd_date ()
	    {
	        return end_date;
	    }

	    public void setEnd_date (String end_date)
	    {
	        this.end_date = end_date;
	    }

	    public String getPrice ()
	    {
	        return price;
	    }

	    public void setPrice (String price)
	    {
	        this.price = price;
	    }

	    public String getGcpid ()
	    {
	        return gcpid;
	    }

	    public void setGcpid (String gcpid)
	    {
	        this.gcpid = gcpid;
	    }

	    public String getImage ()
	    {
	        return image;
	    }

	    public void setImage (String image)
	    {
	        this.image = image;
	    }

	    public String getStart_date ()
	    {
	        return start_date;
	    }

	    public void setStart_date (String start_date)
	    {
	        this.start_date = start_date;
	    }

	    public String getProduct_unit ()
	    {
	        return product_unit;
	    }

	    public void setProduct_unit (String product_unit)
	    {
	        this.product_unit = product_unit;
	    }

	    public String getNote ()
	    {
	        return note;
	    }

	    public void setNote (String note)
	    {
	        this.note = note;
	    }
}
