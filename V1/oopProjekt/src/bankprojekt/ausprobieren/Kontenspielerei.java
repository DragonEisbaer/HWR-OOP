package bankprojekt.ausprobieren;

import bankprojekt.Konto;
import happylittleaccidents.GesperrtException;

/**
 * Testprogramm für die Klasse Konto
 * @author Dorothea Hubrich
 *
 */
public class Kontenspielerei {

	/**
	 * ein wenig einzahlen und abheben
	 * @param args
	 */
	public static void main(String[] args) {
		Konto k = new Konto();
		System.out.println(k.getInhaber());
		System.out.println(k.getIban(50010517));
		System.out.println("Vor der Einzahlung: " + k.getKontostand());
		k.einzahlen(100);
		System.out.println("Nach der Einzahlung: " + k.getKontostand());
		Konto neu = new Konto("Maxi", 11000);
		Konto neu1 = new Konto("basti", 0);
		System.out.println(k.getNummer());
		System.out.println(neu.getNummer());
		System.out.println(neu1.getNummer());
		System.out.println("Knotostand: " + neu1.getKontostandFormatiert());
		neu.setGesperrt(true);
		try {
			neu.abheben(1);
		}catch (GesperrtException e) {
			System.out.println("Fehler: " + e.getMessage());
		}
	}

}