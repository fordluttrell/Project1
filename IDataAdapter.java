  public interface IDataAdapter 
  
  {

    
    public static final int CONNECTION_OPEN_OK = 200;
    
    public static final int CONNECTION_OPEN_FAILED = 201;




    public static final int CONNECTION_CLOSE_OK = 300;

    public static final int CONNECTION_CLOSE_FAILED = 301;




    public static final int PRODUCT_SAVED_OK = 0;

    public static final int PRODUCT_DUPLICATE_ERROR = 1;




    public static final int PURCHASE_SAVED_OK = 400;

    public static final int PURCHASE_DUPLICATE_ERROR = 401;




    public int connect (String dbfile);

    public int disconnect ();




    public ProductModel loadProduct (int id);

    public int saveProduct (ProductModel model);




    public CustomerModel loadCustomer (int id);
    public int savePurchase (PurchaseModel model);
}