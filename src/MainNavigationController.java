package src;

import javafx.stage.Stage;
import src.view.MainView;
import src.controller.LoginController;
import src.controller.NavigationController;
import src.controller.SingUpController;
import src.model.PersonalTrainer;

public class MainNavigationController implements NavigationController {
    private DependencyContainer container; 
    private MainView mainView;

    public MainNavigationController(Stage primaryStage, DependencyContainer container ) {
        this.mainView = new MainView(primaryStage);
        mainView.setOnContactAction(_ -> mainView.showContactDialog());
        mainView.setOnHelpAction(_ -> mainView.showHelpDialog());
        this.container = container;
    }

    public void showLoginView() {
        LoginController loginController = new LoginController(this, container.getPT_Service());
        mainView.setCenter(loginController.getView());
    }

    public void showDashboard(PersonalTrainer pt_model){
        // Quando implementerai la dashboard, la caricherai qui
        // mainView.setCenter(new DashboardView());
        // Creo controller dashboard e setto this mainview set center a controller.getview()
    }

    public Stage getStage() {
        return mainView.getStage();
    }

    public void showSingIn(){
        //Singin controller istanziarlo con this.
        //fare setcenter con singincontroller getview.
        SingUpController singUpController = new SingUpController(this, this.container.getPT_Service());
        this.mainView.setCenter(singUpController.getView());
    }

}
