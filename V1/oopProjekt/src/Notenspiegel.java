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

	/**
	 * Erstellung eines Notenspiegels
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
	    int eingabe = 0;

	    //Array anlegen (Aufgabe 4a)

	    do {
	        eingabe = EinAusgabe.eingabeGanzzahl("Note: ");
	        //eingegebene Note zählen (Aufgabe 4b)

	    } while (eingabe > 0);


	    System.out.println();
	    System.out.println("Notenspiegel:");
	    //fertigen Notenspiegel ausgeben (Aufgabe 4c)

	}

}
