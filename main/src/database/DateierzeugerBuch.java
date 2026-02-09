package src.database;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * <h1>Dateierzeuger Buch</h1>
 * <h6>Erstellen von JSON-Dateien für Buch</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.2
 * @since 2026-01-07
 */

public class DateierzeugerBuch {
	String path;
	String name;
	List<String[]> buchList;

	/**
	 * Konstroktor für DateierzeugerBuch
	 * @param buchList
	 * @param path
	 * @param name
	 */
	public DateierzeugerBuch(List<String[]> buchList, String path, String name) {
		this.path = path;
		this.buchList = buchList;
		this.name = name;
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
			for (String[] Buch : this.buchList) {
				amount++;

					myWriter.write("  {");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Titel\": " + "\"" + Buch[0] + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Autor\": " + "\"" + Buch[1] + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"ISBN\": " + "\"" + Buch[2] + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Genre\": " + "\"" + Buch[3] + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Anzahl verfügbar\": " + "\"" + Buch[4] + "\"");
				if (amount < this.buchList.size()) {
					myWriter.write("  },");
					myWriter.write(System.lineSeparator());
					
				} else {
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
