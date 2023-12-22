import java.util.Scanner;

public class Anvandare extends Telefonbok {
    boolean admin;
    Telefonbok telefonbok;

    public Anvandare(boolean admin, Telefonbok telefonbok) {
        this.admin = admin;
        this.telefonbok = telefonbok;
    }

    public void hanteraGastAnvandare() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nVälj en tjänst:");
            System.out.println("1. Sök efter profiler");
            System.out.println("2. Avsluta programmet");

            int val = scanner.nextInt();

            switch (val) {
                case 1:
                    sokProfil();
                    break;
                case 2:
                    System.out.println("Programmet avslutas.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }
}
