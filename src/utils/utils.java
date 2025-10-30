package src.utils;

public class utils {
    public static boolean isValidEmail(String email) {
        // Regex base per validazione email
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
