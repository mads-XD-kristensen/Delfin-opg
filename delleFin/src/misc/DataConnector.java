package misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataConnector {

    // Opretter forbindelsen til server
    public static Connection getConnection() {
        String url = "jdbc:mysql://root@localhost:3306/delfin?serverTimezone=UTC";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, "root", "Soldath123");
        } catch (SQLException ex) {
            Logger.getLogger(DataConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

}
