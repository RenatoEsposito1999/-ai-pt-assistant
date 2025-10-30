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

public class SingUpView extends VBox {

    private TextField usernameField, emailField;
    private PasswordField passwordField;
    private Button signInButton, backButton;
    private Label resultLabel, errorLabel;
    
    public SingUpView() {
        setAlignment(Pos.CENTER);
        setSpacing(10);
        setPadding(new Insets(20));

        Label titleLabel = new Label("Sign Up");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        // Campi del form
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        
        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        // Aggiunta campi al grid
        formGrid.add(usernameLabel, 0, 0);
        formGrid.add(usernameField, 1, 0);
        formGrid.add(emailLabel, 0, 1);
        formGrid.add(emailField, 1, 1);
        formGrid.add(passwordLabel, 0, 2);
        formGrid.add(passwordField, 1, 2);

        // Label per errori (in rosso)
        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
        errorLabel.setWrapText(true);
        errorLabel.setMaxWidth(300);

        resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 14px;");

        signInButton = new Button("Sign Up");
        backButton = new Button("Back to Login");
        
        // HBox per i pulsanti
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(backButton, signInButton);

        getChildren().addAll(titleLabel, formGrid, errorLabel, buttonBox, resultLabel);
    }

    // Getter methods
    public TextField getUsernameField() { return this.usernameField; }
    public TextField getEmailField() { return this.emailField; }
    public PasswordField getPasswordField() { return this.passwordField; }
    public Button getSignInButton() { return this.signInButton; }
    public Button getBackButton() { return this.backButton; }
    public Label getResultLabel() { return this.resultLabel; }
    public Label getErrorLabel() { return this.errorLabel; }
    
    // Metodo utility per mostrare errori
    public void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }
    
    // Metodo utility per pulire gli errori
    public void clearError() {
        errorLabel.setText("");
    }
    
    // Metodo utility per mostrare successo
    public void showSuccess(String message) {
        resultLabel.setText(message);
        resultLabel.setStyle("-fx-text-fill: green; -fx-font-size: 14px;");
    }
}