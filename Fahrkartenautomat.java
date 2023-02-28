import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		int zuZahlenderBetrag = 0;
		int eingezahlterGesamtbetrag = 0;

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

		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);

		fahrkartenAusgeben();

		rueckgeldAusgeben(zuZahlenderBetrag, eingezahlterGesamtbetrag);

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

		// Fahrkarten
		String[] fahrkarten = { "Einzelfahrschein AB", "Einzelfahrschein BC", "Einzelfahrschein ABC", "Kurzstrecke AB",
				"Tageskarte AB", "Tageskarte BC", "Tageskarte ABC", "4-Fahrten-Karte AB", "4-Fahrten-Karte BC",
				"4-Fahrten-Karte ABC", "Kleingruppen-Tageskarte AB", "Kleingruppen-Tageskarte BC",
				"Kleingruppen-Tageskarte ABC" };
		int[] preise = { 300, 350, 380, 200, 860, 920, 1000, 940, 1260, 1380, 2550, 2600, 2650 };

		System.out.println("Wählen Sie eine Fahrkarte aus:");
		for (int i = 0; i < fahrkarten.length; i++) {
			System.out.printf("%s [%.2f€] (%d)\n", fahrkarten[i], (double) (preise[i] / 100), i);
		}

		int tmpAuswahl = 0;
		while (tmpAuswahl < 1 || tmpAuswahl > fahrkarten.length) {
			System.out.printf("Ihre Auswahl: ");
			tmpAuswahl = tastatur.nextInt();
		}
		int tmpAnzahl = 0;
		while (tmpAnzahl < 1) {
			System.out.printf("Anzahl der Tickets: ");
			tmpAnzahl = tastatur.nextInt();
		}

		zuZahlenderBetrag = preise[--tmpAuswahl] * tmpAnzahl;

		return zuZahlenderBetrag;
	}

	/*
	 * Geldeinwurf
	 */
	private static int fahrkartenBezahlen(Scanner tastatur, int zuZahlenderBetrag) {
		int eingezahlterGesamtbetrag = 0;
		int nochZuZahlen = 0;
		int eingeworfeneMuenze = 0;
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
		return eingezahlterGesamtbetrag;

	}

	private static void fahrkartenAusgeben() {
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

	}

	/*
	 * Rückgeldberechnung und -ausgabe
	 */
	private static void rueckgeldAusgeben(int zuZahlenderBetrag, int eingezahlterGesamtbetrag) {

		int rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;

		System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag / 100 + " Euro");
		System.out.println("wird in folgenden Münzen ausgezahlt: ");

		rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 200, "2-Euro-Münzen");
		rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 100, "1-Euro-Münzen");
		rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 50, "50-Cent-Münzen");
		rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 10, "10-Cent-Münzen");
		rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 5, "5-Cent-Münzen");
	}

	private static int muenzRueckgabe(int rueckgabebetrag, int muenzWert, String muenze) {
		while (rueckgabebetrag >= muenzWert) {

			System.out.println(muenze);

			rueckgabebetrag -= muenzWert;
		}
		return rueckgabebetrag;

	}

}