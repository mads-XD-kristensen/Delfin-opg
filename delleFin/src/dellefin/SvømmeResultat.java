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

//    public SvømmeResultat() {
//    }
//    
}
