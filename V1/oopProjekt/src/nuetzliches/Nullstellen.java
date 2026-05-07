package nuetzliches;


import happylittleaccidents.UnendlichVieleNullstellenException;

/**
 * Klasse für die Berechnung von Nullstellen von mathematischen Funktionen
 */
public class Nullstellen {
	
	/**
	 * berechnet die reellen Nullstellen der Funktion a x² + b
	 * @param a Koeffizient von x²
	 * @param b Summand
	 * @throws UnendlichVieleNullstellenException wenn unendlich viele
	 * @throws IllegalArgumentException wenn a oder b NaN ist
	 * @return Array mit allen rellen Nullstellen der Funktion
	 * 		   a x² + b 
	 */
	public static double[] nullstellen(double a, double b) throws UnendlichVieleNullstellenException, IllegalArgumentException {

		if (Double.isNaN(a) || Double.isNaN(b)) {
			throw new IllegalArgumentException("Die Koeffizienten dürfen nicht NaN sein.");
		}

		if (a == 0) {
			if (b == 0) {
				throw new UnendlichVieleNullstellenException("Die Funktion hat unendlich viele Nullstellen, da sie konstant 0 ist.");
			}else {
				return new double[]{};
			}
		}

		double ergebnispositiv = Math.sqrt((-1 * b) / a);
		System.out.println("Ergebnis positiv: " + ergebnispositiv);
		double ergebnisnegativ = ergebnispositiv*(-1);

		if (ergebnispositiv == 0) {
			return new double[]{ergebnispositiv};
		}
        return new double[]{ergebnispositiv, ergebnisnegativ};
	}


	/**
	 * berechnet die Extrempunkte einer Funktion der Form ax³ + bx
	 * gemäß der Benutzereingabe von a und b
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		System.out.println("Berechnung der Maxima und Minima tertiärer Funktionen");
		double a = EinAusgabe.eingabeKommazahl("Koeefizient von x³: ");
		double b = EinAusgabe.eingabeKommazahl("Koeffizient von x: ");
		double[] extrema;
		try {
			extrema = nullstellen(3 * a, b);
		} catch (UnendlichVieleNullstellenException e) {
			System.out.println("Unendlich viele Nullstellen!");
			return;
		} catch (IllegalArgumentException e) {
			System.out.println("Ungültige Eingabe: " + e.getMessage());
			return;
		}
		if (extrema.length == 1) {
			System.out.println("Nur eine Nullstelle: " + extrema[0]);
			return;
		}
		double x = extrema[0];
		double y = a * Math.pow(x, 3) + b * x;
		System.out.println("Extrempunkt in (" + x + ", " + y + ")");
		x = extrema[1];
		y = a * Math.pow(x, 3) + b * x;
		System.out.println("Extrempunkt in (" + x + ", " + y + ")");
	}

}
