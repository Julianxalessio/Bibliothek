package main;

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
	List<Buch> buchList;

	/**
	 * Konstroktor für DateierzeugerBuch
	 * @param buchList
	 * @param path
	 * @param name
	 */
	public DateierzeugerBuch(List<Buch> buchList, String path, String name) {
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
			for (Buch Buch : this.buchList) {
				amount++;

					myWriter.write("  {");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Titel\": " + "\"" + Buch.titel + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Autor\": " + "\"" + Buch.autor + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"ISBN\": " + "\"" + Buch.ISBN + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Genre\": " + "\"" + Buch.genre + "\",");
					myWriter.write(System.lineSeparator());
					myWriter.write("    \"Anzahl verfügbar\": " + "\"" + Buch.inventar + "\"");
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
