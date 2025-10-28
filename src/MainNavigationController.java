package src;

import javafx.stage.Stage;
import src.view.MainView;
import src.controller.LoginController;
import src.controller.NavigationController;
import src.controller.SinginController;

public class MainNavigationController implements NavigationController {

    private MainView mainView;

    public MainNavigationController(Stage primaryStage) {
        this.mainView = new MainView(primaryStage);
    }

    public void showLoginView() {
        LoginController loginController = new LoginController(this);
        mainView.setCenter(loginController.getView());
    }

    public void showDashboard(){
        // Quando implementerai la dashboard, la caricherai qui
        // mainView.setCenter(new DashboardView());
    }

    public Stage getStage() {
        return mainView.getStage();
    }

    public void showSingIn(){
        //Singin controller istanziarlo con this.
        //fare setcenter con singincontroller getview.
        SinginController singinController = new SinginController(this);
        this.mainView.setCenter(singinController.getView());
    }
}
