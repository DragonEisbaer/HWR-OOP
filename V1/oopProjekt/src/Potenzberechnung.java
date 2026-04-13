import java.util.Scanner;

/**
 * Potenzberechnung
 *
 * Berechnet die Potenz einer Zahl.
 *
 * @author brian
 */
public class Potenzberechnung {

    /**
     * Programm nimmt 2 werte von der Konsole entgegen, die erste Zahl ist die Basis, die zweite Zahl ist der Exponent.
     * Berechnet die Potenz der Basis zum Exponent und gibt das Ergebnis auf der Konsole aus.
     * @param args keine Nutzung vorgesehen
     */
    public static void main(String[] args) {
        double x;
        int y;
        double potenz = 1;
        boolean yWarNegativ;
        char nochMal;

        Scanner tastatur = new Scanner(System.in);
        tastatur.useDelimiter(System.lineSeparator() + "|\n");

        System.out.print("Geben Sie die Basis ein: ");
        x = tastatur.nextDouble();

        System.out.print("Geben Sie den Exponenten ein: ");
        y = tastatur.nextInt();

        if (y < 0) {
            yWarNegativ = true;
            y = -y;
        } else {
            yWarNegativ = false;
        }

        for (int i = 1;i<=y;i++) {
            if (i == 1) {
                potenz = x;
            } else {
                potenz = potenz * x;
            }
        }

        if (yWarNegativ) {
            potenz = 1 / potenz;
        }

        System.out.println(x + " hoch " + y + " = " + potenz);
    }
}
