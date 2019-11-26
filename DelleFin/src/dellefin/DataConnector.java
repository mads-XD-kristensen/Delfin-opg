
package dellefin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnector {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://root@localhost:3306/delfin";
        //establish connection object
        Connection conn = DriverManager.getConnection(url, "root", "uqt42vqx");

        return conn;
    }

}
