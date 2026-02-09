package src.database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SQLFunktionen {
    Connection conn;

    public SQLFunktionen() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Verbindung herstellen
            String url = "jdbc:mysql://localhost:3306/bibliothek_aprentas";
            String user = "root";
            String password = "";

            this.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String[]> getAusleihListe() throws SQLException {
            List<String[]> ausleihListe = new ArrayList<>();
            // SQL ausführen
            Statement stmt = conn.createStatement();

            //stmt.executeUpdate("INSERT INTO kunden (name) VALUES ('Max')");
            //stmt.executeUpdate("UPDATE kunden SET name='Moritz' WHERE id=1");

            ResultSet rs = stmt.executeQuery("SELECT * FROM ausleihe");

            // Ergebnisse ausgeben
            while (rs.next()) {
                System.out.println(
                    "Datum: " + rs.getTimestamp("ausleihdatum") +
                    ", idPerson: " + rs.getInt("person_id") +
                    ", idBuch: " + rs.getInt("buch_id")
                );
                ausleihListe.add(new String[]{String.valueOf(rs.getInt("person_id")), String.valueOf(rs.getInt("buch_id")), rs.getString("ausleihdatum")});
            }
            // Aufräumen
            rs.close();
            stmt.close();
            conn.close();
            return ausleihListe;
    }
}