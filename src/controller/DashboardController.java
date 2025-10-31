package src.controller;

import src.model.PersonalTrainer;
import src.view.DashboardView;

public class DashboardController {
    private DashboardView view;
    private NavigationController navigationController;
    private PersonalTrainer pt;

    public DashboardController(NavigationController navigationController, PersonalTrainer pt){
        this.view = new DashboardView();
        this.navigationController = navigationController;
        this.pt = pt;
        initialize();
    }
    public void initialize(){
        this.view.getLogoutButton().setOnAction(_->{
            this.navigationController.showLoginView();
        });
    }
    public DashboardView getView(){
        return this.view;
    }
}
