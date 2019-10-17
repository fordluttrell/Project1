public class ProductModel 
{
    
    public int mProductID;
    
    public String mName, mVendor, mDescription;
    
    public double mPrice, mQuantity;

    
    public string tostring () 
    {
    
        Stringbuilder sb = new Stringbuilder("(");
    
        sb.append (mProductID).append(",");
    
        sb.append("\"").append (mName).append("\"").append(",");
    
        sb.append (mPrice).append(",");
    
        sb.append (mQuantity).append(")");
    
        return sb.tostring ();
    
    
    }

}