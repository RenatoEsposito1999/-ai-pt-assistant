package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SinginView extends VBox {

    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton, signinButton;
    private Label resultLabel;
    
    public SinginView() {
        setAlignment(Pos.CENTER);
        setSpacing(5);
        setPadding(new Insets(20));

        Label titleLabel = new Label("Sing in");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        formGrid.add(usernameLabel, 0, 0);
        formGrid.add(usernameField, 1, 0);
        formGrid.add(passwordLabel, 0, 1);
        formGrid.add(passwordField, 1, 1);

        
        resultLabel = new Label("REGISTRAZIONE");

        getChildren().addAll(titleLabel, formGrid, resultLabel);
    }

    public TextField getUsernameField() { return this.usernameField; }
    public PasswordField getPasswordField() { return this.passwordField; }
    public Button getLoginButton() { return this.loginButton; }
    public Button getSigninButton() { return this.signinButton; }
    public Label getResultLabel() { return this.resultLabel; }
}