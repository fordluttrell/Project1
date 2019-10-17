public class TXTReceiptBuilder implements IReceiptBuilder 

{

    StringBuilder sb = new stringbuilder ();

    @Override
    public void appendheader (string header) 
    
    {
        sb.append (header).append ("\n");
    }

    @Override
    public void appendCustomer (customermodel customer)
     {
        sb.append ("Customer ID:  ").append (customer.mCustomerID).append ("\n");
        
        sb.append ("Customer Name:  ").append (customer.mName).append ("\n");
    }

    @Override
    public void appendProduct (productmodel product)
     {

    }

    @Override
    public void appendpurchase (purchasemodel purchase)
     
     {

    }

    @Override
    public void appendfooter (string footer)
     {
    
    
    }


}