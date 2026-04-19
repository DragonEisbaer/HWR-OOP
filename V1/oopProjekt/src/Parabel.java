/**
 * Die Klasse {@code Parabel} zeichnet eine einfache textbasierte Parabel in der Konsole.
 * <p>
 * Der Benutzer gibt einen Bereich {@code x} ein. Anschließend werden für alle Werte
 * von {@code -x} bis {@code x} die quadrierten Werte berechnet und als Einrückung
 * für ein Sternchen verwendet.
 */
public class Parabel {

    /**
     * Startet das Programm.
     * <p>
     * Der Benutzer gibt einen Bereich für die Parabel ein. Danach wird die Parabel
     * zeilenweise in der Konsole ausgegeben.
     *
     * @param args Kommandozeilenargumente, werden nicht verwendet
     */
    public static void main(String[] args) {

        int x = EinAusgabe.eingabeGanzzahl("Gebe einen Bereich ein für die Parabel: ");
        zeichneParabel(x);
    }

    /**
     * Berechnet das Quadrat einer Zahl.
     *
     * @param x die Zahl, die quadriert werden soll
     * @return das Quadrat von {@code x}
     */
    public static int quadrieren(int x){
        return x*x;
    }

    /**
     * Gibt eine Zeile mit einem Sternchen aus, das entsprechend eingerückt ist.
     *
     * @param y die Anzahl der Leerzeichen vor dem Sternchen
     */
    public static void zeichnenZeile(int y) {
        System.out.printf("%" + (y + 1) + "s%n", "*");
    }

    /**
     * Zeichnet eine textbasierte Parabel für den Bereich von {@code -x} bis {@code x}.
     *
     * @param x der Bereich der Parabel
     */

    public static void zeichneParabel(int x) {
        for (int i = -x; i < 0; i++) {
            zeichnenZeile(quadrieren(i));
        }
        for (int i = 0; i <= x; i++) {
            zeichnenZeile(quadrieren(i));
        }
    }
}
