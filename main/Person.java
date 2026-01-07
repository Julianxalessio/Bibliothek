package main;
/**
 * <h1>Person</h1>
 * <h6>Personenklasse</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.2
 * @since 2026-01-07
 */
public class Person {
	/**
	 * Konstruktor für Person
	 *
	 * @params name
	 * @params adresse
	 */
	String name;
	String adresse;
	public Person(String name, String adresse) {
		this.name = name;
		this.adresse = adresse;
	}

	/**
	 * Gibt die CSV-Zeile an {@link PersonFunctions} zurück
	 * @return CSV-Line
	 */
	public String toCSVLine() {
		return name + ";" + adresse;
	}

}
