package main;

import java.util.List;
import java.util.Scanner;

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

    public static void createJSONAusleihe(Scanner sc, List<Ausleihe> ausleihListe) {
        System.out.println();
        System.out.print("Dateipfad: ");
        String path = sc.nextLine();
        System.out.print("Dateiname: ");
        String name = sc.nextLine();
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

    public static void newLease(Scanner scSTRING, List<Ausleihe> ausleihListe, List<Person> personenListe, List<Buch> buchListe) {
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
                    Person[] matchPerson = new Person[1];
                    Buch[] matchBuch = new Buch[1];
                    for (Person Person : personenListe) {
                        if (Person.name.equals(kundenName)){
                            matchPerson[0] = Person;
                            break;
                        }
                    }
                    for (Buch Buch : buchListe) {
                        if (Buch.titel.equals(buchName)){
                            matchBuch[0] = Buch;
                            break;
                        }
                    }
                    System.out.println("Ausleihe erfasst!");
                    ausleihListe.add(new Ausleihe(matchBuch[0], matchPerson[0], startLeaseTime));
                }
            }
        }
        System.out.println();
    }
}
