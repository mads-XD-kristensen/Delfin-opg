
package dellefin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataConnector {

    public static Connection getConnection(){
        String url = "jdbc:mysql://root@localhost:3306/delfin?serverTimezone=UTC";
        //establish connection object
        
        Connection conn = null;
       
        try {
            conn = DriverManager.getConnection(url, "root", "euy27brq");
        } catch (SQLException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }

}
