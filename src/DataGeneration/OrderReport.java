package DataGeneration;

public class OrderReport {
	private String order_total;

    private String delivery_charge;

    private String products_total;

    private Order_details[] order_detail;

    private String delivery_note;

    private String status;

    private String actual_delivery_date;

    private String oid;

    private String planned_delivery_date;

    private Farm_info farm_info;

    private String order_date;

    public String getOrder_total ()
    {
        return order_total;
    }

    public void setOrder_total (String order_total)
    {
        this.order_total = order_total;
    }

    public String getDelivery_charge ()
    {
        return delivery_charge;
    }

    public void setDelivery_charge (String delivery_charge)
    {
        this.delivery_charge = delivery_charge;
    }

    public String getProducts_total ()
    {
        return products_total;
    }

    public void setProducts_total (String products_total)
    {
        this.products_total = products_total;
    }

    public Order_details[] getOrder_detail ()
    {
        return order_detail;
    }

    public void setOrder_detail (Order_details[] order_detail)
    {
        this.order_detail = order_detail;
    }

    public String getDelivery_note ()
    {
        return delivery_note;
    }

    public void setDelivery_note (String delivery_note)
    {
        this.delivery_note = delivery_note;
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

    public Farm_info getFarm_info ()
    {
        return farm_info;
    }

    public void setFarm_info (Farm_info farm_info)
    {
        this.farm_info = farm_info;
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
