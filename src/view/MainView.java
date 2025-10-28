package src.view;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainView {

    private Stage stage;
    private BorderPane rootLayout;

    public MainView(Stage primaryStage) {
        this.stage = primaryStage;

        rootLayout = new BorderPane();
        rootLayout.setMinWidth(600);
        rootLayout.setMinHeight(400);

        // Header
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setStyle("-fx-background-color: #2E86C1; -fx-padding: 10;");
        Label headerLabel = new Label("PT - APPLICATION");
        headerLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        header.getChildren().add(headerLabel);

        // Footer
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setStyle("-fx-background-color: #D5D8DC; -fx-padding: 5;");
        Label footerLabel = new Label("© 2025 - Renato Esposito");
        footer.getChildren().add(footerLabel);

        rootLayout.setTop(header);
        rootLayout.setBottom(footer);

        Scene scene = new Scene(rootLayout);
        stage.setTitle("PT Application");
        stage.setScene(scene);
        stage.show();
    }

    public void setCenter(javafx.scene.Node node) {
        rootLayout.setCenter(node);
    }

    public Stage getStage() {
        return stage;
    }
}
