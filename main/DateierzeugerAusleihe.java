package main;

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
    List<Ausleihe> ausleiheliste;
    public DateierzeugerAusleihe(List<Ausleihe> ausleiheliste, String path, String name) {
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
            for (Ausleihe Ausleihe : this.ausleiheliste) {
                amount++;
                myWriter.write("  " + "\""+ Ausleihe.datum + Ausleihe.buecher[0].ISBN + Ausleihe.personnen[0].name + "\": {");
                myWriter.write(System.lineSeparator());
                myWriter.write("    " + "\"" + Ausleihe.buecher[0].ISBN + "\": {");
                myWriter.write(System.lineSeparator());
                myWriter.write("      \"Titel\": " + "\"" + Ausleihe.buecher[0].titel + "\",");
                myWriter.write(System.lineSeparator());
                myWriter.write("      \"Autor\": " + "\"" + Ausleihe.buecher[0].autor + "\",");
                myWriter.write(System.lineSeparator());
                myWriter.write("      \"Genre\": " + "\"" + Ausleihe.buecher[0].genre + "\",");
                myWriter.write(System.lineSeparator());
                myWriter.write("      \"Inventar\": " + "\"" + Ausleihe.buecher[0].inventar + "\"");
                myWriter.write(System.lineSeparator());
                myWriter.write("    },");
                myWriter.write(System.lineSeparator());
                myWriter.write("    " + "\"" + Ausleihe.personnen[0].name + "\": {");
                myWriter.write(System.lineSeparator());
                myWriter.write("      \"Adresse\": " + "\"" + Ausleihe.personnen[0].adresse + "\"");
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