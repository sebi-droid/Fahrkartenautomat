import java.util.Scanner;// Um die Scanner-Klasse zu verwenden, muss diese importiert werden

public class ScannerDemo {

	public static void main(String[] args) {

		int ganzzahl = 0;
		double kommazahl = 0.0;
		String wort = "";
		boolean wahrheitswert = false;
		char buchstabe = ' ';

		Scanner tastatur = new Scanner(System.in); // Erzeugen eines Objekts der Klasse Scanner

		System.out.print("Bitte geben Sie eine ganze Zahl ein: ");
		System.out.print("Sie haben " + ganzzahl + " eingegeben!\n\n");

		System.out.print("Bitte geben Sie eine Zahl mit Nachkommastellen ein: ");
		System.out.print("Sie haben " + kommazahl + " eingegeben!\n\n");

		System.out.print("Bitte geben Sie eine Wort ein : ");
		System.out.print("Sie haben '" + wort + "' eingegeben!\n\n");

		System.out.print("Bitte geben Sie einen Wahrheitswert ein (true / false): ");
		System.out.print("Sie haben '" + wahrheitswert + "' eingegeben!\n\n");

		System.out.print("Bitte geben Sie einen einzelnen Buchstaben ein: ");
		System.out.print("Sie haben '" + buchstabe + "' eingegeben!\n");

		tastatur.close();
	}
}
