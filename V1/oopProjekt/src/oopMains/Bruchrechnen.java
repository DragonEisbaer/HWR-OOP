package oopMains;

import mathematik.Bruch;
import nuetzliches.EinAusgabe;

/**
 * Methoden zur Bruchrechnung
 */
public class Bruchrechnen {
 
    /**
     * Erstellt ein paar Brüche und rechnet damit
     * @param args wird nicht verwendet
     */
	public static void main(String[] args) {
		int z;
		int n;
		Bruch a = null;
		Bruch b = null;
		
		z = EinAusgabe.eingabeGanzzahl("Bitte Zähler des ersten Bruches eingeben: ");
		n = EinAusgabe.eingabeGanzzahl("Bitte Nenner des ersten Bruches eingeben: ");
		a = new Bruch(z, n);

		z = EinAusgabe.eingabeGanzzahl("Bitte Zähler des zweiten Bruches eingeben: ");
		n = EinAusgabe.eingabeGanzzahl("Bitte Nenner des zweiten Bruches eingeben: ");
		b = new Bruch(z, n);
		
		Bruch produkt;
		produkt = a.multiplizieren(b);
		System.out.println(a.getZaehler() + "/" + a.getNenner() + 
				" * " + b.getZaehler() + "/" + b.getNenner() + 
				" = " + produkt.getZaehler() + "/" + produkt.getNenner());
		produkt.kuerzen();
		System.out.println("Gekürzt: " + produkt.getZaehler() + "/" + produkt.getNenner());
		
		Bruch quotient;
		quotient = a.dividieren(b);
		System.out.println(a.getZaehler() + "/" + a.getNenner() + 
				" / " + b.getZaehler() + "/" + b.getNenner() + 
				" = " + quotient.getZaehler() + "/" + quotient.getNenner());	
		quotient.kuerzen();
		System.out.println("Gekürzt: " + quotient.getZaehler() + "/" + quotient.getNenner());
		
	}

}
