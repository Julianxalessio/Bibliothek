package main;

import java.util.List;
import java.util.Scanner;

/**<h1>Personenfunktionen</h1>
 *<h6>Funktionen für Personen</h6>
 *
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.0
 */

public class PersonFunctions {

    /**
     * Erstellt eine neue {@link Person} und fügt sie zur Personenliste hinzu.
     *
     * @param scFLOAT
     * @param scSTRING
     * @param personenListe
     */
    public static void newPerson(Scanner scFLOAT, Scanner scSTRING, List<Person> personenListe) {
        System.out.println();
        System.out.print("Name: ");
        String name = scSTRING.nextLine();
        if (name.isEmpty()) {
            System.err.println("Der Name darf nicht leer sein!");
        } else {
            System.out.print("Adresse: ");
            String adresse = scSTRING.nextLine();
            if (adresse.isEmpty()) {
                System.err.println("Die Adresse darf nicht leer sein!");
            } else {
                System.out.println("Person erfasst!");
                personenListe.add(new Person(name, adresse));
            }
        }
        System.out.println();
    }

    /**
     * Gibt die Personen im CSV-Format aus.
     *
     * @param personenListe
     */

    public static void getCSVPerson(List<Person> personenListe) {
        System.out.println();
        System.out.println("CSV: ");
        for (Person Person : personenListe) {
            System.out.println(Person.toCSVLine());
        }
        System.out.println();
    }

    /**
     * Holt den Pfad und den Namen der JSOn-Datei vom User und gibt sie an {@link createFilePerson} weiter.
     *
     * @param sc
     * @param personenListe
     */

    public static void createJSONPerson(Scanner sc, List<Person> personenListe) {
        System.out.print("Dateipfad: ");
        String path = sc.nextLine();
        System.out.print("Dateiname: ");
        String name = sc.nextLine();
        createFilePerson file = new createFilePerson(personenListe, path, name);
        file.createJSON();
        System.out.println("JSON wurde erstellt!");
        System.out.println();
    }

    /**
     * Holt den Pfad und das Trennzeichen der CSV-Datei vom user und gibt diese an {@link File} weiter.
     *
     * @param scSTRING
     * @param personenListe
     */

    public static void inputCSVPerson(Scanner scSTRING, List<Person> personenListe) {
        System.out.println();
        System.out.print("Dateipfad: ");
        String path = scSTRING.nextLine();
        System.out.print("Trennzeichen: ");
        String zeichen = scSTRING.nextLine();
        File file = new File(path);
        List <String> lines = file.readFilePerson();
        int amounts = 0;
        for (String line : lines) {
            String[] splitedLine = line.trim().split(zeichen);
            if(splitedLine[0].isEmpty()) {

            } else {
                String name = splitedLine[0];
                String adresse = splitedLine[1];
                personenListe.add(new Person(name, adresse));
                amounts++;
            }
        }
        System.out.println("Erfasste "+ amounts + " neue Personen");
        System.out.println();
    }
}
