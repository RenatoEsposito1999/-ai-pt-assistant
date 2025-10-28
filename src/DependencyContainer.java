package src;
import javafx.stage.Stage;

class DependencyContainer {
    //private ClienteDAO clienteDAO = new ClienteDAOSQLite();
    //private ClientiService clientiService = new ClientiService(clienteDAO);

    //public LoginController getLoginController() {
    //    return new LoginController(new LoginView(), clientiService);
    //}

    /**public ClientiController getClientiController() {
        return new ClientiController(new ClientDashboardView(), clientiService);
    }*/ 
    MainNavigationController mainController;
    public DependencyContainer(Stage primaryStage){
        this.mainController = new MainNavigationController(primaryStage);
    }

    public MainNavigationController getMainController(){
        return this.mainController;
    }
}