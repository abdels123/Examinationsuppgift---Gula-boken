import java.util.ArrayList;
import java.util.Scanner;

public class TelefonbokProgram {
    public static void main(String[] args) {
        Telefonbok telefonbok = new Telefonbok();
        Anvandare anvandare = new Anvandare(false, telefonbok);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVälj användartyp:");
            System.out.println("1. Gästanvändare");
            System.out.println("2. Administratör");
            System.out.println("3. Avsluta programmet");

            int val = scanner.nextInt();

            switch (val) {
                case 1:
                    hanteraGastAnvandare(anvandare);
                    break;
                case 2:
                    hanteraAdmin(anvandare);
                    break;
                case 3:
                    System.out.println("Programmet avslutas.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }

    private static void hanteraGastAnvandare(Anvandare anvandare) {
        // Implementera logik för gästanvändare
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nVälj en tjänst:");
            System.out.println("1. Sök efter profiler");
            System.out.println("2. Avsluta programmet");

            int val = scanner.nextInt();

            switch (val) {
                case 1:
                    anvandare.sokProfil();
                    break;
                case 2:
                    System.out.println("Återgår till huvudmenyn.");
                    return;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }

    private static void hanteraAdmin(Anvandare anvandare) {
        // Implementera admin-logik här
        // Du kan använda metoder från Anvandare och Telefonbok klasserna
        // Exempel:
        anvandare.telefonbok.skapaProfil("John", "Doe", 25, new Adress("City", "12345", "Street", "42"), new ArrayList<>());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nVälj en tjänst:");
            System.out.println("1. Skapa ny profil");
            System.out.println("2. Visa profiler");
            System.out.println("3. Uppdatera profil");
            System.out.println("4. Ta bort profil");
            System.out.println("5. Avsluta programmet");

            int val = scanner.nextInt();

            switch (val) {
                case 1:
                    anvandare.telefonbok.skapaNyProfil();
                    break;
                case 2:
                    anvandare.telefonbok.visaProfiler();
                    break;
                case 3:
                    anvandare.uppdateraProfil();
                    break;
                case 4:
                    anvandare.hanteraGastAnvandare();
                    break;
                case 5:
                    System.out.println("Programmet avslutas.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }
}
