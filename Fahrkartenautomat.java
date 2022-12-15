import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		int ticketpreis = 100;

		int zuZahlenderBetrag = 0;
		int eingezahlterGesamtbetrag = 0;
		int eingeworfeneMuenze = 0;
		int rueckgabebetrag = 0;
		int nochZuZahlen = 0;

		// Ticket auswahl
		System.out.print("Ticketpreis (Euro): ");
		ticketpreis = (int) (tastatur.nextDouble() * 100);
		if (ticketpreis < 0) {
			ticketpreis = 1;
			System.out.println("Fehlerhafte Eingabe - Ticketpreis wird auf 1 gesetzt");
		}
		System.out.print("Anzahl der Tickets: ");
		int ticketanzahl = tastatur.nextInt();
		if ((ticketanzahl < 0) || (ticketanzahl > 10)) {
			ticketanzahl = 1;
			System.out.println("Fehlerhafte Eingabe - Ticketanzahl wird auf 1 gesetzt");
		}
		zuZahlenderBetrag = ticketpreis * ticketanzahl;

		// Geldeinwurf
		eingezahlterGesamtbetrag = 0;
		nochZuZahlen = 0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.println("Noch zu zahlen: " + nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingeworfeneMuenze = (int) (tastatur.nextDouble() * 100);
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}

		// Fahrscheinausgabe
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");

		// Rückgeldberechnung und -ausgabe
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0) {
			System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " Euro");
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 200) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 200;
			}
			while (rueckgabebetrag >= 100) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 100;
			}
			while (rueckgabebetrag >= 50) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 50;
			}
			while (rueckgabebetrag >= 20) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 20;
			}
			while (rueckgabebetrag >= 10) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 10;
			}
			while (rueckgabebetrag >= 5) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 5;
			}
			while (rueckgabebetrag >= 2) { // 2-Cent-Münzen
				System.out.println("2 Cent");
				rueckgabebetrag = rueckgabebetrag - 2;
			}
			while (rueckgabebetrag >= 1) { // 1-Cent-Münzen
				System.out.println("1 Cent");
				rueckgabebetrag = rueckgabebetrag - 1;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
}