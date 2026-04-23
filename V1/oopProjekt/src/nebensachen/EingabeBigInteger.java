package nebensachen;

import nuetzliches.EinAusgabe;
import java.math.BigInteger;

/**
 * Konsolenprogramm zum Einlesen einer {@link BigInteger}-Zahl und zur Ausgabe
 * ihrer Binärdarstellung.
 * <p>
 * Für negative Zahlen wird die Darstellung vor der Ausgabe entsprechend
 * umgewandelt.
 * </p>
 */
public class EingabeBigInteger {

    /**
     * Einstiegspunkt des Programms.
     * <p>
     * Fragt den Benutzer nach einer {@link BigInteger}-Zahl und gibt diese
     * anschließend in Binärdarstellung auf der Konsole aus.
     * Für negative Zahlen erfolgt vorher eine Umwandlung, damit die Ausgabe
     * passend dargestellt wird.
     * </p>
     *
     * @param args Kommandozeilenargumente (werden in diesem Programm nicht verwendet)
     */
    public static void main(String[] args) {
        BigInteger zahl = EinAusgabe.eingabeBigInteger("Gebe eine BigInteger-Zahl ein: ");
        String binary = zahl.toString(2);
        if (zahl.compareTo(BigInteger.ZERO) < 0) {
            int laenge = zahl.bitLength();
            for (int i = 0; i < laenge+1; i++) {
                zahl = zahl.flipBit(i);
            }
            zahl = zahl.add(BigInteger.ONE);
            System.out.println(zahl.toString(2));
        }else {
            System.out.println(binary);
        }
    }
}
