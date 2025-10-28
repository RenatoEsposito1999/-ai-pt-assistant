package src.controller;

import src.view.LoginView;

public class LoginController {
    private LoginView loginView;
    private NavigationController navigationController;

    public LoginController(NavigationController navigationController) {
        this.navigationController = navigationController;
        this.loginView = new LoginView();
        initialize();
    }

    private void initialize() {
        loginView.getLoginButton().setOnAction(e -> {
            String username = loginView.getUsernameField().getText();
            String password = loginView.getPasswordField().getText();


            //Qui chiamo service per controllare nel db. 
            
            // Esempio dummy (logica reale andrà nel Service)
            /**if (username.equals("admin") && password.equals("1234")) {
                loginView.getResultLabel().setText("Login riuscito!");
                navigationController.showDashboard(); // Naviga a un'altra vista
            } else {
                loginView.getResultLabel().setText("Credenziali errate");
            }*/
        });

        loginView.getSigninButton().setOnAction(e->{
            this.navigationController.showSingIn();
        });

    }

    public LoginView getView() {
        return loginView;
    }
}
