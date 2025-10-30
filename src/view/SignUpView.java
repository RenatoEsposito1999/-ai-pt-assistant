/*package src.view;

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
}*/

package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SignUpView extends VBox {

    private TextField usernameField, emailField;
    private PasswordField passwordField;
    private Button signUpButton, backButton;
    private Label resultLabel, errorLabel;
    
    public SignUpView() {
        // Stile principale del container
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(40, 20, 40, 20));
        setStyle("-fx-background-color: linear-gradient(to bottom right, #f5f7fa, #c3cfe2);");

        // Container principale con ombra e bordi arrotondati
        VBox signupContainer = new VBox();
        signupContainer.setAlignment(Pos.CENTER);
        signupContainer.setSpacing(25);
        signupContainer.setPadding(new Insets(40, 50, 40, 50));
        signupContainer.setMaxWidth(450);
        signupContainer.setStyle("-fx-background-color: white; " +
                               "-fx-background-radius: 15; " +
                               "-fx-border-radius: 15; " +
                               "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 20, 0, 0, 5);");

        // Titolo
        Label titleLabel = new Label("Crea Account");
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 28));
        titleLabel.setTextFill(Color.web("#2c3e50"));
        
        Label subtitleLabel = new Label("Registrati per iniziare a utilizzare l'applicazione");
        subtitleLabel.setFont(Font.font("System", 14));
        subtitleLabel.setTextFill(Color.web("#7f8c8d"));

        // Form container
        VBox formContainer = new VBox();
        formContainer.setSpacing(20);
        formContainer.setAlignment(Pos.CENTER);

        // Campo Username
        VBox usernameBox = new VBox(5);
        usernameBox.setAlignment(Pos.CENTER_LEFT);
        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(Font.font("System", FontWeight.MEDIUM, 13));
        usernameLabel.setTextFill(Color.web("#2c3e50"));
        
        usernameField = new TextField();
        usernameField.setPromptText("Scegli un username");
        usernameField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #bdc3c7; -fx-padding: 12; -fx-font-size: 14;");
        usernameField.setPrefHeight(45);
        usernameField.setMaxWidth(320);
        usernameBox.getChildren().addAll(usernameLabel, usernameField);

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
        emailField.setMaxWidth(320);
        emailBox.getChildren().addAll(emailLabel, emailField);

        // Campo Password
        VBox passwordBox = new VBox(5);
        passwordBox.setAlignment(Pos.CENTER_LEFT);
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("System", FontWeight.MEDIUM, 13));
        passwordLabel.setTextFill(Color.web("#2c3e50"));
        
        passwordField = new PasswordField();
        passwordField.setPromptText("Crea una password sicura");
        passwordField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #bdc3c7; -fx-padding: 12; -fx-font-size: 14;");
        passwordField.setPrefHeight(45);
        passwordField.setMaxWidth(320);
        passwordBox.getChildren().addAll(passwordLabel, passwordField);

        // Label per errori
        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 12; -fx-alignment: center;");
        errorLabel.setWrapText(true);
        errorLabel.setMaxWidth(320);
        errorLabel.setAlignment(Pos.CENTER);

        // Bottone Registrazione
        signUpButton = new Button("Crea Account");
        signUpButton.setStyle("-fx-background-color: #27ae60; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-weight: bold; " +
                            "-fx-font-size: 14; " +
                            "-fx-background-radius: 8; " +
                            "-fx-border-radius: 8; " +
                            "-fx-padding: 12 30; " +
                            "-fx-cursor: hand;");
        signUpButton.setPrefHeight(45);
        signUpButton.setMaxWidth(320);
        signUpButton.setPrefWidth(320);
        
        // Effetto hover per il bottone registrazione
        signUpButton.setOnMouseEntered(e -> 
            signUpButton.setStyle("-fx-background-color: #229954; " +
                               "-fx-text-fill: white; " +
                               "-fx-font-weight: bold; " +
                               "-fx-font-size: 14; " +
                               "-fx-background-radius: 8; " +
                               "-fx-border-radius: 8; " +
                               "-fx-padding: 12 30; " +
                               "-fx-cursor: hand;")
        );
        signUpButton.setOnMouseExited(e -> 
            signUpButton.setStyle("-fx-background-color: #27ae60; " +
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
        separatorBox.setPrefWidth(320);
        
        Line line1 = new Line(0, 0, 100, 0);
        line1.setStroke(Color.web("#bdc3c7"));
        line1.setStrokeWidth(1);
        
        Label orLabel = new Label(" oppure ");
        orLabel.setTextFill(Color.web("#7f8c8d"));
        orLabel.setFont(Font.font("System", 12));
        
        Line line2 = new Line(0, 0, 100, 0);
        line2.setStroke(Color.web("#bdc3c7"));
        line2.setStrokeWidth(1);
        
        separatorBox.getChildren().addAll(line1, orLabel, line2);

        // Bottone Torna al Login
        backButton = new Button("Torna al Login");
        backButton.setStyle("-fx-background-color: transparent; " +
                          "-fx-text-fill: #3498db; " +
                          "-fx-font-weight: bold; " +
                          "-fx-font-size: 13; " +
                          "-fx-border-color: #3498db; " +
                          "-fx-border-width: 2; " +
                          "-fx-border-radius: 8; " +
                          "-fx-background-radius: 8; " +
                          "-fx-padding: 10 25; " +
                          "-fx-cursor: hand;");
        backButton.setPrefHeight(40);
        backButton.setMaxWidth(320);
        
        // Effetto hover per il bottone back
        backButton.setOnMouseEntered(e -> 
            backButton.setStyle("-fx-background-color: #3498db; " +
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
        backButton.setOnMouseExited(e -> 
            backButton.setStyle("-fx-background-color: transparent; " +
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

        // Label per risultati (successo)
        resultLabel = new Label();
        resultLabel.setStyle("-fx-text-fill: #27ae60; -fx-font-size: 13; -fx-alignment: center; -fx-font-weight: bold;");
        resultLabel.setWrapText(true);
        resultLabel.setMaxWidth(320);
        resultLabel.setAlignment(Pos.CENTER);

        // Aggiungi tutti gli elementi al form container
        formContainer.getChildren().addAll(
            usernameBox, emailBox, passwordBox, 
            errorLabel, signUpButton, resultLabel, 
            separatorBox, backButton
        );

        // Aggiungi tutto al container principale
        signupContainer.getChildren().addAll(titleLabel, subtitleLabel, formContainer);

        // Centra il container nella scena
        getChildren().add(signupContainer);
    }

    // Metodi per animazioni di feedback
    public void showError(String message) {
        errorLabel.setText(message);
        usernameField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #e74c3c; -fx-padding: 12; -fx-font-size: 14;");
        emailField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #e74c3c; -fx-padding: 12; -fx-font-size: 14;");
        passwordField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #e74c3c; -fx-padding: 12; -fx-font-size: 14;");
    }

    public void clearError() {
        errorLabel.setText("");
        usernameField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #bdc3c7; -fx-padding: 12; -fx-font-size: 14;");
        emailField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #bdc3c7; -fx-padding: 12; -fx-font-size: 14;");
        passwordField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #bdc3c7; -fx-padding: 12; -fx-font-size: 14;");
    }

    public void showSuccess(String message) {
        resultLabel.setText(message);
        resultLabel.setStyle("-fx-text-fill: #27ae60; -fx-font-size: 13; -fx-alignment: center; -fx-font-weight: bold;");
        
        // Reset dei bordi dei campi
        clearError();
    }

    public void setLoading(boolean loading) {
        if (loading) {
            signUpButton.setText("Registrazione in corso...");
            signUpButton.setStyle("-fx-background-color: #95a5a6; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14; -fx-background-radius: 8; -fx-padding: 12 30;");
            signUpButton.setDisable(true);
        } else {
            signUpButton.setText("Crea Account");
            signUpButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14; -fx-background-radius: 8; -fx-padding: 12 30;");
            signUpButton.setDisable(false);
        }
    }

    public void clearForm() {
        usernameField.clear();
        emailField.clear();
        passwordField.clear();
        clearError();
        resultLabel.setText("");
    }

    // Getter methods
    public TextField getUsernameField() { return this.usernameField; }
    public TextField getEmailField() { return this.emailField; }
    public PasswordField getPasswordField() { return this.passwordField; }
    public Button getSignUpButton() { return this.signUpButton; }
    public Button getBackButton() { return this.backButton; }
    public Label getResultLabel() { return this.resultLabel; }
    public Label getErrorLabel() { return this.errorLabel; }
}