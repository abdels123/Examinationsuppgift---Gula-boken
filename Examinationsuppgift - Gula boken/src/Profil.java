
import java.util.ArrayList;
public class Profil extends Telefonbok {
        String fornamn;
        String efternamn;
        int age;
        Adress adress;
        ArrayList<String> telefonnummer;

        public Profil(String fornamn, String efternamn, int age, Adress adress, ArrayList<String> telefonnummer) {
            this.fornamn = fornamn;
            this.efternamn = efternamn;
            this.age = age;
            this.adress = adress;
            this.telefonnummer = telefonnummer;
        }
    }

