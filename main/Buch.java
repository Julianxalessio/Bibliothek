package Personen;
/**
 * <h1>Buch</h1>
 * <h6>Buchklasse</h6>
 * @author Zwahlen Diego und Lombardo Julian
 * @version 1.0
 */
public class Buch {
    /**
     * Konstruktor für Buch
     * @param titel
     * @param autor
     * @param genre
     * @param ISBN
     * @param inventar
     */
    String titel;
    String autor;
    String genre;
    String ISBN;
    String inventar;

    /**
     * @param titel
     * @param autor
     * @param genre
     * @param ISBN
     * @param inventar
     */

    public Buch(String titel, String autor, String genre, String ISBN, String inventar){
        this.titel = titel;
        this.autor = autor;
        this.genre = genre;
        this.ISBN = ISBN;
        this.inventar = inventar;
    }
    /**
     * Liest den Inhalt einer CSV-Datei für {@link Buch}
     *
     * @return CSV-Line
     */
    public String toCSVLine() {
        return  titel + ";" + autor + ";" + genre + ";" +ISBN + ";"+ inventar;
    }
}
