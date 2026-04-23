package nebensachen;

import nuetzliches.EinAusgabe;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Kleines Konsolenprogramm zum Ausprobieren von Datumsfunktionen.
 * <p>
 * Die Klasse zeigt unter anderem die aktuelle Systemzeit, verschieden
 * lokalisierte Datumsformate und den aktuellen Wochentag an.
 * </p>
 */
public class DatumSpielerein {

    /**
     * Einstiegspunkt des Programms.
     * <p>
     * Gibt das heutige Datum in verschiedenen Formaten aus und ermittelt
     * anschließend den aktuellen Wochentag. Falls heute Samstag oder Sonntag ist,
     * wird zusätzlich eine entsprechende Meldung ausgegeben.
     * </p>
     *
     * @param args Kommandozeilenargumente; werden in diesem Programm nicht verwendet
     */
    public static void main(String[] args) {
        LocalDate datum = LocalDate.now();
        System.out.println(datum);
        System.out.println(EinAusgabe.datumFormatieren(datum));
        System.out.println("TW: " + EinAusgabe.datumFormatieren(datum, Locale.TAIWAN));
        System.out.println("US: " + EinAusgabe.datumFormatieren(datum, Locale.US));
        System.out.println("IT: " + EinAusgabe.datumFormatieren(datum, Locale.ITALIAN));

        DayOfWeek wochentag = datum.getDayOfWeek();
        System.out.println("Heute ist " + wochentag + "!");
        if (wochentag == DayOfWeek.SUNDAY || wochentag == DayOfWeek.SATURDAY) {
            System.out.println("Heute wird nicht gearbeitet, es ist " + wochentag.getDisplayName(TextStyle.FULL, Locale.getDefault()) + "!");
        }
        LocalDate weihnachten = LocalDate.of(datum.getYear(), 12, 24);
        System.out.println(abstand(datum, weihnachten) + " Tage bis Weihnachten!");
    }

    /**
     * Berechnet den Abstand zwischen zwei Datumsangaben.
     *
     * @param von das Startdatum
     * @param bis das Enddatum
     * @return der Abstand zwischen beiden Daten als Anzahl von Tagen; aktuell noch nicht implementiert
     */
    public static long abstand(LocalDate von, LocalDate bis) {
        return ChronoUnit.DAYS.between(von, bis);
    }
}
