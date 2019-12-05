package træneren;

import dellefin.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import misc.DataConnector;

// Metoder til at oprette og se top 5 indenfor en disciplin
public class MetoderForTræneren {

    public void opretResultat() {
        Scanner myScan = new Scanner(System.in);

        int Medlem_ID = 0;
        String Stævne = "";
        String Placering = "";
        String Tid = "";
        String Svømmedisciplin = "";

        System.out.println("Skriv id");
        Medlem_ID = myScan.nextInt();

        //fanger nextLine for at forhindre scanner buggen
        myScan.nextLine();
        System.out.println("Navnet på stævnet");
        Stævne = myScan.nextLine();

        System.out.println("Placering");
        Placering = myScan.nextLine();

        System.out.println("Tid?(sek.msek)");
        Tid = myScan.nextLine();

        System.out.println("Hvilken svømmedisciplin? (Crawl, Rygcrawl, Butterfly, Brystsvømning)");
        Svømmedisciplin = myScan.nextLine();

        try {
            Connection conn = DataConnector.getConnection();
            PreparedStatement stmt;
            stmt = conn.prepareStatement("insert into delfin.svømresultat(Medlem_ID,Stævne,Placering,Tid,Svømmedisciplin) values(?,?,?,?,?)");
            stmt.setInt(1, Medlem_ID);
            stmt.setString(2, Stævne);
            stmt.setString(3, Placering);
            stmt.setString(4, Tid);
            stmt.setString(5, Svømmedisciplin);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SvømmeResultat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void seTop5Senior() {
        System.out.println("Hvilken svømmedisciplin vil du se top 5 for? (Crawl, Rygcrawl, Butterfly, Brystsvømning )");
        Scanner in = new Scanner(System.in);
        String s = "";
        ResultSet resultset = null;
        s = in.nextLine();

        PreparedStatement statement = null;
        try {

            Connection conn = DataConnector.getConnection();

            String sql = "select m.ID, m.stamOpl, m.alder, s.Stævne, s.medlem_id, s.tid, s.svømid,s.svømmedisciplin from medlem m, svømresultat s where s.Medlem_ID=m.id and alder < 2001 and s.Svømmedisciplin = ? order by Tid asc limit 5;";

            statement = conn.prepareStatement(sql);

            statement.setString(1, s);

            resultset = statement.executeQuery();

            while (resultset.next()) {

                System.out.println("Medlemmets ID: " + resultset.getInt("ID") + "\n"
                        + "Stam oplysninger: " + resultset.getString("stamOpl") + "\n"
                        + "Årgang: " + resultset.getInt("alder") + "\n"
                        + "Stævne: " + resultset.getString("Stævne") + "\n"
                        + "Tid: " + resultset.getString("Tid") + "\n"
                        + "Svømmedisciplinen: " + resultset.getString("Svømmedisciplin") + "\n");
            }

        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void seTop5Junior() {
        System.out.println("Hvilken svømmedisciplin vil du se top 5 for? (Crawl, Rygcrawl, Butterfly, Brystsvømning)");
        Scanner in = new Scanner(System.in);
        String s = "";
        ResultSet resultset = null;
        s = in.nextLine();

        PreparedStatement statement = null;
        try {

            Connection conn = DataConnector.getConnection();

            String sql = "select m.ID, m.stamOpl, m.alder, s.Stævne, s.medlem_id, s.tid, s.svømid,s.svømmedisciplin from medlem m, svømresultat s where s.Medlem_ID=m.id and alder > 2001 and s.Svømmedisciplin = ? order by Tid asc limit 5;";

            statement = conn.prepareStatement(sql);

            statement.setString(1, s);

            resultset = statement.executeQuery();

            while (resultset.next()) {

                System.out.println("Medlemmets ID: " + resultset.getInt("ID") + "\n"
                        + "Stam oplysninger: " + resultset.getString("stamOpl") + "\n"
                        + "Årgang: " + resultset.getInt("alder") + "\n"
                        + "Stævne: " + resultset.getString("Stævne") + "\n"
                        + "Tid: " + resultset.getString("Tid") + "\n"
                        + "Svømmedisciplinen: " + resultset.getString("Svømmedisciplin") + "\n");
            }

        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
