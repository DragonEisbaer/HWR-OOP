package bankprojekt.ausprobieren;

import bankprojekt.Konto;
import bankprojekt.Kunde;
import bankprojekt.Sparbuch;
import happylittleaccidents.GesperrtException;

public class Sparbuchspielereien {
    public static void main(String[] args) throws GesperrtException {
        Kunde test = new Kunde();
        Sparbuch spar1 = new Sparbuch(0.05);
        Sparbuch spar2 = new Sparbuch(test, 0.005);

        spar1.einzahlen(1000);
        spar2.einzahlen(10000);

        System.out.println(spar1.getKontostand());
        System.out.println(spar2.getKontostand());
        try {
            spar1.abheben(500);
        } catch (GesperrtException e) {
            System.out.println(e.getMessage());
        }
        try {
            spar2.abheben(2000);
        }catch (GesperrtException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(spar1.getKontostand());
        System.out.println(spar2.getKontostand());
    }
}
