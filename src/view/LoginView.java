/**package src.view;

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
}*/

package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginView extends VBox {

    private TextField emailField;
    private PasswordField passwordField;
    private Button loginButton, signinButton;
    private Label errorLabel;
    
    public LoginView() {
        // Stile principale del container
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(40, 20, 40, 20));
        setStyle("-fx-background-color: linear-gradient(to bottom right, #f5f7fa, #c3cfe2);");

        // Container principale con ombra e bordi arrotondati
        VBox loginContainer = new VBox();
        loginContainer.setAlignment(Pos.CENTER);
        loginContainer.setSpacing(25);
        loginContainer.setPadding(new Insets(40, 50, 40, 50));
        loginContainer.setMaxWidth(400);
        loginContainer.setStyle("-fx-background-color: white; " +
                              "-fx-background-radius: 15; " +
                              "-fx-border-radius: 15; " +
                              "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 20, 0, 0, 5);");

        // Titolo
        Label titleLabel = new Label("Benvenuto");
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 28));
        titleLabel.setTextFill(Color.web("#2c3e50"));
        
        Label subtitleLabel = new Label("Accedi al tuo account");
        subtitleLabel.setFont(Font.font("System", 14));
        subtitleLabel.setTextFill(Color.web("#7f8c8d"));

        // Form container
        VBox formContainer = new VBox();
        formContainer.setSpacing(20);
        formContainer.setAlignment(Pos.CENTER);

        // Campo Email
        VBox emailBox = new VBox(5);
        emailBox.setAlignment(Pos.CENTER_LEFT);
        Label emailLabel = new Label("Email");
        emailLabel.setFont(Font.font("System", FontWeight.MEDIUM, 13));
        emailLabel.setTextFill(Color.web("#2c3e50"));

    
        
        emailField = new TextField();
        emailField.setPromptText("Inserisci la tua email");
        emailField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #bdc3c7; -fx-padding: 12; -fx-font-size: 14;");
        emailField.setPrefHeight(45);
        emailField.setMaxWidth(300);
        emailBox.getChildren().addAll(emailLabel, emailField);

        // Campo Password
        VBox passwordBox = new VBox(5);
        passwordBox.setAlignment(Pos.CENTER_LEFT);
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("System", FontWeight.MEDIUM, 13));
        passwordLabel.setTextFill(Color.web("#2c3e50"));
        
        passwordField = new PasswordField();
        passwordField.setPromptText("Inserisci la tua password");
        passwordField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #bdc3c7; -fx-padding: 12; -fx-font-size: 14;");
        passwordField.setPrefHeight(45);
        passwordField.setMaxWidth(300);
        passwordBox.getChildren().addAll(passwordLabel, passwordField);


        // To delete
        emailField.setText("test@test.it");
        passwordField.setText("testtest");


        // Bottone Login
        loginButton = new Button("Accedi");
        loginButton.setStyle("-fx-background-color: #3498db; " +
                           "-fx-text-fill: white; " +
                           "-fx-font-weight: bold; " +
                           "-fx-font-size: 14; " +
                           "-fx-background-radius: 8; " +
                           "-fx-border-radius: 8; " +
                           "-fx-padding: 12 30; " +
                           "-fx-cursor: hand;");
        loginButton.setPrefHeight(45);
        loginButton.setMaxWidth(300);
        loginButton.setPrefWidth(300);
        
        // Effetto hover per il bottone
        loginButton.setOnMouseEntered(e -> 
            loginButton.setStyle("-fx-background-color: #2980b9; " +
                              "-fx-text-fill: white; " +
                              "-fx-font-weight: bold; " +
                              "-fx-font-size: 14; " +
                              "-fx-background-radius: 8; " +
                              "-fx-border-radius: 8; " +
                              "-fx-padding: 12 30; " +
                              "-fx-cursor: hand;")
        );
        loginButton.setOnMouseExited(e -> 
            loginButton.setStyle("-fx-background-color: #3498db; " +
                              "-fx-text-fill: white; " +
                              "-fx-font-weight: bold; " +
                              "-fx-font-size: 14; " +
                              "-fx-background-radius: 8; " +
                              "-fx-border-radius: 8; " +
                              "-fx-padding: 12 30; " +
                              "-fx-cursor: hand;")
        );

        // Separatore
        HBox separatorBox = new HBox();
        separatorBox.setAlignment(Pos.CENTER);
        separatorBox.setPrefWidth(300);
        
        Line line1 = new Line(0, 0, 80, 0);
        line1.setStroke(Color.web("#bdc3c7"));
        line1.setStrokeWidth(1);
        
        Label orLabel = new Label(" oppure ");
        orLabel.setTextFill(Color.web("#7f8c8d"));
        orLabel.setFont(Font.font("System", 12));
        
        Line line2 = new Line(0, 0, 80, 0);
        line2.setStroke(Color.web("#bdc3c7"));
        line2.setStrokeWidth(1);
        
        separatorBox.getChildren().addAll(line1, orLabel, line2);

        // Bottone Registrazione
        signinButton = new Button("Crea un account");
        signinButton.setStyle("-fx-background-color: transparent; " +
                            "-fx-text-fill: #3498db; " +
                            "-fx-font-weight: bold; " +
                            "-fx-font-size: 13; " +
                            "-fx-border-color: #3498db; " +
                            "-fx-border-width: 2; " +
                            "-fx-border-radius: 8; " +
                            "-fx-background-radius: 8; " +
                            "-fx-padding: 10 25; " +
                            "-fx-cursor: hand;");
        signinButton.setPrefHeight(40);
        signinButton.setMaxWidth(300);
        
        // Effetto hover per il bottone di registrazione
        signinButton.setOnMouseEntered(e -> 
            signinButton.setStyle("-fx-background-color: #3498db; " +
                               "-fx-text-fill: white; " +
                               "-fx-font-weight: bold; " +
                               "-fx-font-size: 13; " +
                               "-fx-border-color: #3498db; " +
                               "-fx-border-width: 2; " +
                               "-fx-border-radius: 8; " +
                               "-fx-background-radius: 8; " +
                               "-fx-padding: 10 25; " +
                               "-fx-cursor: hand;")
        );
        signinButton.setOnMouseExited(e -> 
            signinButton.setStyle("-fx-background-color: transparent; " +
                               "-fx-text-fill: #3498db; " +
                               "-fx-font-weight: bold; " +
                               "-fx-font-size: 13; " +
                               "-fx-border-color: #3498db; " +
                               "-fx-border-width: 2; " +
                               "-fx-border-radius: 8; " +
                               "-fx-background-radius: 8; " +
                               "-fx-padding: 10 25; " +
                               "-fx-cursor: hand;")
        );

        // Label per errori
        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 12; -fx-alignment: center;");
        errorLabel.setWrapText(true);
        errorLabel.setMaxWidth(300);
        errorLabel.setAlignment(Pos.CENTER);

        // Aggiungi tutti gli elementi al form container
        formContainer.getChildren().addAll(emailBox, passwordBox, loginButton, errorLabel, separatorBox, signinButton);

        // Aggiungi tutto al container principale
        loginContainer.getChildren().addAll(titleLabel, subtitleLabel, formContainer);

        // Centra il container nella scena
        getChildren().add(loginContainer);
    }

    // Metodi per animazioni di feedback
    public void showError(String message) {
        errorLabel.setText(message);
        emailField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #e74c3c; -fx-padding: 12; -fx-font-size: 14;");
        passwordField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #e74c3c; -fx-padding: 12; -fx-font-size: 14;");
    }

    public void clearError() {
        errorLabel.setText("");
        emailField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #bdc3c7; -fx-padding: 12; -fx-font-size: 14;");
        passwordField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #bdc3c7; -fx-padding: 12; -fx-font-size: 14;");
    }

    public void setLoading(boolean loading) {
        if (loading) {
            loginButton.setText("Accesso in corso...");
            loginButton.setStyle("-fx-background-color: #95a5a6; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14; -fx-background-radius: 8; -fx-padding: 12 30;");
            loginButton.setDisable(true);
        } else {
            loginButton.setText("Accedi");
            loginButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14; -fx-background-radius: 8; -fx-padding: 12 30;");
            loginButton.setDisable(false);
        }
    }

    public TextField getEmailField() { return this.emailField; }
    public PasswordField getPasswordField() { return this.passwordField; }
    public Button getLoginButton() { return this.loginButton; }
    public Button getSigninButton() { return this.signinButton; }
    public Label getErrorLabel() { return this.errorLabel; }
}