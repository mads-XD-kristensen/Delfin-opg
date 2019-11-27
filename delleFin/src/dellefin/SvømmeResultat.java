package dellefin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SvømmeResultat {

    int Medlem_ID;
    String Stævne;
    String Placering;
    String Tid;
    String Svømmedisciplin;

    public SvømmeResultat(int Medlem_ID, String Stævne, String Placering, String Tid, String Svømmedisciplin) {
        this.Medlem_ID = Medlem_ID;
        this.Stævne = Stævne;
        this.Placering = Placering;
        this.Tid = Tid;
        this.Svømmedisciplin = Svømmedisciplin;

    }

    public void opretResultat() {
        Scanner myScan = new Scanner(System.in);
        
        System.out.println("Skriv id");
        Medlem_ID = myScan.nextInt();
        //fanger nextInt
        myScan.nextLine(); 
        System.out.println("Navnet på stævnet");
        Stævne = myScan.nextLine();
        
       
        System.out.println("Placering");
        Placering = myScan.nextLine();
        
        System.out.println("TId`?");
        Tid = myScan.nextLine();
        
        System.out.println("Hvilken svømmedisciplin?");
        Svømmedisciplin = myScan.nextLine();
        
        
        try {
            Connection conn = DataConnector.getConnection();
            PreparedStatement stmt;
            stmt = conn.prepareStatement("insert into delfin.svømmeresultat(Medlem_ID,Stævne,Placering,Tid,Svømmedisciplin) values(?,?,?,?,?)");
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
}
