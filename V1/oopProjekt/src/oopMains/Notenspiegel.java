package oopMains;

import nuetzliches.EinAusgabe;

/**
Programm zur Erstellung  eines Notenspiegels an der Hochschule
Der Dozent gibt die erzielten Noten ein, also z.B. 1-1-2-1-5-3-1-4-3,
dann schreibt das Programm den Notenspiegel hin, hier also:
Note 1: 4 mal
Note 2: 1 mal
Note 3: 2 mal
Note 4: 1 mal
Note 5: 1 mal
*/
public class Notenspiegel {

	static boolean empty = true;

	/**
	 * Erstellung eines Notenspiegels
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
	    int eingabe = 0;

		//anzahlNoten[0] = 1
		//anzahlNoten[1] = 2
		//anzahlNoten[2] = 3
	    int[] anzahlNoten = new int[5];

	    do {
	        eingabe = EinAusgabe.eingabeGanzzahl("Note: ");
			if (eingabe > 5) {
				System.out.println(eingabe + " ist keine mögliche Eingabe (1-5)!");
			}else if (eingabe > 0) {
				anzahlNoten[eingabe-1]++;
				empty = false;
			}
	    } while (eingabe > 0);

		if (!empty) {
			System.out.println();
			notenspiegel(anzahlNoten);
			durchschnitt(anzahlNoten);
		}else {
			System.out.println("Es wurden keine Noten eingegeben.");
		}
	}

	/**
	 * Gibt den Notenspiegel (Häufigkeiten der Noten 1 bis 5) auf der Konsole aus.
	 *
	 * Erwartetes Format der übergebenen Arrays:
	 * - anzahlNoten.length >= 5
	 * - anzahlNoten[0] enthält die Anzahl der Noten "1"
	 * - anzahlNoten[1] enthält die Anzahl der Noten "2"
	 * - ...
	 * - anzahlNoten[4] enthält die Anzahl der Noten "5"
	 *
	 * Wenn das Array null oder kürzer als 5 ist, kann eine ArrayIndexOutOfBoundsException auftreten.
	 *
	 * @param anzahlNoten ein int-Array mit den Häufigkeiten für die Noten 1..5
	 */
	public static void notenspiegel(int[] anzahlNoten) {
		System.out.println("1: " + anzahlNoten[0]);
		System.out.println("2: " + anzahlNoten[1]);
		System.out.println("3: " + anzahlNoten[2]);
		System.out.println("4: " + anzahlNoten[3]);
		System.out.println("5: " + anzahlNoten[4]);
	}

	/**
	 * Berechnet den arithmetischen Mittelwert aller vorhandenen Noten.
	 *
	 * Das übergebene Array beschreibt die Häufigkeiten der Noten 1..5:
	 * - noten[0] = Anzahl der 1er
	 * - noten[1] = Anzahl der 2er
	 * - ...
	 * - noten[4] = Anzahl der 5er
	 *
	 * Algorithmus: Für jede Note i wird der Beitrag (Anzahl * Note) aufsummiert
	 * und anschließend durch die Gesamtanzahl der Noten geteilt.
	 *
	 * Mögliche Fehler/Exceptions: Wird ein null-Array übergeben oder ist das Array
	 * kürzer als 5, kann eine ArrayIndexOutOfBoundsException auftreten.
	 *
	 * @param noten ein int-Array mit den Häufigkeiten für die Noten 1..5
	 */
	public static void durchschnitt(int[] noten) {
		double gesamt = 0;
		double anzahlAllerNoten = 0;
		for (int i = 0; i < noten.length; i++) {
			anzahlAllerNoten += noten[i];
		}
		for (int i=0; i < noten.length; i++) {
			if (noten[i] != 0) {
				gesamt += noten[i] * (i + 1);
			}
		}
		System.out.println("Durchschnitt: " + gesamt/anzahlAllerNoten);
	}

}