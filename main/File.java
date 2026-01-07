package Personen;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * <h1>Dateileser</h1>
 * <h6>Dateileser für CSV-Dateien</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.0
 */

public class File {
	String path;

	/**
	 * Konstruktor für File
	 *
	 * @param path
	 */
	public File (String path) {
		this.path = path;
	}

	/**
	 * Liest den Inhalt einer CSV-Datei für {@link Person}
	 *
	 * @return
	 */
	public List<String> readFilePerson () {
		List<String> personen = new ArrayList<>();
		 List<String> error = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(this.path))){
			String line;
			while ((line = br.readLine()) != null) {
				personen.add(line);
			}
		} catch (IOException e) {
			System.err.println("Error reading Personen.File!");
			return error;
		}
		return personen;
	}

	/**
	 * Liest den Inhalt einer CSV-Datei für {@link Buch}
	 *
	 * @return CSV-Line
	 */
	public List<String> readFileBuch () {
		List<String> buch = new ArrayList<>();
		List<String> error = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(this.path))){
			String line;
			while ((line = br.readLine()) != null) {
				buch.add(line);
			}
		} catch (IOException e) {
			System.err.println("Error reading file!");
			return error;
		}
		return buch;
	}
}
