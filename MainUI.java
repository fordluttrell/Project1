import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;



public class MainUI 
{
    public JFrame view;

    
    public JButton btnAddproduct = new JButton ("Add New Product ");
    
    public JButton btnAddcustomer = new JButton ("Add New Customer ");
    
    public JButton btnAddpurchase = new JButton ("Add New Purchase ");

    
    public MainUI () 
    
    {
    
        this.view = new JFrame ();

    
        view.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    
        view.setTitle("Store Management System");
    
        view.setSize(900, 500);
    
        view.getContentPane ().setLayout (new BoxLayout (view.getContentPane (), BoxLayout.PAGE_AXIS));

    
        JLabel title = new JLabel("Store Management System");

    
        title.setFont (title.getFont ().deriveFont (25.0f));
    
        view.getContentPane ().add (title);

    
        JPanel panelButtons = new JPanel (new FlowLayout ());
    
        panelButtons.add (btnAddProduct);
    
        panelButtons.add (btnAddCustomer);
    
        panelButtons.add (btnAddPurchase);
    
        view.getContentPane ().add (panelButtons);
         
        {

           
            @Override
            public void actionPerformed (Actionevent actionevent) 
            {
           
                AddproductUI ac = new AddproductUI ();
           
                ac.run ();
           
            }
        };

       
        btnAddpurchase.addActionlistener(new Actionlistener () 
        {

            @Override
            public void actionPerformed(Actionevent actionevent) 
            {
               
                AddpurchaseUI ap = new AddpurchaseUI ();
               
               
            }
       
        

   
    }


}