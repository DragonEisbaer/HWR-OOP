package bankprojekt;

import happylittleaccidents.GesperrtException;
import nuetzliches.Kalender;

import java.time.LocalDate;

public class Sparbuch extends Konto{

    private double zinssatz;
    private int bereitsAbgehoben;
    private final int MONATLICHE_GRENZE = 2000;
    private final double MINDESTBETRAG = 0.5;
    private LocalDate zeitpunkt;

    public Sparbuch(double zinssatz) {
        this(Kunde.MUSTERMANN, zinssatz);
    }

    public Sparbuch(Kunde inhaber, double zinssatz) {
        super(inhaber, 0);
        if (zinssatz < 0) {
            throw new IllegalArgumentException("Zinssatz darf nicht negativ sein.");
        }
        this.zinssatz = zinssatz;
    }

    public Sparbuch(Kunde inhaber, double zinssatz, Kalender kalender) {
        this(inhaber, zinssatz);
        this.zeitpunkt = Kalender.getHeutigesDatum();
    }

    public double getZinssatz() {
        return this.zinssatz;
    }

    public void setZinssatz(double neu) {
        this.zinssatz = neu;
    }

    @Override
    public String toString() {
        return super.toString() + "Zinssatz: " + this.zinssatz;
    }

    @Override
    public boolean abheben(double betrag) throws GesperrtException {
        if (this.isGesperrt()) {
			throw new GesperrtException(this.getNummer());
		}
		if((this.getKontostand()-betrag) >= MINDESTBETRAG) {
			this.setKontostand(this.getKontostand() - betrag);
			return true;
		}
		return false;
    }
}
