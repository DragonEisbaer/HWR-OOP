package happylittleaccidents;

public class GesperrtException extends Exception{

    /**
     * Konstruktor für die Exception, die bei gesperrten Konten geworfen wird.
     * @param message die Fehlermeldung, die ausgegeben werden soll
     */
    public GesperrtException(String message) {
        super(message);
    }
}
