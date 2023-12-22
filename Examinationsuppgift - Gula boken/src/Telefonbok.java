import java.util.ArrayList;
import java.util.Scanner;

public class Telefonbok {
    ArrayList<Profil> profiler = new ArrayList<>();

    public void skapaProfil(String fornamn, String efternamn, int age, Adress adress, ArrayList<String> telefonnummer) {
        Profil profil = new Profil(fornamn, efternamn, age, adress, telefonnummer);
        profiler.add(profil);
        System.out.println("Profil skapad framgångsrikt.");
    }

    public void visaProfiler() {
        System.out.println("\nVisa profiler:");
        for (Profil profil : profiler) {
            System.out.println("Förnamn: " + profil.fornamn +
                    ", Efternamn: " + profil.efternamn +
                    ", Ålder: " + profil.age +
                    ", Adress: " + profil.adress.gatunamn +
                    ", Telefonnummer: " + profil.telefonnummer);
        }
    }

    public Profil sokProfilEfterEfternamn(String efternamn) {
        for (Profil profil : profiler) {
            if (profil.efternamn.equalsIgnoreCase(efternamn)) {
                return profil;
            }
        }
        return null;
    }

    public ArrayList<Profil> sokProfilEfterAdress(String gatunamn) {
        ArrayList<Profil> resultat = new ArrayList<>();
        for (Profil profil : profiler) {
            if (profil.adress.gatunamn.equalsIgnoreCase(gatunamn)) {
                resultat.add(profil);
            }
        }
        return resultat;
    }

    public ArrayList<Profil> sokProfilEfterFornamn(String fornamn) {
        ArrayList<Profil> resultat = new ArrayList<>();
        for (Profil profil : profiler) {
            if (profil.fornamn.equalsIgnoreCase(fornamn)) {
                resultat.add(profil);
            }
        }
        return resultat;
    }

    public ArrayList<Profil> frisokning(String sokterm) {
        ArrayList<Profil> resultat = new ArrayList<>();
        for (Profil profil : profiler) {
            if (profil.fornamn.equalsIgnoreCase(sokterm) ||
                    profil.efternamn.equalsIgnoreCase(sokterm) ||
                    profil.adress.gatunamn.equalsIgnoreCase(sokterm) ||
                    profil.telefonnummer.contains(sokterm)) {
                resultat.add(profil);
            }
        }
        return resultat;
    }

    public void uppdateraProfil(Profil gammalProfil, Profil nyProfil) {
        profiler.remove(gammalProfil);
        profiler.add(nyProfil);
        System.out.println("Profil uppdaterad framgångsrikt.");
    }

    public void taBortProfil(Profil profil) {
        profiler.remove(profil);
        System.out.println("Profil borttagen framgångsrikt.");
    }

    public void skapaNyProfil() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ange förnamn:");
        String fornamn = scanner.next();
        System.out.println("Ange efternamn:");
        String efternamn = scanner.next();
        System.out.println("Ange ålder:");
        int age = scanner.nextInt();
        System.out.println("Ange stad:");
        String stad = scanner.next();
        System.out.println("Ange postkod:");
        String postkod = scanner.next();
        System.out.println("Ange gatunamn:");
        String gatunamn = scanner.next();
        System.out.println("Ange portnummer:");
        String portnummer = scanner.next();
        Adress adress = new Adress(stad, postkod, gatunamn, portnummer);
        System.out.println("Ange antal telefonnummer:");
        int antalTelefonnummer = scanner.nextInt();
        ArrayList<String> telefonnummer = new ArrayList<>();
        for (int i = 0; i < antalTelefonnummer; i++) {
            System.out.println("Ange telefonnummer " + (i + 1) + ":");
            telefonnummer.add(scanner.next());
        }

        Profil nyProfil = new Profil(fornamn, efternamn, age, adress, telefonnummer);
        profiler.add(nyProfil);
        System.out.println("Ny profil skapad framgångsrikt.");
    }

    public void sokProfil() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ange sökterm:");
        String sokterm = scanner.next();

        ArrayList<Profil> resultat = frisokning(sokterm);

        if (resultat.isEmpty()) {
            System.out.println("Inga profiler hittades med söktermen: " + sokterm);
        } else {
            System.out.println("\nProfiler som matchar sökningen:");
            for (Profil profil : resultat) {
                System.out.println("Förnamn: " + profil.fornamn +
                        ", Efternamn: " + profil.efternamn +
                        ", Ålder: " + profil.age +
                        ", Adress: " + profil.adress.gatunamn +
                        ", Telefonnummer: " + profil.telefonnummer);
            }
        }
    }

    public void uppdateraProfil() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ange efternamn på profilen du vill uppdatera:");
        String efternamn = scanner.next();

        Profil gammalProfil = sokProfilEfterEfternamn(efternamn);

        if (gammalProfil == null) {
            System.out.println("Ingen profil hittades med efternamnet: " + efternamn);
            return;
        }

        System.out.println("Välj vad du vill uppdatera:");
        System.out.println("1. Förnamn");
        System.out.println("2. Efternamn");
        System.out.println("3. Ålder");
        System.out.println("4. Adress");
        System.out.println("5. Telefonnummer");

        int val = scanner.nextInt();

        switch (val) {
            case 1:
                System.out.println("Ange nytt förnamn:");
                gammalProfil.fornamn = scanner.next();
                break;
            case 2:
                System.out.println("Ange nytt efternamn:");
                gammalProfil.efternamn = scanner.next();
                break;
            case 3:
                System.out.println("Ange ny ålder:");
                gammalProfil.age = scanner.nextInt();
                break;
        }
    }
}

