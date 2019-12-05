package misc;

public class Utils {

    // En lille metode som gør programmet lidt mere overskueligt når det kører
    public void clearConsole() {
        for (int i = 0; i <= 25; i++) {
            System.out.println("");
        }
    }

    // Printer main menu
    public void brugerMenu() {
        System.out.println("Velkommen! \n \nTryk 1 for: Medlems oversigt\nTryk 2 for: Redigere medlem\nTryk 3 for: Se restance meny\n"
                + "Tryk 4 for: Se top 5\nTryk 5 for at oprette et ny svømmeresultat\nTryk 9 for at aflutte programmet");

    }
}
