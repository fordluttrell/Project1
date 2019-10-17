public class OracleDataAdapter  
{
    public int connect (String dbfile)
     {
        
        return CONNECTION_OPEN_OK;
    
    }

    public int disconnect () 
    {
        
        return CONNECTION_CLOSE_OK;

    }
    
    public Customermodel loadCustomer (int id) 
    {
    
        return null;
    
    }

    public ProductModel loadProduct (int ID) 
    {
        return null;
    
    }
    public int saveProduct (Productmodel model) 
    {
       
        return PRODUCT_SAVED_OK;
    
    }

    @Override
    public int savePurchase (Purchasemodel model) 
    {
        
        return 0;
   
    }


}