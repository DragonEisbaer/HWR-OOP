package nebensachen;

import nuetzliches.EinAusgabe;
import nuetzliches.Mathematik;

import java.util.Arrays;

/**
 * Startklasse zur Berechnung von Primzahlen mithilfe des Siebs des Eratosthenes.
 * <p>
 * Das Programm liest eine ganze Zahl von der Konsole ein und gibt anschließend
 * alle Primzahlen aus, die kleiner oder gleich dieser Zahl sind.
 * @author brian
 * </p>
 */
public class SiebDesEratosthenes {

    /**
     * Einstiegspunkt des Programms.
     * <p>
     * Fordert den Benutzer zur Eingabe einer ganzen Zahl auf und gibt danach
     * alle Primzahlen aus, die kleiner oder gleich der eingegebenen Zahl sind.
     * Die Berechnung der Primzahlen erfolgt über
     * {@link Mathematik#kleinerePrimzahlen(int)}.
     * </p>
     *
     * @param args Kommandozeilenargumente; werden in diesem Programm nicht verwendet
     */
    public static void main(String[] args) {
        int x = EinAusgabe.eingabeGanzzahl("Gib eine Zahl für das Sieb des Eratosthenes ein: ");
        System.out.println("Folgende Primzahlen sind kleiner oder gleich " + x + ": " + Arrays.toString(Mathematik.kleinerePrimzahlen(x)));
    }
}
