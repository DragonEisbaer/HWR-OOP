package nebensachen;

import nuetzliches.EinAusgabe;
import nuetzliches.Mathematik;

import java.util.Arrays;

public class SiebDesEratosthenes {

    public static void main(String[] args) {
        int x = EinAusgabe.eingabeGanzzahl("Gib eine Zahl für das Sieb des Eratosthenes ein: ");
        System.out.println("Folgende Primzahlen sind kleiner oder gleich " + x + ": " + Arrays.toString(Mathematik.kleinerePrimzahlen(x)));
    }
}
