import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

import java.sql.SQLException;
import java.sql.DriverManager;


public class SQLiteDataAdapter implements IDataAdapter 
{

    Connection conn = null;

    public int connect(String dbfile) 
    {
        try {
            
            // parameter
            String url = "sqlite:" + dbfile;
            
            // database for connection
            conn = DriverManager.getConnection(url);

            System.out.println("SQLite has been established.");

        
        } catch (SQLException e) 
        
        {
        
            System.out.println(e.getMessage ());
        
            return CONNECTION_OPEN_FAILED;
        
        
        }
        
        return CONNECTION_OPEN_OK;
    
    }

    
    @Override
    
    public int disconnect () 
    
    {
        try 
        {
            conn.close ();
       
        } catch (SQLException e) 
       
        {
       
            System.out.println(e.getMessage ());
       
            return CONNECTION_CLOSE_FAILED;
       
        }
       
        return CONNECTION_CLOSE_OK;
    }

    public ProductModel loadProduct (int productID)
     
     {
        ProductModel product = null;

        try 
        {
           
            String sql = "SELECT ProductId, Name, Price, Quantity FROM Products WHERE ProductId = " + productID;
           
            Statement stmt = conn.createStatement();
           
            ResultSet rs = stmt.executeQuery (sql);
           
            if (rs.next ()) 
           
            {
               
                product = new ProductModel ();
               
                product.mProductID = rs.getInt ("ProductId");
               
                product.mName = rs.getString ("Name");
               
                product.mPrice = rs.getDouble ("Price");
               
                product.mQuantity = rs.getDouble ("Quantity");
            }

        
        } catch (SQLException e) 
        
        {
        
            System.out.println(e.getMessage ());
        
        }
        
        return product;
   
    }
   
    public int saveProduct(ProductModel product)
   
     {
   
        try 
        {
            
            String sql = "INSERT INTO Products(ProductId, Name, Price, Quantity) VALUES " + product;
            
            System.out.println (sql);
            
            Statement stmt = conn.createStatement ();
            

        } catch (Exception e) 
        {
            
            String msg = e.getMessage ();
            
            System.out.println (msg);
            
            if (msg.contains("UNIQUE constraint failed"))
            
        }

       
        return PRODUCT_SAVED_OK;
    }

    @Override
    public int savePurchase (PurchaseModel purchase) 
    
    {
        try 
        {
            
            String sql = "INSERT INTO Purchases VALUES " + purchase;
            
            System.out.println (sql);
            
            Statement stmt = conn.createStatement ();
            


        } catch (Exception e) 
        {
           
            String msg = e.getMessage ();
           
            System.out.println (msg);
           
            if (msg.contains("Unique constraint failed"))
           
        }

        
        return PURCHASE_SAVED_OK;

    }

    public CustomerModel loadCustomer (int id) 
    {
        CustomerModel customer = null;

        try {
            
            String sql = "SELECT * From Customers Where CustomerId = " + id;
            
            Statement stmt = conn.createStatement ();
            
            ResultSet rs = stmt.executeQuery (sql);

            
            {
               
               
                customer = new CustomerModel ();
                customer.mCustomerID = id;
                customer.mName = rs.getString("Name");
            
            
            }

        
        {
          
            System.out.println(e.getMessage ());
        }
        
        return customer;
    
    
    }

}