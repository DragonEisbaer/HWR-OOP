/**
 * Stellt mathematische Hilfsmethoden bereit.
 */
public class Mathematik {

    /**
     * Berechnet näherungsweise die {@code n}-te Wurzel einer Zahl mit dem Bisektionsverfahren.
     * <p>
     * Die Berechnung endet, sobald die Abweichung {@code |eingabezahl - root^n|}
     * höchstens {@code 0.001} beträgt.
     * </p>
     * <p>
     * Für negative Eingabewerte wird das Intervall auf {@code [eingabezahl, 1]}
     * gesetzt.
     * </p>
     *
     * @param n Grad der Wurzel (z. B. {@code 2} für Quadratwurzel)
     * @param eingabezahl Zahl, aus der die Wurzel berechnet werden soll
     * @return näherungsweiser Wert der {@code n}-ten Wurzel
     */
    public static double wurzelBerechnung(int n, double eingabezahl) {
        double ugrenze = 1;
        double ogrenze = eingabezahl;
        double root = (ugrenze + ogrenze)/2;

        if (eingabezahl < 0) {
            ugrenze = eingabezahl;
            ogrenze = 1;
            root = (ugrenze + ogrenze)/2;
        }

        while (Math.abs(eingabezahl-Math.pow(root, n)) > 0.001) {
            if (Math.pow(root, n) > eingabezahl) {
                ogrenze = root;
            }else {
                ugrenze = root;
            }
            root = (ugrenze + ogrenze)/2;
        }
        return root;
    }
}
