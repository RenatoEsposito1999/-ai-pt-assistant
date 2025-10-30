package src.service;
import java.util.Map;

import src.dao.PersonalTrainerDAOSQLite;
import src.model.PersonalTrainer;
public class PersonalTrainerService {
    private PersonalTrainerDAOSQLite dao;

    public PersonalTrainerService(PersonalTrainerDAOSQLite dao){
        this.dao = dao;
    }

    public PersonalTrainer register(String email, String username, String password) throws Exception {
        if (dao.existsByEmail(email)) {
            throw new Exception("Email già registrata!");
        }
        PersonalTrainer pt = new PersonalTrainer(email, username, password);
        dao.save(pt);
        return pt;
    }

    public PersonalTrainer authenticate(String email, String password) throws Exception {
        Map<String, String> credentials = this.dao.getCredentials(email, password);
        if (credentials.isEmpty()) {
            throw new Exception("Credenziali non valide");
        }
        else {
            return new PersonalTrainer(
                credentials.get("email"),
                credentials.get("username"),
                credentials.get("password")
            );
        }
    }
    // Valida credenziali e ritorna le credenziali del pt o null se non sono valide, nel caso del null lancio un eccezione ma creo due metodi per capire se il problema è l'email o pw.
}
