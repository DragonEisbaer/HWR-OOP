package bankprojekt.ausprobieren;

import java.time.LocalDate;

import bankprojekt.Konto;
import bankprojekt.Kunde;
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
		Kunde ich = new Kunde("Doro", "Hubrich", "zuhause", LocalDate.of(1976, 7, 13));
		Konto zwei = new Konto(ich, 1000);
		Konto drei = new Konto(ich, 500);
		System.out.println(k.getInhaber() + ": " + k.getNummer());
		System.out.println(zwei.getInhaber() + ": " + zwei.getNummer());
		System.out.println(drei.getInhaber() + ": " + drei.getNummer());
		drei.setGesperrt(true);
		boolean hatGeklappt;
		try {
			hatGeklappt = drei.abheben(200);
		} catch (GesperrtException e) {
			System.out.println(e.getMessage());
		}
		try {
			zwei.einzahlen(-100);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Falscher Betrag!");
		}
	}

}