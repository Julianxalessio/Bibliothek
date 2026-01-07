package main;

/**
 * <h1>Ausleihe</h1>
 * <h6>Ausleihe für die der Buch</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.0
 *
 *
 *
 */

public class Ausleihe {
    Buch[] buecher = new Buch[1];
    Person[] personnen = new Person[1];
    String datum;
    public Ausleihe (Buch buch, Person person, String datum){
        this.buecher[0] = buch;
        this.personnen[0] = person;
        this.datum = datum;
    }
}
