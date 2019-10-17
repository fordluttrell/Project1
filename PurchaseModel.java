public class PurchaseModel 

{
    
    public int mCustomerID, mPurchaseID, mProductID;
    
    public double mTax, mTotal, mPrice, mQuantity, mCost;
    
    public String mDate;

    
    public String tostring ()
     {
    
        Stringbuilder sb = new Stringbuilder("(");
    
        sb.append (mprice).append(",");
    
        sb.append (mquantity).append(",");
    
        sb.append (mcost).append(",");
    
        sb.append (mtax).append(",");
    
        sb.append (mtotal).append(",");
        
        sb.append (mpurchaseID).append(",");
    
        sb.append (mcustomerID).append(",");
    
        sb.append (mproductID).append(",");
    
        
    
        sb.append("\"").append (mDate).append("\"").append(")");
    
        return sb.toString();
    
    
    }


}