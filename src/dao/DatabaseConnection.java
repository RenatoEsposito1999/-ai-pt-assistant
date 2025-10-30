package src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:pt_app.db"; // file fisico nella root del progetto
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(URL);
            }
            return connection;
        } catch (Exception e) {
            System.err.println("Errore durante la connessione al database: " + e.getMessage());
            throw new SQLException(e);
        }
        
    }
}



