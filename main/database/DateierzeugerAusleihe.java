package database;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * <h1>Dateierzeuger Ausleihe</h1>
 * <h6>Erstellen von JSON-Dateien für Ausleihe</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.2
 * @since 2026-01-07
 */

public class DateierzeugerAusleihe {
    /**
     * Konstruktor createFileAusleihe
     * @param ausleiheliste
     * @param path
     * @param name
     */
    String path;
    String name;
    List<String[]> ausleiheliste;
    public DateierzeugerAusleihe(List<String[]> ausleiheliste, String path, String name) {
        this.path = path;
        this.ausleiheliste = ausleiheliste;
        this.name = name;
    }
    /**
     * Erstellt JSON Dateien an dem mitgegebenen Pfad mit den mitgegebenen Variablen
     */
    public void createJSON() {
        this.path += "\\" + this.name + ".json";
        try {
            FileWriter myWriter = new FileWriter(this.path);
            myWriter.write("{");
            myWriter.write(System.lineSeparator());
            int amount = 0;
            for (String[] Ausleihe : this.ausleiheliste) {
                amount++;
                myWriter.write("  " + "\""+ Ausleihe[0] + Ausleihe[1] + Ausleihe[2] + "\": {");
                myWriter.write(System.lineSeparator());
                myWriter.write("    " + "\"" + Ausleihe[3] + "\": {");
                myWriter.write(System.lineSeparator());
                myWriter.write("      \"Titel\": " + "\"" + Ausleihe[4] + "\",");
                myWriter.write(System.lineSeparator());
                myWriter.write("      \"Autor\": " + "\"" + Ausleihe[5] + "\",");
                myWriter.write(System.lineSeparator());
                myWriter.write("      \"Genre\": " + "\"" + Ausleihe[6] + "\",");
                myWriter.write(System.lineSeparator());
                myWriter.write("      \"Inventar\": " + "\"" + Ausleihe[7] + "\"");
                myWriter.write(System.lineSeparator());
                myWriter.write("    },");
                myWriter.write(System.lineSeparator());
                myWriter.write("    " + "\"" + Ausleihe[8] + "\": {");
                myWriter.write(System.lineSeparator());
                myWriter.write("      \"Adresse\": " + "\"" + Ausleihe[9] + "\"");
                myWriter.write(System.lineSeparator());
                myWriter.write("    }");
                myWriter.write(System.lineSeparator());
                if (amount < this.ausleiheliste.size()) {
                    myWriter.write("  },");
                    myWriter.write(System.lineSeparator());
                } else {
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