
import java.util.List;
import java.util.Scanner;

import database.DateierzeugerAusleihe;


/**
 * <h1>Ausleihfunktionen</h1>
 * <h6>Funktionen für Ausleihe</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.2
 * @since 2026-01-07
 */


public class Ausleihfunktionen {

    /**
     * Aus der {@link Ausleihe} eine JSON-Datei erstellen
     *
     * @param sc
     * @param ausleihListe
     */

    public static void createJSONAusleihe(Scanner sc, List<String[]> ausleihListe) {
        System.out.println();
        System.out.print("Dateipfad: ");
        String path = sc.nextLine();
        System.out.print("Dateiname: ");
        String name = sc.nextLine();
        // SQL: Replace ausleihListe with a SELECT result (mapped to Ausleihe objects).
        DateierzeugerAusleihe file = new DateierzeugerAusleihe(ausleihListe, path, name);
        file.createJSON();
        System.out.println("JSON wurde erstellt!");
        System.out.println();
    }

    /**
     * Neue {@link Ausleihe} erstellen
     *
     * @param scSTRING
     * @param ausleihListe
     * @param personenListe
     * @param buchListe
     */

    public static void newLease(Scanner scSTRING, List<String[]> ausleihListe, List<String[]> personenListe, List<String[]> buchListe) {
        System.out.println();
        System.out.print("Name des Kunden: ");
        String kundenName = scSTRING.nextLine();
        if (kundenName.isEmpty()) {
            System.err.println("Der Name ist nicht im System registriert! Bitte versuchen Sie es erneut!");
        } else {
            System.out.print("Name des Buches: ");
            String buchName = scSTRING.nextLine();
            if (buchName.isEmpty()) {
                System.err.println("Dieses Buch ist nicht in der Datenbank registriert! Bitte versuchen Sie es erneut!");
            } else {
                System.out.print("Startdatum der Ausleihe: ");
                String startLeaseTime = scSTRING.nextLine();
                if (startLeaseTime.isEmpty()) {
                    System.err.println("Das Startdatum muss ausgefüllt werden! Bitte versuchen Sie es erneut!");
                } else {
                    String[] matchPerson = new String[1];
                    String[] matchBuch = new String[1];
                    // SQL: Replace list lookups with SELECTs for the matching person and book.
                    for (String[] Person : personenListe) {
                        if (Person[0].equals(kundenName)){    
                            matchPerson[0] = Person[0];
                            break;
                        }
                    }
                    for (String[] Buch : buchListe) {
                        if (Buch[0].equals(buchName)){
                            matchBuch[0] = Buch[0];
                            break;
                        }
                    }
                    System.out.println("Ausleihe erfasst!");
                    // SQL: INSERT new loan record.
                    ausleihListe.add(new String[]{matchBuch[0], matchPerson[0], startLeaseTime});
                }
            }
        }
        System.out.println();
    }
}
