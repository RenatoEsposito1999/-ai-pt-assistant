package src; 
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        DependencyContainer container = new DependencyContainer(primaryStage);
        container.getMainController().showLoginView();  // Avvio dell'interfaccia iniziale
    }

    public static void main(String[] args) {
        launch(args);
    }
}
