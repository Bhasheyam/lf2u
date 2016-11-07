package DataGeneration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class order {
	 private String order_total;

	    private Order_details order_detail;

	    private String delivery_charge;

	    private String products_total;

	    private Ordered_by Ordered_by;

	    private String actual_delivery_date;

	    private String status;

	    private String delivery_address;

	    private String oid;

	    private String planned_delivery_date;

	    private String order_date;

	    private String note;
	    private String[] ordstatus={"open","Deliveried", "cancelled"};
	    
	    public order()
	    {
	    	this.oid=Idgen.oid();
	    	this.status=ordstatus[0];
	    }

	    public String getOrder_total ()
	    {
	        return order_total;
	    }

	    public void setOrder_total (String order_total)
	    {
	        this.order_total = order_total;
	    }

	    public Order_details getOrder_detail ()
	    {
	        return order_detail;
	    }

	    public void setOrder_detail (Order_details order_detail)
	    {
	        this.order_detail = order_detail;
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

	    public Ordered_by getOrdered_by ()
	    {
	        return Ordered_by;
	    }

	    public void setOrdered_by (Ordered_by ordered_by)
	    {
	        this.Ordered_by = ordered_by;
	    }

	    public String getActual_delivery_date ()
	    {
	        return actual_delivery_date;
	    }

	    public void setActual_delivery_date (String actual_delivery_date)
	    {
	        this.actual_delivery_date = actual_delivery_date;
	    }

	    public String getStatus ()
	    {
	        return status;
	    }

	    public void setStatus (String status)
	    {
	        this.status = status;
	    }

	    public String getDelivery_address ()
	    {
	        return delivery_address;
	    }

	    public void setDelivery_address (String delivery_address)
	    {
	        this.delivery_address = delivery_address;
	    }

	    public String getOid ()
	    {
	        return oid;
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

	    public String getNote ()
	    {
	        return note;
	    }

	    public void setNote (String note)
	    {
	        this.note = note;
	    }

//delivery status change
	    public boolean delivered()
	    {
	    	status=ordstatus[1];
	    return true;
	    }
	    
	    //cancellation of order
	    public boolean cancel()
	    {
	    	status=ordstatus[2];
	    	return true;
	    }

}


