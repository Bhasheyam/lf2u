package DataGeneration;

public class customerorder {
	private String fid;

    private String status;

    private String actual_delivery_date;

    private String oid;

    private String planned_delivery_date;

    private String order_date;

    public String getFid ()
    {
        return fid;
    }

    public void setFid (String fid)
    {
        this.fid = fid;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getActual_delivery_date ()
    {
        return actual_delivery_date;
    }

    public void setActual_delivery_date (String actual_delivery_date)
    {
        this.actual_delivery_date = actual_delivery_date;
    }

    public String getOid ()
    {
        return oid;
    }

    public void setOid (String oid)
    {
        this.oid = oid;
    }

    public String getPlanned_delivery_date ()
    {
        return planned_delivery_date;
    }

    public void setPlanned_delivery_date (String planned_delivery_date)
    {
        this.planned_delivery_date = planned_delivery_date;
    }

    public String getOrder_date ()
    {
        return order_date;
    }

    public void setOrder_date (String order_date)
    {
        this.order_date = order_date;
    }


}
