package dellefin;

import formand.medlem;
import træneren.SvømmeResultat;
import static java.lang.System.exit;
import java.sql.SQLException;
import java.util.Scanner;
import kasseren.MetoderForKasseren;
import misc.Utils;

public class controller {

    private Utils myUtils;
    private SvømmeResultat træneren;
    private MetoderForKasseren kasseren;
    private medlem formand;

    void start() throws SQLException {

        while (true) {
            Scanner myScan = new Scanner(System.in);
            myUtils.brugerMenu();
            int menu = myScan.nextInt();

            switch (menu) {

                case 1:
                    formand.seMedlemmer();
                    break;

                case 2:
                    myUtils.clearConsole();
                    System.out.println("Oprette medlem tryk 1\nSlem medlem tryk 2\nRedigere alder tryk 3\nRedigere stam oplysninger tryk 4\nRedigere medlems passiv/aktiv status tryk 5\nGør medlem til konkurrent eller skift et medlems træner - tryk 6 \n");
                    int submenu1 = myScan.nextInt();

                    switch (submenu1) {
                        case 1:
                            myUtils.clearConsole();
                            formand.lavMedlem();
                            break;

                        case 2:
                            formand.sletMedlem();
                            break;

                        case 3:
                            formand.setMedlemAlder();
                            break;

                        case 4:
                            formand.setMedlemStamOpl();
                            break;

                        case 5:
                            formand.setMedlemTilPassivAktiv();
                            break;

                        case 6:
                            formand.setMedlemKonkurrent();
                            break;
                    }

                    break;

                case 3:
                    myUtils.clearConsole();
                    System.out.println("Tryk 1 for at se restance oversigt\nTryk 2 for at ærklere et medlem som betalt");
                    int submenu2 = myScan.nextInt();

                    switch (submenu2) {

                        case 1:
                            myUtils.clearConsole();
                            kasseren.seRestanceOversigt();
                            break;

                        case 2:
                            kasseren.setBetalStatus();
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Top 5 senior 2019");
                    træneren.seTop5Senior();
                    System.out.println("");
                    System.out.println("Top 5 Junior 2019");
                    træneren.seTop5Junior();
                    break;

                case 5:
                    myUtils.clearConsole();
                    træneren.opretResultat();
                    break;

                default:
                    if (menu == 9) {

                        System.out.println("Slukker programmet ...");
                        exit(0);
                    }
                    break;
            }
        }
    }
}
