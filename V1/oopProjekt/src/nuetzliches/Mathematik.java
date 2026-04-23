package nuetzliches;

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

    /**
     * Ermittelt alle Primzahlen kleiner oder gleich {@code n}.
     * <p>
     * Die Methode verwendet ein einfaches Siebverfahren und gibt die gefundenen
     * Primzahlen in einem neuen Array zurück.
     *
     * @param n die obere Grenze für die Primzahlsuche
     * @return ein Array mit allen Primzahlen von {@code 2} bis {@code n}
     */
    public static int[] kleinerePrimzahlen(int n) {
        int[] zahlen = new int[n+1];
        for (int i = 2; i <= n; i++) {
            zahlen[i] = i;
        }

        for (int p = 2; p <= n; p++) {
            if (zahlen[p] != 0) {
                for (int j = p + p; j <= n; j += p) {
                    zahlen[j] = 0;
                }
            }
        }

        int anzahl = 0;
        for (int i = 2; i <= n; i++) {
            if (zahlen[i] != 0) {
                anzahl++;
            }
        }

        int[] primzahlen = new int[anzahl];
        int index = 0;

        for (int i = 2; i <= n; i++) {
            if (zahlen[i] != 0) {
                primzahlen[index] = zahlen[i];
                index++;
            }
        }
    return primzahlen;
    }
}
