package bankprojekt;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * berechnet testweise eine IBAN
 */
public class IBAN {
	
	/**
	 * berechnet testweise eine IBAN
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		long kontonummer = 5736345208L;
		long blz = 50010517L;
		System.out.println("Die Beispiel-IBAN lautet: ");
		System.out.println(ibanBerechnen(blz, kontonummer));
		String eingabe;
		do {
			System.out.print("Ihre BLZ bitte: ");
			blz = tastatur.nextLong();
			System.out.print("Ihre Kontonummer bitte: ");
			kontonummer = tastatur.nextLong();
			// nullen müssen noch aufgefüllt werden.
			System.out.println("Die IBAN dazu lautet: ");
			System.out.println(ibanBerechnen(blz, kontonummer));
			System.out.print("Nochmal? (ja/nein) ");
			eingabe = tastatur.next();
		} while (eingabe.equalsIgnoreCase("ja"));
	}
	/**
	 * Berechnet testweise eine IBAN aus Bankleitzahl und Kontonummer.
	 *
	 * @param blz Bankleitzahl
	 * @param kontonummer Kontonummer
	 * @return berechnete IBAN als {@code long};
	 */
	public static String ibanBerechnen(long blz, long kontonummer) {
		String x = String.valueOf(blz) + String.valueOf(kontonummer) + "131400";
		BigInteger y = new BigInteger(x).mod(new BigInteger("97"));
		BigInteger pruefziffer = new BigInteger("98").subtract(y);
        return String.format("DE%02d%08d%010d", pruefziffer, blz, kontonummer);
	}

}