import javax.swing.*;


public class StoreManager 
{
    
    public static final String DBMS_SQ_LITE = "SQLite";
    
    public static final String DB_FILE = "C:\\User\\fal0002\\Downloads\\COMP\\Auburn\\Class\\COMP3700\\Project1Tung\\data";



    IDataAdapter adapter = null;

    private static StoreManager instance = null;

    public static StoreManager getInstance () 
    {

        if (instance == null) 
        
        {


            if (dbfile.length () == 0) 
            
            {

                JFileChooser fc = new JFileChooser ();

                if (fc.showOpenDialog (null) == JFileChooser.APPROVE_OPTION)

                    dbfile = fc.getSelectedFile ().getAbsolutePath();

            }

            instance = new StoreManager (DBMS_SQ_LITE, dbfile);

        }

        return instance;

    }



    private StoreManager  (String dbms, String dbfile) 
    {

        if (dbms.equals ("Oracle"))

            adapter = new OracleDataAdapter ();

        else

        if (dbms.equals ("SQLite"))

            adapter = new SQLiteDataAdapter  ();




    }



    public IDataAdapter getDataAdapter () 
    {

    }



    public void setDataAdapter (IDataAdapter b) 
    {

        adapter = b;

    }





    public void run () 
    {

        MainUI ui = new MainUI  ();

        ui.view.setVisible (true);

    }



    public static void main (String[] args)
     {

        System.out.println("Hello Welcome to the program!");

        StoreManager.getInstance ().run ();

    }



}



