package bankprojekt;

import java.time.LocalDate;
import java.time.Period;

/**
 * Repräsentiert einen Bankkunden mit Name, Adresse und Geburtstag.
 * <p>
 * Die Klasse bietet einfache Zugriffsmethoden sowie eine berechnete Altersangabe
 * auf Basis des aktuellen Tages.
 * </p>
 */
public class Kunde {

    private String vorname;
    private String nachname;
    private String adresse;
    private LocalDate geburtstag;

    /**
     * Beispielkunde mit den Standardwerten aus dem parameterlosen Konstruktor.
     */
    public static final Kunde MUSTERMANN = new Kunde();

    /**
     * Erzeugt einen Beispielkunden mit vordefinierten Standardwerten.
     */
    public Kunde() {
        this.vorname = "Max";
        this.nachname = "Mustermann";
        this.adresse = "Kieler Straße 21";
        this.geburtstag = LocalDate.of(1990, 1, 1);
    }

    /**
     * Erzeugt einen Kunden mit den angegebenen Stammdaten.
     *
     * @param vorname der Vorname des Kunden; darf weder {@code null} noch leer sein
     * @param nachname der Nachname des Kunden; darf weder {@code null} noch leer sein
     * @param adresse die Adresse des Kunden; darf weder {@code null} noch leer sein
     * @param geburtstag das Geburtsdatum des Kunden; darf nicht {@code null} sein
     * @throws IllegalArgumentException wenn eine Eingabe ungültig ist
     */
    public Kunde(String vorname, String nachname, String adresse, LocalDate geburtstag) {

        if (vorname == null || vorname.isEmpty()) {
            throw new IllegalArgumentException("Vorname darf nicht null oder leer sein.");
        }
        if (nachname == null || nachname.isEmpty()) {
            throw new IllegalArgumentException("Nachname darf nicht null oder leer sein.");
        }
        if (adresse == null || adresse.isEmpty()) {
            throw new IllegalArgumentException("Adresse darf nicht null oder leer sein.");
        }
        if (geburtstag == null) {
            throw new IllegalArgumentException("Geburtstag darf nicht null sein.");
        }

        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.geburtstag = geburtstag;
    }

    /**
     * Gibt den vollständigen Namen des Kunden zurück.
     *
     * @return Vorname und Nachname in einer Zeichenkette
     */
    public String getName() {
        return this.vorname + " " + this.nachname;
    }

    /**
     * Gibt die gespeicherte Adresse des Kunden zurück.
     *
     * @return die Adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Setzt die Adresse des Kunden neu.
     *
     * @param adresse die neue Adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Gibt das Geburtsdatum des Kunden zurück.
     *
     * @return das Geburtsdatum
     */
    public LocalDate getGeburtstag() {
        return geburtstag;
    }

    /**
     * Berechnet das Alter des Kunden in Jahren.
     *
     * @return das Alter in vollen Jahren
     */
    public int getAlter() {
        LocalDate today = LocalDate.now();
        return Period.between(geburtstag, today).getYears();
    }
}