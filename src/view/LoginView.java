package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {

    private TextField emailField;
    private PasswordField passwordField;
    private Button loginButton, signinButton;
    private Label errorLabel;
    
    public LoginView() {
        setAlignment(Pos.CENTER);
        setSpacing(5);
        setPadding(new Insets(20));

        Label titleLabel = new Label("Login");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        formGrid.add(emailLabel, 0, 0);
        formGrid.add(emailField, 1, 0);
        formGrid.add(passwordLabel, 0, 1);
        formGrid.add(passwordField, 1, 1);

        loginButton = new Button("Login");
        signinButton = new Button("Sign up");
        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
        errorLabel.setWrapText(true);
        errorLabel.setMaxWidth(300);

        HBox buttonBox = new HBox(5);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(loginButton, signinButton);

        getChildren().addAll(titleLabel, formGrid, buttonBox, errorLabel);
    }

    public TextField getEmailField() { return this.emailField; }
    public PasswordField getPasswordField() { return this.passwordField; }
    public Button getLoginButton() { return this.loginButton; }
    public Button getSigninButton() { return this.signinButton; }
    public Label getErrorLabel() { return this.errorLabel; }
}