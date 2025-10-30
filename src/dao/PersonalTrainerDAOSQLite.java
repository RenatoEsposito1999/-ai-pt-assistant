package src.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import src.model.PersonalTrainer;

public class PersonalTrainerDAOSQLite{


    /**public PersonalTrainerDAOSQLite(DatabaseConnection connectionFactory) {
        this.connectionFactory = connectionFactory;
    }*/

    public void save(PersonalTrainer pt) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection()) { // connessione locale
            String sql = "INSERT INTO personal_trainer (email, username, password) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, pt.getEmail());
                stmt.setString(2, pt.getUsername());
                stmt.setString(3, pt.getPassword());
                stmt.executeUpdate();
            }
        }
    }

    public boolean existsByEmail(String email) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT email FROM personal_trainer WHERE email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
        }
    }

    public Map<String, String> getCredentials(String email, String password) throws SQLException {
        Map<String, String> credentials = new HashMap<>();
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT email, password FROM personal_trainer WHERE email = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, password);
                
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    credentials.put("email", rs.getString("email"));
                    credentials.put("password", rs.getString("password"));
                }
            }
        }
        return credentials;
    }
    
}
