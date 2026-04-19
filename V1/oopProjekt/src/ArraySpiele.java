import java.util.Arrays;
import java.util.Random;

/**
 * Die Klasse {@code ArraySpiele} demonstriert einfache Operationen mit einem Zahlenarray.
 * <p>
 * Dabei werden Werte eingefüllt, zufällige Zahlen erzeugt, das Array sortiert
 * und anschließend eine binäre Suche durchgeführt.
 */
public class ArraySpiele {

    /**
     * Startet das Programm und zeigt verschiedene Array-Operationen in der Konsole.
     *
     * @param args Kommandozeilenargumente, werden nicht verwendet
     */
    public static void main(String[] args) {
        double[] array = new double[10];
        Random random = new Random();

        Arrays.fill(array, 7.7);
        System.out.println(Arrays.toString(array));
        Arrays.setAll(array, i -> random.nextDouble(101));
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        double x = EinAusgabe.eingabePositiveKommazahl("Gib ein Wert im Array zum Suchen ein: ", "Der Wert muss positiv sein.");
        System.out.println("Index von " + x +": " + Arrays.binarySearch(array, x));
    }
}
