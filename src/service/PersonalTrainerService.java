package src.service;
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
        if (dao.existsByEmail(email)){
            return null;
        }
        else{
            throw new Exception("Email inesistente!");
        }
    }
}
