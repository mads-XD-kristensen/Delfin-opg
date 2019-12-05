package formand;

import dellefin.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import misc.DataConnector;
// Indeholder metoder til at oprette/redigere i medlemmer

public class MetoderForFormand {

    public void lavMedlem() throws SQLException {

        Scanner myScan = new Scanner(System.in);
        String stamOpl = "";
        int alder = 0;
        boolean passivAktiv = false;
        

        System.out.println("Skriv navn, tlfnummer og adresse");
        stamOpl = myScan.nextLine();

        System.out.println("Skriv Årgang");
        alder = myScan.nextInt();

        //fanger nextLine for at forhindre scanner buggen
        myScan.nextLine();

        System.out.println("Skriv \"false\", hvis medlemmet er passivt eller \"true\" hvis medlemmet aktivt");
        passivAktiv = myScan.nextBoolean();

        System.out.println("Er medlemmet konkurrent? ja(1)/nej(2)");
        int trololo = myScan.nextInt();
        myScan.nextLine();
        
        if (trololo == 1) {
            System.out.println("Skriv medlemmets tilknyttede træners navn");
            String træner = "";
            træner = myScan.nextLine();
            try {
                Connection conn = DataConnector.getConnection();
                PreparedStatement stmt = conn.prepareStatement("insert into delfin.Medlem(stamOpl,alder,passivAktiv,træner) values(?,?,?,?)");

                stmt.setString(1, stamOpl);
                stmt.setInt(2, alder);
                stmt.setBoolean(3, passivAktiv);
                stmt.setString(4, træner);

                stmt.executeUpdate();
            } catch (SQLException se) {
                System.out.println("Det virkede ikke boiii");
            }
        } else if (trololo == 2) {
            try {
                Connection conn = DataConnector.getConnection();
                PreparedStatement stmt = conn.prepareStatement("insert into delfin.Medlem(stamOpl,alder,passivAktiv,træner) values(?,?,?,?)");

                stmt.setString(1, stamOpl);
                stmt.setInt(2, alder);
                stmt.setBoolean(3, passivAktiv);
                stmt.setString(4, null);

                stmt.executeUpdate();
            } catch (SQLException se) {
                System.out.println("Det virkede ikke boiii");
            }
        }
    }

    public void seMedlemmer() {

        try {
            Connection conn = DataConnector.getConnection();

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM delfin.medlem");

            while (resultSet.next()) {

                System.out.println("Medlemmets ID: " + resultSet.getInt("ID") + "\n"
                        + "Stam oplysninger: " + resultSet.getString("stamOpl") + "\n"
                        + "Årgang: " + resultSet.getInt("alder") + "\n" + "True hvis aktiv, false hvis passiv: "
                        + resultSet.getBoolean("passivAktiv") + "\n" + "Træner: " + resultSet.getString("Træner") + "\n");

            }
        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setMedlemTilPassivAktiv() {
        System.out.println("Skriv medlemmets ID");
        Scanner in = new Scanner(System.in);
        String ID = "";
        ID = in.nextLine();

        PreparedStatement statement = null;
        try {

            Connection conn = DataConnector.getConnection();

            System.out.println("Skriv \"1\" hvis hvis du vil gøre medlemmet aktivt og \"0\", hvis medlemmet skal gøres passivt.");

            int s = 0;

            s = in.nextInt();

            if (s == 1) {

                String sql = "update delfin.medlem set passivAktiv = 1 where ID = ?;";

                statement = conn.prepareStatement(sql);

                statement.setInt(1, Integer.parseInt(ID));

                statement.execute();
                System.out.println("Medlem: " + ID + " er registreret som aktivt");
            }
            if (s == 0) {

                String sql = "update delfin.medlem set passivAktiv = 0 where ID = ?;";

                statement = conn.prepareStatement(sql);

                statement.setInt(1, Integer.parseInt(ID));

                statement.execute();
                System.out.println("Medlem: " + ID + " er registreret som passivt");
            }
        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setMedlemKonkurrent() {
        System.out.println("Skriv medlemmets ID");
        Scanner in = new Scanner(System.in);
        String ID = "";
        ID = in.nextLine();

        PreparedStatement statement = null;
        try {

            Connection conn = DataConnector.getConnection();

            System.out.println("Skriv navnet på medlemmets træner");

            String s;

            s = in.nextLine();

            String sql = "update delfin.medlem set træner = ? where ID = ?;";

            statement = conn.prepareStatement(sql);

            statement.setString(1, s);
            statement.setInt(2, Integer.parseInt(ID));

            statement.execute();
            System.out.println("Medlem: " + ID + " er registreret som konkurrent");

        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setMedlemAlder() {
        System.out.println("Skriv medlemmets ID");
        Scanner in = new Scanner(System.in);
        String ID = "";
        ID = in.nextLine();

        System.out.println("Skriv ny årgang");
        String s;

        s = in.nextLine();

        PreparedStatement statement = null;
        try {

            Connection conn = DataConnector.getConnection();

            String sql = "update delfin.medlem set Alder = ? where ID = ?;";

            statement = conn.prepareStatement(sql);

            statement.setInt(1, Integer.parseInt(s));
            statement.setInt(2, Integer.parseInt(ID));

            statement.execute();
            System.out.println("Medlem: " + ID + " er registreret som værende årgang " + s);

        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setMedlemStamOpl() {
        System.out.println("Skriv medlemmets ID");
        Scanner in = new Scanner(System.in);
        String ID = "";
        ID = in.nextLine();

        System.out.println("Skriv nyt navn, telefon nummer og adresse");
        String s;

        s = in.nextLine();

        PreparedStatement statement = null;
        try {

            Connection conn = DataConnector.getConnection();

            String sql = "update delfin.medlem set stamOpl = ? where ID = ?;";

            statement = conn.prepareStatement(sql);

            statement.setString(1, s);
            statement.setInt(2, Integer.parseInt(ID));

            statement.execute();
            System.out.println("Medlem: " + ID + ", har fået disse nye stam oplysninger: " + s);

        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sletMedlem() {
        System.out.println("Skriv ID'et på medlemmet som du vil slette (Dette kan ikke fortrydes!)");
        Scanner in = new Scanner(System.in);
        String ID = "";
        ID = in.nextLine();

        PreparedStatement statement = null;
        try {

            Connection conn = DataConnector.getConnection();

            String sql = "Delete from delfin.Medlem where ID = ?;";

            statement = conn.prepareStatement(sql);

            statement.setInt(1, Integer.parseInt(ID));

            statement.execute();
            System.out.println("Medlem: " + ID + " er slettet fra databasen");

        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
