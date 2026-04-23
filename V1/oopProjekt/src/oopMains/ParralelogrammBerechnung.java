package oopMains;

import nuetzliches.EinAusgabe;

import java.util.Scanner;

/**
 * Berechnet Eigenschaften eines Parallelogramms anhand zweier Seitenlängen
 * und eines zufällig erzeugten Innenwinkels.
 * <p>
 * Ausgegeben werden:
 * <ul>
 *   <li>Sinus des Winkels</li>
 *   <li>Flächeninhalt</li>
 *   <li>beide Diagonalen</li>
 *   <li>die größere Diagonale</li>
 * </ul>
 *
 * @author brian
 */
public class ParralelogrammBerechnung {

    /**
     * Einstiegspunkt des Programms.
     * <p>
     * Fragt die Seitenlängen {@code a} und {@code b} über die Konsole ab,
     * berechnet anschließend Flächeninhalt und Diagonalen eines Parallelogramms
     * und gibt die Ergebnisse aus.
     *
     * @param args Kommandozeilenargumente (werden in diesem Programm nicht verwendet)
     */
    public static void main(String[] args) {
        EinAusgabe.halloNutzer();
        Scanner tastatur = new Scanner(System.in);

        tastatur.useDelimiter(System.lineSeparator() + "|\n");

        double winkel = EinAusgabe.eingabePositiveKommazahl("Gebe eine positive Kommazahl ein: ", "Die Zahl ist nicht positiv.")*(Math.PI/180);
        int a = EinAusgabe.eingabeGanzzahl("Gebe eine Seitenlänge a ein: ");
        int b = EinAusgabe.eingabeGanzzahl("Gebe eine Seitenlänge b ein: ");

        double sinwinkel = Math.sin(winkel);
        double area = a*b*sinwinkel;
        double diagonale1 = Math.pow(Math.pow(a, 2)+Math.pow(b, 2)-2*a*b*Math.cos(winkel), 0.5);
        double diagonale2 = Math.pow(Math.pow(a, 2)+Math.pow(b, 2)-2*a*b*Math.cos(Math.PI-winkel), 0.5);

        System.out.println("Sinus vom Winkel: " + sinwinkel);
        System.out.println("Flächeninhalt: " + area);
        System.out.println("Diagonale1: " + diagonale1);
        System.out.println("Diagonale2: " + diagonale2);
        System.out.println("Größte Diagonale: " + Math.max(diagonale1,diagonale2));
    }
}