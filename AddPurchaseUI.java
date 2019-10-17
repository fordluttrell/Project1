import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;


public class AddPurchaseUI
 {
    
    public JFrame view;

    public JButton btnAdd = new JButton("Add");
    
    public JButton btnCancel = new JButton("Cancel");

    public JTextField txtPurchaseID = new JTextField(10);
    
    public JTextField txtCustomerID = new JTextField(10);
    
    public JTextField txtProductID = new JTextField(10);
    
    public JTextField txtQuantity = new JTextField(10);

    
    public JLabel CustomerName = new JLabel("Customer Name: ");
    
    public JLabel ProductName = new JLabel("Product Name: ");
    
    
    
    public JLabel Price = new JLabel("Product Price: ");
    
    public JLabel Date = new JLabel("Date of Purchase: ")

    
    
    public JLabel Cost = new JLabel("Cost: $0.00 ");
    
    public JLabel Tax = new JLabel("Tax: $0.00");
    
    public JLabel TotalCost = new JLabel("Total Cost: $0.00");



    ProductModel product;
    PurchaseModel purchase;
    CustomerModel customer;



    public AddPurchaseUI() 
    {


        this.view = new JFrame();



        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        view.setTitle("Add Purchase");

        view.setSize(700, 500);

        view.getContentPane().setLayout(new BoxLayout( view.getContentPane(),  BoxLayout.PAGE_AXIS));



        JPanel line = new JPanel (new FlowLayout());

        line.add(new JLabel("PurchaseID  "));

        line.add(txtPurchaseID);

        line.add(Date);

        view.getContentPane().add(line);



        line = new JPanel(new FlowLayout ());

        line.add(new JLabel("CustomerID  "));

        line.add(txtCustomerID);

        line.add(CustomerName);

        view.getContentPane().add(line);



        line = new JPanel(new FlowLayout ());

        line.add(new JLabel("ProductID  "));

        line.add(txtProductID);

        line.add(ProductName);

        view.getContentPane ().add(line);



        line = new JPanel(new FlowLayout());

        line.add(new JLabel("Quantity  "));

        line.add(txtQuantity);

        line.add(Price);

        view.getContentPane ().add(line);



        line = new JPanel(new FlowLayout());

        line.add(Cost);

        line.add(Tax);

        line.add(TotalCost);

        view.getContentPane ().add(line);




        line = new JPanel(new FlowLayout());

        line.add(btnAdd);

        line.add(btnCancel);

        view.getContentPane ().add(line);




        txtProductID.addFocusListener(new ProductIDFocusListener ());

        txtCustomerID.addFocusListener(new CustomerIDFocusListener ());

        txtQuantity.getDocument ().addDocumentListener(new QuantityChangeListener ());



        btnAdd.addActionListener(new AddButtonListerner ());

    }



    public void run () 
    {

        purchase = new PurchaseModel ();

        purchase.mDate = Calendar.getInstance ().getTime ().toString ();

        labDate.setText("Date of purchase: " + purchase.mDate);


    }



    private class ProductIDFocusListener implements FocusListener {

        @Override

        public void focusGained (FocusEvent focusEvent) {



        }



        @Override

        public void focusLost (FocusEvent focusEvent) 
        {

            process ();

        }



        private void process () 
        {

            String q = txtProductID.getText ();



            if (q.length () == 0) 
            {

                labProductName.setText("Product Name: [not specified]");

                return;

            }



            System.out.println("ProductID = " + q);



            try 
            {

                purchase.mProductID = Integer.parseInt(q);



            } catch (NumberFormatException ex)
             {

                JOptionPane.showMessageDialog(null,

                        "Error: Invalid ProductID", "Error",


                return;

            }



            product = StoreManager.getInstance ().getDataAdapter ().loadProduct (purchase.mProductID);



            if (product == null) 
            {

                JOptionPane.showMessageDialog(null,

                        "Warning: No product with id = " + purchase.mProductID + " in store!", "Error ",

                        labProductName.setText("Product Name:  ");



                return;

            }



            ProductName.setText ("Product Name: " + product.mName);

            purchase.mPrice = product.mPrice;

            Price.setText ("Product Price: " + product.mPrice);



        }



    }



    private class CustomerIDFocusListener implements FocusListener 
    {
        @Override
        public void focusGained(FocusEvent focusEvent) {



        }

        @Override
        public void focusLost(FocusEvent focusEvent) {

            process ();

        }



        private void process  () {

            String q = txtCustomerID.getText();



            if (q.length () == 0) 
            {

                labCustomerName.setText("Customer Name: (not specified)");

                return;

            }



            System.out.println("CustomerID = " + q);



            try 
            {


                purchase.mCustomerID = Integer.parseInt(q);



            } catch (NumberFormatException ex) 
            {


                JOptionPane.showMessageDialog(null,

                        "Warning: Invalid CustomerID", "Error Message",

                        

                return;

            }



            customer = StoreManager.getInstance ().getDataAdapter ().loadCustomer (purchase.mCustomerID);



            if (customer == null) 
            {

                JOptionPane.showMessageDialog(null,

                        "Warning: No customer with id = " + purchase.mCustomerID + " in store", "Error Message ",

                        JOptionPane.ERROR_MESSAGE);

                CustomerName.setText ("Customer Name:  ");



                return;

            }



            CustomerName.setText("Product Name:  " + customer.mName);



        }



    }



    private class QuantityChangeListener 
     {

        public void changedUpdate (documentevent y) 
        {

            process ();

        }



        public void removeUpdate (documentevent y) {

            process ();

        }



        public void insertUpdate (documentevent y) 
        {

            process ();

        }



        private void process () 
        {

            String q = txtQuantity.getText ();



            if (q.length  () == 0) 
            {

            

                return;

            }



            System.out.println("Quantity =  " + q);



            try {

                purchase.mQuantity = Double.parseDouble(q);



            } catch (NumberFormatException ex) 
            {


                JOptionPane.showMessageDialog(null,

                        "Warning: Please enter an invalid quantity", "Error Message",

                        JOptionPane.ERROR_MESSAGE);

                return;

            }



            if (purchase.mQuantity <= 0) 
            {

                JOptionPane.showMessageDialog(null,

                        "Warning: Please enter an invalid quantity", "Error Message",

                        JOptionPane.ERROR_MESSAGE);

                return;

            }



            if (purchase.mQuantity   >  product.mQuantity)
             {

                JOptionPane.showMessageDialog(null,

                        "Not enough available products.", "Info",

                        JOptionPane.INFORMATION_MESSAGE);

            }



            purchase.mCost =  purchase.mQuantity  *  product.mPrice;

            purchase.mTax =  purchase.mCost  *  5.0;

            purchase.mTotal =  purchase.mCost  +  purchase.mTax;



            labCost.setText("Cost: $ " + String.format("%7.2f ", purchase.mCost).trim ());

            labTax.setText("Tax: $ " + String.format("%7.2f ", purchase.mTax).trim ());

            labTotalCost.setText("Total: $ " + String.format("%7.2f ", purchase.mTotal).trim ());



        }

    }



    class AddButtonListerner implements ActionListener 
    {



        @Override

        public void actionPerformed(ActionEvent actionEvent) 
        {



            String id = txtPurchaseID.getText ();



            if (id.length() == 0)
             {

                JOptionPane.showMessageDialog(null, "PurchaseID cannot be null");

                return;

            }



            try 
            {

                

            } catch (NumberFormatException e) 
            {

                JOptionPane.showMessageDialog(null, "PurchaseID is invalid");

                return;

            }





            switch (StoreManager.getInstance ().getDataAdapter ().savePurchase (purchase)) 
            {

                case SQLiteDataAdapter.PURCHASE_DUPLICATE_ERROR:

                    JOptionPane.showMessageDialog(null, "Purchase not added successfully. Duplicate product ID please. ");

               

                    JOptionPane.showMessageDialog(null, "Purchase added successfully." + purchase);

            }

        }

    }




}