
package DBO;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author moham
 */
public class DBOperations {
    public static void setDataOrDelete(String Query, String msg){
        try{
           Connection con= DBConnection.getCon();
           Statement st = con.createStatement();
           st.executeUpdate(Query);
           if(!msg.equals(""))
               JOptionPane.showMessageDialog(null, msg);
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e, "Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public static ResultSet getData(String query){
        try{
            Connection con = DBConnection.getCon();
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Message",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}
