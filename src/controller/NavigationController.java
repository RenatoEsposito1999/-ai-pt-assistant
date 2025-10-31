package src.controller;
import src.model.PersonalTrainer;

public interface NavigationController {
    void showDashboard(PersonalTrainer pt_model);
    void showLoginView();
    void showSingIn();
}