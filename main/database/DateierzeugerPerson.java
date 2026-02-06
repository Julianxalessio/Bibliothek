
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * <h1>Dateierzeuger Person</h1>
 * <h6>Erstellen von JSON-Dateien für Personen</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.2
 * @since 2026-01-07
 */


public class DateierzeugerPerson {
	/**
	 * Konstroktor für DateierzeugerPerson
	 * @param personenListe
	 * @param path
	 * @param name
	 */
	String path;
	String name;
	List<String[]> personenListe;
	public DateierzeugerPerson(List<String[]> personenListe, String path, String name) {
		this.path = path;
		this.name = name;
		this.personenListe = personenListe;
	}

	/**
	 * Erstellt JSON Dateien an dem mitgegebenen Pfad mit den mitgegebenen Variablen
	 */
	public void createJSON() {
		path += "\\" + this.name + ".json";
		try	{
			FileWriter myWriter = new FileWriter(this.path);
			myWriter.write("[");
			myWriter.write(System.lineSeparator());
			int amount = 0;
			for (String[] person : this.personenListe) {
				amount++;
				if (amount < this.personenListe.size()) {
					myWriter.write("  {");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Name\": " + "\"" + person[0] + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Adresse\": " + "\"" + person[1] + "\"");
					myWriter.write(System.lineSeparator());
					myWriter.write("  },");
					myWriter.write(System.lineSeparator());
					
				} else {
					myWriter.write("  {");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Name\": " + "\"" + person[0] + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Adresse\": " + "\"" + person[1] + "\"");
					myWriter.write(System.lineSeparator());
					myWriter.write("  }");
					myWriter.write(System.lineSeparator());
				}

			}
			myWriter.write("]");
			
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
