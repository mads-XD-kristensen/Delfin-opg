
package dellefin;


import java.io.IOException;
import static java.lang.System.exit;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;


public class controller {
    void start() throws SQLException {
        lavMedlem();
    }

    public void lavMedlem() throws SQLException
    {
        Scanner myScan = new Scanner(System.in);
        String stamOpl = "";
        int alder = 0;
        boolean passivAktiv = false;
        
        
        
        
        System.out.println("Skriv navn, tlfnummer og adresse");
        stamOpl = myScan.nextLine();
        
        System.out.println("Sriv alder (med tal)");
        alder = myScan.nextInt();
        
        //fanger nextInt
        myScan.nextLine();
        
        System.out.println("Skriv \"false\", hvis medlemmet er passivt eller \"true\" hvis medlemmet aktivt");
        passivAktiv = myScan.nextBoolean();
        
        medlem medlem = new medlem(stamOpl, alder, passivAktiv);
        
       
        try
                {
                    Connection conn = DataConnector.getConnection();
                    PreparedStatement stmt = conn.prepareStatement("insert into delfin.Medlem(stamOpl,alder,passivAktiv) values(?,?,?)");
                    
                    stmt.setString(1,stamOpl);
                    stmt.setInt(2, alder);
                    stmt.setBoolean(3, passivAktiv);
                   
                    stmt.executeUpdate();
                }   
                catch (SQLException se)
                {
                    System.out.println("Det virkede ikke boiii");
                } 

    }
    /*
    public void getUserInput() throws IOException {

        answer = myScan.nextInt();
        switch (answer) {
            case 1:
                myUtils.clearConsole();
                ;
                System.out.println(menuCard.toString());
                System.out.println("Press 0 to return to main menu");
                myUtils.splitDisplay();
                break;

            case 2:
                listPizzas = new ArrayList<>();
                this.currentOrder = null;
                listPizzas.clear();
                while (true) {
                    myUtils.clearConsole();
                    System.out.println(menuCard.toString());
                    System.out.println("Press 0 to return to main menu\n");
                    System.out.println("Which pizza from the menu card would you like to add as a order, enter a number 1-14, ");
                    myUtils.splitDisplay();
                    System.out.print("Enter pizza number: ");
                    

                    pizzaNo = myScan.nextInt();

                    listPizzas.add(pizzaNo);

                    myUtils.clearConsole();

                    if (pizzaNo >= 1 && pizzaNo <= 14) {

                        if (currentOrder == null) {
                            this.currentOrder = new Order(new ArrayList<>(), pickUpTime, customerId);

                        }
                        this.currentOrder.getPizzas().add(menuCard.getMenuCard().get(pizzaNo));

                    } else {
                        System.out.println("Pizza does not exist in menu card, please press 0 to return to main menu and try again ...");
                        break;
                    }

                    if (pizzaNo == 0) {

                        myUtils.clearConsole();

                        break;
                    }

                    // lave database kald, hvor jeg gemmer orderen med pizzaer før jeg nulstiller ordren.
                    // this.currentOrder = null; nulstil orderen
                }

                if (this.currentOrder != null) {
                    myUtils.clearConsole();
                    System.out.print("Enter a customer id for this order: ");
                    customerId = myScan.nextInt();
                    myUtils.clearConsole();
                    myScan.nextLine();
                    System.out.print("Enter a pick up time: ");
                    pickUpTime = myScan.nextLine();
                    myUtils.clearConsole();

                }

                for (int i = 0; i < currentOrder.getPizzas().size(); i++) {
                    connectOrderDatabase.insertOrder(customerId, listPizzas.get(i), pickUpTime);

                }

                myUtils.clearConsole();
                myUtils.printMainMenu();

                break;

            case 3:
                myUtils.clearConsole();
                System.out.println("Customer ID     PizzaName    PickUpTime");
                connectOrderDatabase.getCurrentOrders();
                System.out.println("\nPress 0 to return to main menu");
                myUtils.splitDisplay();
                System.out.println("Would you like to remove a order? Press 1");
                int remove = myScan.nextInt();
                myUtils.clearConsole();
                if (remove == 1) {
                    connectOrderDatabase.getCurrentOrders();
                    myUtils.splitDisplay();
                    System.out.println("Enter a customer id");
                    int customerId = myScan.nextInt();
                    connectOrderDatabase.updateOrdner(customerId);
                    myUtils.clearConsole();
                    myUtils.printMainMenu();
                } else {
                    myUtils.clearConsole();
                    myUtils.printMainMenu();
                }

                break;

            case 4:
                myUtils.clearConsole();
                System.out.println("Customer ID     PizzaName    PickUpTime");
                connectOrderDatabase.showOrderHistory();
                System.out.println("\nPress 0 to return to main menu");
                myUtils.splitDisplay();

                break;

            case 5:
                myUtils.clearConsole();

                System.out.println("Pizza Amount       PizzaName      AmountSold");
                connectOrderDatabase.Statistics();
                System.out.println("\nPress 0 to return to main menu");
                myUtils.splitDisplay();

                break;

            case 0:
                myUtils.clearConsole();

                myUtils.printMainMenu();

                break;

            default:
                if (answer == 9) {
                    myUtils.clearConsole();

                    System.out.println("System ending ...");
                    exit(0);
                }
                myUtils.clearConsole();
                myUtils.printMainMenu();
                break;
        }*/

   
}