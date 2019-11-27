
package dellefin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataConnector {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://root@localhost:3306/delfin?serverTimezone=UTC";
        //establish connection object
        
        Connection conn = null;
       
            conn = DriverManager.getConnection(url, "root", "ugz28shd");
        
        return conn;
    }

}
