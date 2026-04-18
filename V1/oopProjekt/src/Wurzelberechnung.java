/**
 * Konsolenprogramm zur Berechnung einer n-ten Wurzel.
 * <p>
 * Das Programm liest einen Radikanden sowie einen Exponenten ein
 * und gibt anschließend das Ergebnis der Wurzelberechnung aus.
 * </p>
 */
public class Wurzelberechnung {
       /**
     * Einstiegspunkt des Programms.
     * <p>
     * Fragt den Benutzer nach:
     * <ul>
     *   <li>einem positiven Radikanden</li>
     *   <li>einem Exponenten (Grad der Wurzel)</li>
     * </ul>
     * und gibt danach das berechnete Ergebnis auf der Konsole aus.
     *
     * @param args Kommandozeilenargumente (werden in diesem Programm nicht verwendet)
     */
    public static void main(String[] args) {
        double radikant = EinAusgabe.eingabePositiveKommazahl("Gebe einen Radikanten ein: ", "Der Radikant muss positiv sein.");
        int exponent = EinAusgabe.eingabeGanzzahl("Gebe einen Exponenten ein: ");
        double wurzel = Mathematik.wurzelBerechnung(exponent, radikant);
        System.out.println(wurzel);
        System.out.println(Math.round(wurzel * 10000) / 10000); // warum 1?
    }
}