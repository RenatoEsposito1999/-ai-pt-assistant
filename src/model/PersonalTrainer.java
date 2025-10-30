package src.model;

public class PersonalTrainer {
    private String email;
    private String username;
    private String password;

    public PersonalTrainer(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail(){return this.email;}
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}

}