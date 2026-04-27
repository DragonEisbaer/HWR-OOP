package nuetzliches;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Stellt einfache Methoden zur Dateiverarbeitung bereit.
 * <p>
 * Die Klasse ermöglicht das Kopieren von Dateien sowie das rekursive Ausgeben
 * eines Verzeichnisbaums. Über die {@link #main(String[])}-Methode können diese
 * Funktionen interaktiv über die Konsole verwendet werden.
 * </p>
 */
public class Dateiverarbeitung {

    /**
     * Startpunkt des Programms.
     * <p>
     * Fragt den Benutzer nach einem Quell- und einem Zieldateinamen, kopiert die
     * Quelldatei in die Zieldatei und fragt anschließend, ob die Zieldatei wieder
     * gelöscht werden soll. Danach wird ein Verzeichnis abgefragt, dessen Dateien
     * rekursiv ausgegeben werden.
     * </p>
     *
     * @param args Kommandozeilenargumente; werden in diesem Programm nicht verwendet
     * @throws Exception wenn beim Kopieren oder bei Dateioperationen ein Fehler auftritt
     */
    public static void main(String[] args) throws Exception {
        String quellname = EinAusgabe.eingabeDateiname("Gebe einen Quelldateinamen ein: ");
        String zielname = EinAusgabe.eingabeDateiname("Gebe einen Zieldateinamen ein: ");

        kopieren(quellname, zielname);

        System.out.println("Wieder löschen?");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("ja")) {
            File file = new File(zielname);
            if (file.delete()) {
                System.out.println("Gelöscht!");
            }else {
                System.out.println("Fehler beim Löschen!");
            }
        }
        System.out.println("Verzeichnis eingeben: ");
        dateibaum(scanner.nextLine());
    }

    /**
     * Kopiert den Inhalt einer Quelldatei in eine Zieldatei.
     * <p>
     * Falls die Zieldatei bereits existiert, wird eine Meldung ausgegeben und
     * versucht, die Datei umzubenennen. Anschließend wird der Inhalt der
     * Quelldatei in die Zieldatei übertragen.
     * </p>
     *
     * @param quellname Name oder Pfad der Datei, aus der gelesen werden soll
     * @param zielname Name oder Pfad der Datei, in die geschrieben werden soll
     * @throws Exception wenn die Quelldatei nicht gelesen, die Zieldatei nicht geschrieben
     *                   oder eine Dateioperation nicht durchgeführt werden kann
     */
    public static void kopieren(String quellname, String zielname) throws Exception {
        FileReader quellDatei = new FileReader(quellname);
        FileWriter zielDatei = new FileWriter(zielname);

        File file = new File(zielname);

        if (!file.createNewFile()) {
            System.out.println("Datei schon vorhanden: " + quellname);
            System.out.println("Bennene um...");
            if (file.renameTo(new File(quellname + "-alt"))) {
                System.out.println("Umbenannt!");
            }else {
                System.out.println("Fehler beim Umbenennen!");
            }
        }

        quellDatei.transferTo(zielDatei);

        quellDatei.close();
        zielDatei.close();
    }
/**
     * Gibt alle Dateien innerhalb eines Verzeichnisses rekursiv auf der Konsole aus.
     * <p>
     * Wird ein Unterverzeichnis gefunden, wird dieses ebenfalls durchsucht.
     * Ist der übergebene Pfad kein Verzeichnis, wird eine entsprechende Meldung
     * ausgegeben.
     * </p>
     *
     * @param verzeichnisname Name oder Pfad des Verzeichnisses, dessen Dateien ausgegeben werden sollen
     */
    public static void dateibaum(String verzeichnisname) {
            File verzeichnis = new File(verzeichnisname);
            if (verzeichnis.isDirectory()) {
                for (File datei : verzeichnis.listFiles()) {
                    if (datei.isDirectory()) {
                        dateibaum(datei.getPath());
                    }else {
                        System.out.println("Datei: " + datei.getName());
                    }
                }
            }else {
                System.out.println("Kein Verzeichnis: " + verzeichnisname);
            }
    }
}
