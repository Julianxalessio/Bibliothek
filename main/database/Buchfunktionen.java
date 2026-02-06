import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import main.Datei;
import main.DateierzeugerBuch;


/**<h1>Buchfunktionen</h1>
 *<h6>Funktionen für Buch</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.2
 * @since 2026-01-07
 */

public class Buchfunktionen {
    public static void getCSVBuch(List<String[]> buchListe) {
        System.out.println();
        System.out.println("CSV: ");
        // SQL: Replace buchListe with a SELECT result (mapped to Buch objects).
        for (String[] Buch : buchListe) {
            System.out.println(String.join(",", Buch));
        }
        System.out.println();
    }

    public static void newBuch(Scanner scINT, Scanner scSTRING, List<String[]> buchListe) {
        System.out.println();
        System.out.print("ISBN: ");
        int ISBN = scINT.nextInt();
        if (ISBN == 0) {
            System.err.println("Der Name darf nicht leer sein!");
        } else {
            System.out.print("Titel: ");
            String titel = scSTRING.nextLine();
            if (titel.isEmpty()) {
                System.err.println("Die Adresse darf nicht leer sein!");
            } else {
                System.out.print("Autor: ");
                String autor = scSTRING.nextLine();
                if (autor.isEmpty()) {
                    System.err.println("Die Adresse darf nicht leer sein!");
                } else {
                    System.out.print("Genre: ");
                    String genre = scSTRING.nextLine();
                    if (genre.isEmpty()) {
                        System.err.println("Die Adresse darf nicht leer sein!");
                    } else {
                        System.out.print("Anzahl Verfügbar: ");
                        int inventar = scINT.nextInt();
                        if (inventar == 0) {
                            System.err.println("Die Adresse darf nicht leer sein!");
                        } else {
                            System.out.println("Buch erfasst!");
                            // SQL: INSERT new book record.
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public static void inputCSVBuch(Scanner scSTRING, List<String[]> buchListe) throws IOException {
        System.out.println();
        System.out.print("Dateipfad: ");
        String path = scSTRING.nextLine();
        System.out.print("Trennzeichen: ");
        String zeichen = scSTRING.nextLine();
        Datei file = new Datei(path);
        List<String> lines = file.readFileBuch();
        int amounts = 0;
        for (String line : lines) {
            String[] splitedLine = line.trim().split(zeichen);
            if(splitedLine[0].isEmpty()) {
                break;
            } else {
                String ISBN = splitedLine[3];
                String titel = splitedLine[0];
                String autor = splitedLine[1];
                String genre = splitedLine[2];
                String inventar = splitedLine[4];
                // SQL: INSERT new book record from CSV line.
                amounts++;
            }
        }
        System.out.println("Erfasste "+ amounts + " neue Bücher");
        System.out.println();
    }
    /**
     * Holt den Pfad und den Namen der JSOn-Datei vom User und gibt sie an {@link DateierzeugerBuch} weiter.
     *
     * @param sc
     * @param buchListe
     */
    public static void createJSONBuch(Scanner sc, List<String[]> buchListe) {
        System.out.println();
        System.out.print("Dateipfad: ");
        String path = sc.nextLine();
        System.out.print("Dateiname: ");
        String name = sc.nextLine();
        // SQL: Replace buchListe with a SELECT result (mapped to Buch objects).
        DateierzeugerBuch file = new DateierzeugerBuch(buchListe, path, name);
        file.createJSON();
        System.out.println("JSON wurde erstellt!");
        System.out.println();
    }
}
