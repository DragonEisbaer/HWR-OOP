package happylittleaccidents;

public class UnendlichVieleNullstellenException extends Exception{

    /**
     * Konstruktor für die Exception, die bei unendlich vielen Nullstellen geworfen wird.
     * @param message die Fehlermeldung, die ausgegeben werden soll
     */
    public UnendlichVieleNullstellenException(String message) {
        super(message);
    }

}
