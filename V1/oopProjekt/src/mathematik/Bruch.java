package mathematik;

import java.math.BigInteger;

/**
 * Repräsentiert einen mathematischen Bruch, bestehend aus Zähler und Nenner.
 * Bietet grundlegende arithmetische Operationen wie Addition, Subtraktion, Multiplikation, Division sowie das Kürzen des Bruchs.
 */
public class Bruch {

    private int zaehler;
    private int nenner;

    /**
     * Erstellt einen neuen Bruch mit dem angegebenen Zähler und Nenner.
     *
     * @param zaehler der Zähler des Bruchs
     * @param nenner  der Nenner des Bruchs
     * @throws IllegalArgumentException wenn der Nenner 0 ist
     */
    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        if (nenner != 0) {
            this.nenner = nenner;
        } else {
            throw new IllegalArgumentException("Nenner darf nicht 0 sein");
        }
    }

    /**
     * Erstellt einen neuen Bruch aus einer Ganzzahl. Der Nenner wird automatisch auf 1 gesetzt.
     *
     * @param zaehler der Zähler des Bruchs (die Ganzzahl)
     */
    public Bruch(int zaehler) {
        this.zaehler = zaehler;
        this.nenner = 1;
    }

    /**
     * Berechnet den dezimalen Wert des Bruchs.
     *
     * @return der berechnete Dezimalwert des Bruchs
     */
    public double getWert() {
        return (double) zaehler / nenner;
    }

    /**
     * Multipliziert diesen Bruch mit einem anderen Bruch und gibt das Ergebnis als neuen Bruch zurück.
     *
     * @param bruch der Bruch, mit dem multipliziert werden soll
     * @return ein neuer Bruch, der das Produkt darstellt
     */
    public Bruch multiplizieren(Bruch bruch) {
        int neuerZaehler = this.zaehler * bruch.zaehler;
        int neuerNenner = this.nenner * bruch.nenner;
        return new Bruch(neuerZaehler, neuerNenner);
    }

    /**
     * Multipliziert diesen Bruch mit einer Ganzzahl und gibt das Ergebnis als neuen Bruch zurück.
     *
     * @param faktor die Ganzzahl, mit der multipliziert werden soll
     * @return ein neuer Bruch, der das Produkt darstellt
     */
    public Bruch multiplizieren(int faktor) {
        int neuerZaehler = this.zaehler * faktor;
        return new Bruch(neuerZaehler, this.nenner);
    }

    /**
     * Dividiert diesen Bruch durch einen anderen Bruch und gibt das Ergebnis als neuen Bruch zurück.
     *
     * @param divisor der Bruch, durch den dividiert werden soll
     * @return ein neuer Bruch, der den Quotienten darstellt
     */
    public Bruch dividieren(Bruch divisor) {
        int neuerZaehler = this.zaehler * divisor.nenner;
        int neuerNenner = this.nenner * divisor.zaehler;
        return new Bruch(neuerZaehler, neuerNenner);
    }

    /**
     * Addiert einen anderen Bruch zu diesem Bruch und gibt das Ergebnis als neuen Bruch zurück.
     *
     * @param summand der Bruch, der addiert werden soll
     * @return ein neuer Bruch, der die Summe darstellt
     */
    public Bruch addieren(Bruch summand) {
        BigInteger num1xnum2 = new BigInteger(String.valueOf(this.nenner)).multiply(new BigInteger(String.valueOf(summand.nenner)));
        BigInteger ggT = new BigInteger(String.valueOf(this.nenner)).gcd(new BigInteger(String.valueOf(summand.nenner)));
        BigInteger kgv = num1xnum2.divide(ggT);
        int neuerZaehler = (this.zaehler * (kgv.intValue() / this.nenner) + summand.zaehler * (kgv.intValue() / summand.nenner));
        return new Bruch(neuerZaehler, kgv.intValue());
    }

    /**
     * Kürzt diesen Bruch auf seine einfachste Form, indem Zähler und Nenner durch ihren größten gemeinsamen Teiler (ggT) geteilt werden.
     */
    public void kuerzen() {
        BigInteger ggt = BigInteger.valueOf(this.nenner).gcd(BigInteger.valueOf(this.zaehler));
        this.zaehler /= ggt.intValue();
        this.nenner /= ggt.intValue();
    }

    /**
     * Subtrahiert einen anderen Bruch von diesem Bruch und gibt das Ergebnis als neuen Bruch zurück.
     *
     * @param subtrahent der Bruch, der abgezogen werden soll
     * @return ein neuer Bruch, der die Differenz darstellt
     */
    public Bruch subtrahieren(Bruch subtrahent) {
        BigInteger num1xnum2 = new BigInteger(String.valueOf(this.nenner)).multiply(new BigInteger(String.valueOf(subtrahent.nenner)));
        BigInteger ggT = new BigInteger(String.valueOf(this.nenner)).gcd(new BigInteger(String.valueOf(subtrahent.nenner)));
        BigInteger kgv = num1xnum2.divide(ggT);
        int neuerZaehler = (this.zaehler * (kgv.intValue() / this.nenner) - subtrahent.zaehler * (kgv.intValue() / subtrahent.nenner));
        return new Bruch(neuerZaehler, kgv.intValue());
    }

    /**
     * Gibt den Zähler des Bruchs zurück.
     *
     * @return der Zähler des Bruchs
     */
    public int getZaehler() {
        return this.zaehler;
    }

    /**
     * Gibt den Nenner des Bruchs zurück.
     *
     * @return der Nenner des Bruchs
     */
    public int getNenner() {
        return this.nenner;
    }
}
