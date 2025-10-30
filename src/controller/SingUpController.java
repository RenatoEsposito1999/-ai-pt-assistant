package src.controller;
import src.model.PersonalTrainer;
import src.service.PersonalTrainerService;
import src.view.SingUpView;

public class SingUpController {
    private SingUpView view;
    private NavigationController navigationController;
    private PersonalTrainerService pt_service;
    private PersonalTrainer pt_model;
    public SingUpController(NavigationController navigationController, PersonalTrainerService pt_service){
        this.navigationController = navigationController;
        this.pt_service = pt_service;
        this.view = new SingUpView();
        this.view.getBackButton().setOnAction(_ -> {
            this.navigationController.showLoginView();
        });
        initialize();
    }

    private void initialize(){
        this.view.getSignInButton().setOnAction(_->{
            try {
                if (this.validateInput()){
                    this.pt_model = this.pt_service.register(this.view.getEmailField().getText(), this.view.getUsernameField().getText(), this.view.getPasswordField().getText());
                    view.showSuccess("Registrazione avvenuta con successo!");
                    this.navigationController.showHome(this.pt_model);
                }
            } catch (Exception e) {
                this.view.showError(e.getMessage());
            }
            
            });
        }
    

    public SingUpView getView(){
        return this.view;
    }

    private boolean validateInput(){
        this.view.clearError();
        String email = this.view.getEmailField().getText();
        String username = this.view.getUsernameField().getText();
        String password = this.view.getPasswordField().getText();
        
        if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            this.view.showError("Tutti i campi sono obbligatori");
            return false;
        }

        if (!this.isValidEmail(email)){
            this.view.showError("Formato email non valido");
            return false;
        }

        if (password.length() < 6) {
            this.view.showError("La password deve essere di almeno 6 caratteri");
            return false;
        }


        return true;
        
    }

    private boolean isValidEmail(String email) {
        // Regex base per validazione email
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
