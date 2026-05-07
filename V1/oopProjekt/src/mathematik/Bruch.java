package mathematik;

import java.math.BigInteger;

public class Bruch {

    private int zaehler;
    private int nenner;

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        if (nenner != 0) {
            this.nenner = nenner;
        } else {
            throw new IllegalArgumentException("Nenner darf nicht 0 sein");
        }
    }

    public Bruch(int zaehler) {
        this.zaehler = zaehler;
        this.nenner = 1;
    }

    public double getWert() {
        return zaehler/nenner;
    }

    public Bruch multiplizieren(Bruch bruch) {
        int neuerZaehler = this.zaehler * bruch.zaehler;
        int neuerNenner = this.nenner * bruch.nenner;
        return new Bruch(neuerZaehler, neuerNenner);
    }

    public Bruch multiplizieren(int faktor) {
        int neuerZaehler = this.zaehler * faktor;
        return new Bruch(neuerZaehler, this.nenner);
    }

    public Bruch dividieren(Bruch divisor) {
        int neuerZaehler = this.zaehler * nenner;
        int neuerNenner = this.nenner * this.zaehler;
        return new Bruch(neuerZaehler, neuerNenner);
    }

    public Bruch addieren(Bruch summand) {
        BigInteger kgv = new BigInteger(String.valueOf(this.nenner));
        return new Bruch(1);
    }

}
