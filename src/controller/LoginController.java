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
        this.loginView.getLoginButton().setOnAction(_ -> {
            this.loginView.setLoading(true);
            this.loginView.clearError();
            String email = loginView.getEmailField().getText();
            String password = loginView.getPasswordField().getText();

            if (email.isEmpty() || password.isEmpty()) {
                loginView.showError("Per favore, compila tutti i campi.");
                loginView.setLoading(false);
                return;
            }
            if (!utils.isValidEmail(email)){
                this.loginView.showError("Formato email non valido");
                loginView.setLoading(false);
                return;
                }
            else {
                try {
                    PersonalTrainer pt = this.pt_service.authenticate(email,password);
                    this.navigationController.showDashboard(pt);
                } catch (Exception e) {
                    this.loginView.showError(e.getMessage());
                    loginView.setLoading(false);
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
