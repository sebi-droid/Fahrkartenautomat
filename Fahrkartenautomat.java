import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		int zuZahlenderBetrag = 0;
		int eingezahlterGesamtbetrag = 0;
		int eingeworfeneMuenze = 0;
		int rueckgabebetrag = 0;
		int nochZuZahlen = 0;

		begruessung();

		// Ticket
		zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);

		System.out.printf("\n\nZwischensumme: %.2f €\n\n", (double) (zuZahlenderBetrag / 100));

		if (!(zuZahlenderBetrag > 0))

		{
			System.out.println("Nichts zu zahlen!");
			tastatur.close();
			return;
		}

		// Geldeinwurf
		eingezahlterGesamtbetrag = 0;
		nochZuZahlen = 0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f€\n", (double) (nochZuZahlen / 100));
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingeworfeneMuenze = (int) (tastatur.nextDouble() * 100);

			// Pfüfung
			switch (eingeworfeneMuenze) {
			case 5:
				break;
			case 10:
				break;
			case 20:
				break;
			case 50:
				break;
			case 500:
				break;
			case 100:
				break;
			case 200:
				break;
			case 1000:
				break;
			case 2000:
				break;
			default:
				System.out.println(">>> Keine gültiges Zahlungsmittel");
				eingeworfeneMuenze = 0;
				break;
			}

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
			System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag / 100 + " Euro");
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

	private static void begruessung() {
		System.out.printf("Herzlich Willkommen!\n\n");
	}

	/*
	 * Kartenauswahl und Ticketanzahl
	 */
	public static int fahrkartenbestellungErfassen(Scanner tastatur) {
		int zuZahlenderBetrag = 0;
		int ticketpreis = 100;

		// Fahrkarten
		final int kurzAB = 200;
		final int einzelAB = 300;
		final int tagesAB = 880;
		final int vierAB = 940;

		System.out.printf("Fahrkartenbestellvorgang:\n=========================\n");
		boolean weitereBestellung = true;
		while (weitereBestellung) {

			int wahl = 0;
			while (wahl < 1 || wahl > 4) {
				System.out.printf("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:\n");
				System.out.printf("Kurzstrecke AB [%.2f EUR] (1)\n", (double) (kurzAB / 100));
				System.out.printf("Einzelfahrschein AB [%.2f EUR] (2)\n", (double) (einzelAB / 100));
				System.out.printf("Tageskarte AB [%.2f EUR] (3)\n", (double) (tagesAB / 100));
				System.out.printf("4-Fahrten-Karte AB [%.2f EUR] (4)\n\n", (double) (vierAB / 100));
				System.out.print("Ihre Wahl: ");

				wahl = tastatur.nextInt();

				if (wahl == 9) {
					weitereBestellung = false;
					break;
				}

				if (wahl < 1 || wahl > 4) {
					System.out.println(">>falsche Eingabe<<");
				}

			}
			if (wahl == 9) {
				break;
			}

			switch (wahl) {
			case 1:
				ticketpreis = kurzAB;
				break;
			case 2:
				ticketpreis = einzelAB;
				break;
			case 3:
				ticketpreis = tagesAB;
				break;
			case 4:
				ticketpreis = vierAB;
				break;
			default:
				break;
			}

			System.out.print("Anzahl der Tickets: ");
			int ticketanzahl = tastatur.nextInt();
			while ((ticketanzahl < 1) || (ticketanzahl > 10)) {
				System.out.println(">> Wählen Sie bitte eine Anzahl von 1 bis 10 Tickets aus.");
				System.out.print("Anzahl der Tickets: ");
				ticketanzahl = tastatur.nextInt();
			}

			zuZahlenderBetrag += ticketpreis * ticketanzahl;

		}
		return zuZahlenderBetrag;
	}
}