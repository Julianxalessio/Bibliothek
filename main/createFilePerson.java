package Personen;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * <h1>Filecreator Person</h1>
 * <h6>Erstellen von JSON-Dateien für Personen</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.0
 */


public class createFilePerson {
	/**
	 * Konstroktor für createFilePerson
	 * @param personenListe
	 * @param path
	 * @param name
	 */
	String path;
	String name;
	List<Person> personenListe;
	public createFilePerson(List<Person> personenListe, String path, String name) {
		this.path = path;
		this.personenListe = personenListe;
		this.name = name;
	}

	/**
	 * Erstellt JSON Dateien an dem mitgegebenen Pfad mit dem mitgegebenem Name
	 */
	public void createJSON() {
		path += "\\" + this.name + ".json";
		try	{
			FileWriter myWriter = new FileWriter(this.path);
			myWriter.write("{");
			myWriter.write(System.lineSeparator());
			int amount = 0;
			for (Person person : this.personenListe) {
				amount++;
				if (amount < this.personenListe.size()) {
					myWriter.write("  {");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Name\": " + "\"" + person.name + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Adresse\": " + "\"" + person.adresse + "\"");
					myWriter.write(System.lineSeparator());
					myWriter.write("  },");
					myWriter.write(System.lineSeparator());
					
				} else {
					myWriter.write("  {");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Name\": " + "\"" + person.name + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Adresse\": " + "\"" + person.adresse + "\"");
					myWriter.write(System.lineSeparator());
					myWriter.write("  }");
					myWriter.write(System.lineSeparator());
				}

			}
			myWriter.write("}");
			
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
