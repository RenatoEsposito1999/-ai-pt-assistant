package src.dao;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS personal_trainer (" +
                         "email TEXT PRIMARY KEY," +
                         "username TEXT NOT NULL," +
                         "password TEXT NOT NULL" +
                         ");";
            stmt.execute(sql);
            System.out.println("Tabella creata o già esistente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



