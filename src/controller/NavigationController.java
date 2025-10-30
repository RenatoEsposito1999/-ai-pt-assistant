package src.controller;
import src.model.PersonalTrainer;

public interface NavigationController {
    void showDashboard();
    void showLoginView();
    void showSingIn();
    void showHome(PersonalTrainer pt_model);
}