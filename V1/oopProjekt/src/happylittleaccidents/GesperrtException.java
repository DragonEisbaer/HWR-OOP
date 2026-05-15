package happylittleaccidents;

public class GesperrtException extends Exception{

    /**
     * Konstruktor für die Exception, die bei gesperrten Konten geworfen wird.
     * @param kontonummer Kontonummer des gesperrten Kontos, die in der Fehlermeldung ausgegeben wird
     */
    public GesperrtException(long kontonummer) {
        super("Das Konto mit der Nummer " + kontonummer + " ist gesperrt. Operation kann nicht durchgeführt werden.");
    }

    /**
     * Konstruktor für eine benutzerdefinierte Fehlermeldung.
     * Wird in anderen Klassen wie Girokonto und Konto verwendet.
     * @param message die individuelle Fehlermeldung
     */
    public GesperrtException(String message) {
        super(message);
    }

    /**
     * Standard-Konstruktor ohne Parameter mit einer allgemeinen Fehlermeldung.
     */
    public GesperrtException() {
        this("Das Konto ist gesperrt. Operation kann nicht durchgeführt werden.");
    }
}
