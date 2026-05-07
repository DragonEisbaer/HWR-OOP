package bankprojekt.ausprobieren;

import bankprojekt.Kunde;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Scanner;
import java.util.Locale;

/**
 * Testprogramm für die Klasse Kunde
 */

public class Kundenspielerei {

	/**
	 * Kunde ausprobieren
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {

		Kunde brian = new Kunde("Brian", "Sturmhoevel", "Kieler Straße 21", LocalDate.of(2007, 6, 18));

		@SuppressWarnings("resource")
		Scanner tastatur = new Scanner(System.in);
		tastatur.useDelimiter(System.lineSeparator());
		System.out.println("Der Vorname: ");
		String vorname = tastatur.nextLine();
		System.out.println("Der Nachname: ");
		String nachname = tastatur.nextLine();
		System.out.println("Die Adresse: ");
		String adresse = tastatur.nextLine();
		System.out.println("Der Geburtstag: ");
		String geburtstagEingabe = tastatur.nextLine();
		LocalDate geburtstag;
		try {
			geburtstag = LocalDate.parse(geburtstagEingabe,
					DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN));
		}catch (DateTimeParseException e) {
			System.out.println("Ungültiges Datum. Bitte im Format TT.MM.JJJJ eingeben.");
			return;
		}

		Kunde eingabeKunde = new Kunde(vorname, nachname, adresse, geburtstag);

		System.out.println("Der Kunde heißt: " + eingabeKunde.getName());
		System.out.println("Die Adresse lautet: " + eingabeKunde.getAdresse());
		System.out.println("Das Alter ist: " + eingabeKunde.getAlter());
		System.out.println("Der Name von mir ist: " + brian.getName());
		System.out.println("Meine Adresse lautet: " + brian.getAdresse());
		System.out.println("Max Mustermann name ist: " + Kunde.MUSTERMANN.getName());
		System.out.println("Max Mustermann Adresse lautet: " + Kunde.MUSTERMANN.getAdresse());
		System.out.println("Max Mustermann Alter ist: " + Kunde.MUSTERMANN.getAlter());
	}

}
