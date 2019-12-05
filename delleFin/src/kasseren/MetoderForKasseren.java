package kasseren;

import misc.DataConnector;
import dellefin.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// Metoder som kasseren gerne ville have
public class MetoderForKasseren {

    public void setBetalStatus() {
        System.out.println("Skriv medlemmets ID"); // betalingstatus
        Scanner in = new Scanner(System.in);
        String ID = "";
        ID = in.nextLine();

        PreparedStatement statement = null;
        try {

            Connection conn = DataConnector.getConnection();

            System.out.println("Skriv \"1\" For at sætte medlemmets betalingstatus til betalt "
                    + "og \"0\", hvis medlemmet skal sættes i restance.");

            int s = 0;

            s = in.nextInt();

            if (s == 1) {

                String sql = "update delfin.medlem set betalStatus = 1 where ID = ?;";

                statement = conn.prepareStatement(sql);

                statement.setInt(1, Integer.parseInt(ID));

                statement.execute();
                System.out.println("Medlem: " + ID + " er registreret som betalt");
            }
            if (s == 0) {

                String sql = "update delfin.medlem set betalStatus = 0 where ID = ?;";

                statement = conn.prepareStatement(sql);

                statement.setInt(1, Integer.parseInt(ID));

                statement.execute();
                System.out.println("Medlem: " + ID + " er registreret som værende i restance");
            }
        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void seRestanceOversigt() {

        try {
            Connection conn = DataConnector.getConnection();

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM delfin.medlem where betalStatus = 0");

            while (resultSet.next()) {

                int årstal = Year.now().getValue();
                double pris = 1600;
                int alder = resultSet.getInt("alder");
                boolean passivAktivStatus = resultSet.getBoolean("passivAktiv");

                if (årstal - alder < 18) {
                    pris = 1000;

                } else if (årstal - alder > 60) {
                    pris = pris * 0.75;

                }
                if (!passivAktivStatus == true) {
                    pris = 500;

                }
                System.out.println("Medlemmets ID: " + resultSet.getInt("ID") + "\n"
                        + "Stam oplysninger: " + resultSet.getString("stamOpl") + "\n"
                        + "Årgang: " + resultSet.getInt("alder") + "\n" + "True hvis aktiv, false hvis passiv: "
                        + resultSet.getBoolean("passivAktiv") + "\n" + "Mangler at betale: " + pris + "kr." + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
