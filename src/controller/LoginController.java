package src.controller;

import src.model.PersonalTrainer;
import src.service.PersonalTrainerService;
import src.view.LoginView;

public class LoginController {
    private LoginView loginView;
    private NavigationController navigationController;
    private PersonalTrainerService pt_service;

    public LoginController(NavigationController navigationController, PersonalTrainerService pt_service) {
        this.navigationController = navigationController;
        this.pt_service = pt_service;
        this.loginView = new LoginView();
        initialize();
    }

    private void initialize() {
        loginView.getLoginButton().setOnAction(_ -> {
            String email = loginView.getEmailField().getText();
            String password = loginView.getPasswordField().getText();

            if (email.isEmpty() || password.isEmpty()) {
                loginView.getErrorLabel().setText("Per favore, compila tutti i campi.");
                return;
            }
            else {
                try {
                    PersonalTrainer _ = this.pt_service.authenticate(email,password);
                } catch (Exception e) {
                    this.loginView.getErrorLabel().setText(e.getMessage());
                }
            }


            // Esempio dummy (logica reale andrà nel Service)
            /**if (username.equals("admin") && password.equals("1234")) {
                loginView.getResultLabel().setText("Login riuscito!");
                navigationController.showDashboard(); // Naviga a un'altra vista
            } else {
                loginView.getResultLabel().setText("Credenziali errate");
            }*/
        });

        loginView.getSigninButton().setOnAction(_->{
            this.navigationController.showSingIn();
        });

    }

    public LoginView getView() {
        return loginView;
    }
}
