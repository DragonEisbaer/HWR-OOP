import java.util.Scanner;

public class EinAusgabe {
    /**
     * Liest eine Ganzzahl von der Konsole ein.
     * <p>
     * Vor der Eingabe wird der übergebene Text als Aufforderung ausgegeben.
     *
     * @param aufforderung Text, der dem Benutzer vor der Eingabe angezeigt wird
     * @return die vom Benutzer eingegebene Ganzzahl
     */
    public static int eingabeGanzzahl(String aufforderung){
        System.out.println(aufforderung);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    /**
     * Liest eine positive Kommazahl von der Konsole ein.
     * <p>
     * Vor der Eingabe wird der übergebene Text als Aufforderung ausgegeben.
     * Der Rückgabewert ist größer als {@code 0}.
     *
     * @param aufforderung Text, der dem Benutzer vor der Eingabe angezeigt wird
     * @return die eingegebene positive Kommazahl
     */
    public static double eingabePositiveKommazahl(String aufforderung, String fehlermeldung) {
        System.out.println(aufforderung);
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.lineSeparator() + "|\n");
        double wert = scanner.nextDouble();
        if (wert < 0){
            System.out.println(fehlermeldung);
            return 0;
        }
        return wert;
    }

    public static void halloNutzer(){
        System.out.println("Hallo, " + System.getProperty("user.name") + "!");
    }
}
