package src.controller;

import src.model.PersonalTrainer;
import src.service.PersonalTrainerService;
import src.view.LoginView;
import src.utils.*;
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
            if (!utils.isValidEmail(email)){
                this.loginView.getErrorLabel().setText("Formato email non valido");
                return;
                }
            else {
                try {
                    PersonalTrainer pt = this.pt_service.authenticate(email,password);
                    this.navigationController.showHome(pt);
                } catch (Exception e) {
                    this.loginView.getErrorLabel().setText(e.getMessage());
                }
            }
        });

        loginView.getSigninButton().setOnAction(_->{
            this.navigationController.showSingIn();
        });

    }

    public LoginView getView() {
        return loginView;
    }
}
