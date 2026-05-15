package bankprojekt;

import happylittleaccidents.GesperrtException;

import java.text.NumberFormat;

/**
 * Die Objekte dieser Klasse stellen Konten bei einer Bank dar.
 * Modelliert werden der Inhaber, die Kontonummer und der Kontostand des
 * Kontos.
 * @author Dorothea Hubrich
 *
 */
public class Konto {

	private static long anzahlBisherErstellterKonten = 0;

	/**
	 * die Kontonummer
	 */
	private final long nummer;
	/**
	 * der Kontostand
	 */
	private double kontostand;
	/**
	 * gibt an, ob das Konto gesperrt ist. Aktionen zum Schaden des Inhabers sind dann
	 * nicht möglich
	 */
	private boolean gesperrt; 
	
	/**
	 * Besitzer des Kontos
	 */
	private Kunde inhaber;

	/**
	 * erstellt ein leeres Konto für Max Mustermann
	 */
	public Konto() {
		this(Kunde.MUSTERMANN, 0);
	}

	/**
	 * Dieser Konstruktor erstellt ein Konto
	 * für den angegebenen Inhaber mit dem angegebenen Kontostand
	 * @param inhaber der neue Kontoinhaber
	 * @param anfangsstand der anfängliche Kontostand; darf nicht negativ sein
	 * @throws IllegalArgumentException wenn inhaber null oder leer
	 * 									oder anfangsstand negativ
	 */
	public Konto(Kunde inhaber, double anfangsstand)
	{
		if(inhaber == null || inhaber.equals(""))
		{	
			throw new IllegalArgumentException("Inhaber fehlerhaft");
		}
		if(anfangsstand < 0)
			throw new IllegalArgumentException("Negativer Kontostand unmöglich");
		this.inhaber = inhaber;
		this.kontostand = anfangsstand;
		this.nummer = anzahlBisherErstellterKonten;
		this.gesperrt = false;
		anzahlBisherErstellterKonten++;
	}

	/**
	 * gesperrt
	 * @return gesperrt
	 */
	public boolean isGesperrt() {
		return gesperrt;
	}

	/**
	 * setzt gesperrt neu
	 * @param gesperrt neuer Wert für gesperrt
	 */
	public void setGesperrt(boolean gesperrt) {
		this.gesperrt = gesperrt;
	}

	/**
	 * inhaber
	 * @return inhaber
	 */
	public Kunde getInhaber() {
		return inhaber;
	}

	/**
	 * setzt inhaber neu
	 * @param inhaber neuer Wert für inhaber
	 * @throws IllegalArgumentException wenn inhaber null oder leer ist
	 * @throws GesperrtException wenn das Konto gesperrt ist
	 */
	public void setInhaber(Kunde inhaber) throws GesperrtException {

		if (this.isGesperrt()) {
			throw new GesperrtException();
		}
		if(inhaber == null || inhaber.getName().isEmpty())
			throw new IllegalArgumentException();
		this.inhaber = inhaber;
	}

	/**
	 * nummer
	 * @return nummer
	 */
	public long getNummer() {
		return nummer;
	}

	/**
	 * kontostand
	 * @return kontostand
	 */
	public double getKontostand() {
		return kontostand;
	}

	/**
	 * gibt die IBAN dieses Kontos zurück
	 * @param bankleitzahl BLZ der Bank, bei der dieses Konto geführt wird
	 * @return IBAN aus bankleitzahl und der Kontonummer von this
	 */
	public String getIban(long bankleitzahl) 
	{
		return IBAN.ibanBerechnen(this.nummer, bankleitzahl);
	}
	
	/**
	 * zahlt den Betrag auf this ein
	 * @param betrag der einzuzahlender Betrag, darf nicht negativ sein
	 * @throws IllegalArgumentException wenn betrag negativ ist
	 */
	public void einzahlen(double betrag) throws IllegalArgumentException
	{
		if (betrag < 0) {
			throw new IllegalArgumentException("Negativer Betrag nicht möglich");
		}else {
			this.kontostand = this.kontostand + betrag;
		}
	}
	
	/**
	 * hebt den gewünschten betrag von this ab
	 * @param betrag der gewünschte Abhebungsbetrag, darf nicht negativ sein
	 * @return true, wenn die Abhebung möglich war; false, wenn
	 * 		   das Konto nicht ausreichend gedeckt ist
	 * @throws GesperrtException wenn das Konto gesperrt ist
	 */
	public boolean abheben(double betrag) throws GesperrtException
	{
		if (this.isGesperrt()) {
			throw new GesperrtException(this.nummer);
		}
		if(betrag <= this.kontostand) {
			this.kontostand = this.kontostand - betrag;
			return true;
		}
		return false;
	}

	/**
	 * setzt kontostand neu
	 * @param kontostand neuer Wert für kontostand
	 */
	protected void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}

	
	/**
	 * zum Ausprobieren von Konten mit vollem Zugriff auf
	 * private Mitglieder
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		Konto hier = new Konto();
		System.out.println(hier.nummer + ": " + hier.inhaber);
	}

	/**
	 * formatiert den Kontostand in die jeweilige Währung
	 * @return Formatierten Kontostand
	 */
	public String getKontostandFormatiert() {
		return NumberFormat.getCurrencyInstance().format(this.kontostand);
	}
}
