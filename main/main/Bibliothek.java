package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Bibliothek</h1>
 * <h6>Das Startskript mit Befehlen</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.2
 * @since 2026-01-07
 */


public class Bibliothek {
	
	private final static List<Person> personenListe = new ArrayList<>();
	private final static List<Buch> buchListe = new ArrayList<>();
	private  final static List<Ausleihe>  ausleiheListe = new ArrayList<>();
	
	/** 
	 * @param args
	 * @throws IOException
	 */
	public static void main (String[] args) throws IOException {
		Scanner scFLOAT = new Scanner(System.in);
		Scanner scSTRING = new Scanner(System.in);
		Scanner scINT = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.print("Befehl (BUCH, PERSON, AUSLEIHE, EXIT): ");
			String typeCommand = scSTRING.nextLine().toLowerCase();
			if (typeCommand.equals("buch")) {
				System.out.print("Befehl (CSV, NEW, JSON, INPUT, EXIT): ");
				String command = scSTRING.nextLine().toLowerCase();
				switch (command) {
					case "csv" -> Buchfunktionen.getCSVBuch(buchListe);
					case "new" -> Buchfunktionen.newBuch(scINT, scSTRING, buchListe);
					case "input" -> Buchfunktionen.inputCSVBuch(scSTRING, buchListe);
					case "json" -> Buchfunktionen.createJSONBuch(scSTRING, buchListe);
					case "exit" -> doNothing();
					default -> System.err.println("Unbekannter Befehl!");
				}
			} else if (typeCommand.equals("person")) {
				System.out.print("Befehl (CSV, NEW, JSON, INPUT, EXIT): ");
				String command = scSTRING.nextLine().toLowerCase();
				switch (command) {
					case "csv" -> Personenfunktionen.getCSVPerson(personenListe);
					case "new" -> Personenfunktionen.newPerson(scFLOAT, scSTRING, personenListe);
					case "input" -> Personenfunktionen.inputCSVPerson(scSTRING, personenListe);
					case "json" -> Personenfunktionen.createJSONPerson(scSTRING, personenListe);
					case "exit" -> doNothing();
					default -> System.err.println("Unbekannter Befehl!");
				}
			} else if (typeCommand.equals("ausleihe")) {
				System.out.print("Befehl (NEW, JSON, EXIT): ");
				String command = scSTRING.nextLine().toLowerCase();
				switch (command) {
					case "new" -> Ausleihfunktionen.newLease(scSTRING, ausleiheListe, personenListe, buchListe);
					case "json" -> Ausleihfunktionen.createJSONAusleihe(scSTRING, ausleiheListe);
					case "exit" -> doNothing();
					default -> System.err.println("Unbekannter Befehl!");
				}
			}
			else if (typeCommand.equals("exit")) running = false;
			else System.err.println("Unbekannter Befehl!");

		}
		scFLOAT.close();
		scSTRING.close();
	}

	/**
	 * No time to waste!
	 */
	public static void doNothing(){
		int size = 0;
	}
}
