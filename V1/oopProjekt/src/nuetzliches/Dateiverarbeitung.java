package nuetzliches;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Dateiverarbeitung {

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
