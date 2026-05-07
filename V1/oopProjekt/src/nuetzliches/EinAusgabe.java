package nuetzliches;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
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
        System.out.print(aufforderung);
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

    /**
     * Liest eine Kommazahl von der Konsole ein.
     * <p>
     * Vor der Eingabe wird der übergebene Text als Aufforderung ausgegeben.
     * Der Rückgabewert ist größer als {@code 0}.
     *
     * @param aufforderung Text, der dem Benutzer vor der Eingabe angezeigt wird
     * @return die eingegebene Kommazahl
     */
    public static double eingabeKommazahl(String aufforderung) {
        System.out.println(aufforderung);
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.lineSeparator() + "|\n");
        return scanner.nextDouble();
    }

    /**
     * Liest eine {@link BigInteger}-Zahl von der Konsole ein.
     * <p>
     * Vor der Eingabe wird der übergebene Text als Aufforderung ausgegeben.
     *
     * @param aufforderung Text, der dem Benutzer vor der Eingabe angezeigt wird
     * @return die vom Benutzer eingegebene {@link BigInteger}-Zahl
     */
    public static BigInteger eingabeBigInteger(String aufforderung) {
        System.out.print(aufforderung);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextBigInteger();
    }

    /**
     * Formatiert ein Datum in eine lesbare, lokalisierte Darstellung.
     *
     * @param datum das zu formatierende Datum
     * @return das formatierte Datum als String
     */
    public static String datumFormatieren(LocalDate datum){
        return datum.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
    }

    /**
     * Formatiert ein Datum in eine lesbare, lokalisierte Darstellung.
     * <p>
     * Verwendet das Datumsformat {@link FormatStyle#FULL} mit der angegebenen
     * {@link Locale}.
     * </p>
     *
     * @param datum das zu formatierende Datum
     * @param locale die gewünschte Locale für die Darstellung
     * @return das formatierte Datum als String
     */
    public static String datumFormatieren(LocalDate datum, Locale locale){
        return datum.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale));
    }

    /**
     * Gibt eine freundliche Begrüßung mit dem aktuellen Benutzernamen aus.
     * <p>
     * Der Name des aktuell angemeldeten Systemsutzers wird über
     * {@link System#getProperty(String)} mit dem Schlüssel {@code user.name}
     * ermittelt.
     * </p>
     */
    public static void halloNutzer(){
        System.out.println("Hallo, " + System.getProperty("user.name") + "!");
    }

    /**
     * Liest einen Dateinamen oder Pfad von der Konsole ein.
     * <p>
     * Vor der Eingabe wird der übergebene Text als Aufforderung ausgegeben.
     * Die Eingabe wird unverändert als String zurückgegeben.
     * </p>
     *
     * @param aufforderung Text, der dem Benutzer vor der Eingabe angezeigt wird
     * @return der vom Benutzer eingegebene Dateiname oder Pfad
     */
    public static String eingabeDateiname(String aufforderung){
        System.out.print(aufforderung);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
