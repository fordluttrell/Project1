public interface IReceiptBuilder 
{
    
    
    public void appendheader (string header);
    
    public void appendcustomer (customermodel customer);
    
    public void appendproduct (productmodel product);
    
    public void appendpurchase (purchasemodel purchase);
    
    public void appendfooter (string footer);



    public string tostring ();

}