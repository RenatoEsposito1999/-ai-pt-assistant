package src;
import javafx.stage.Stage;
import src.dao.*;
import src.service.PersonalTrainerService;
class DependencyContainer {
    
    private MainNavigationController mainController;
    private PersonalTrainerService pt_service;
    private PersonalTrainerDAOSQLite pt_dao;
    public DependencyContainer(Stage primaryStage){
        DatabaseInitializer.initialize();
        
        // creo il dao che serve e il service, 
        this.pt_dao = new PersonalTrainerDAOSQLite();
        this.pt_service = new PersonalTrainerService(pt_dao);





        
        this.mainController = new MainNavigationController(primaryStage, this);
    }

    public MainNavigationController getMainController(){return this.mainController;}
    public PersonalTrainerService getPT_Service(){return this.pt_service;}
    public PersonalTrainerDAOSQLite getPT_dao(){return this.pt_dao;}
}