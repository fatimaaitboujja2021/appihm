import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {


    public static  Connection conDB(){
        Connection conn = null ;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/keeptoo_systems", "root", "");

          //  JOptionPane.showMessageDialog(null,"Done");

        } catch (Exception ex) {
            System.err.println("ConnectionUtil:"+ex.getMessage());
            JOptionPane.showMessageDialog(null,"NotDone");

        }
        return conn;
    }

}
