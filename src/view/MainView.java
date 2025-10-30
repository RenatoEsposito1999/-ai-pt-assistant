package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainView {

    private Stage stage;
    private BorderPane rootLayout;
    private HBox footer;
    private Hyperlink contactLink;
    private Button helpButton;

    public MainView(Stage primaryStage) {
        this.stage = primaryStage;
        initializeUI();
    }

    private void initializeUI() {
        rootLayout = new BorderPane();
        
        // Dimensioni fisse minime e preferite
        rootLayout.setMinWidth(1000);
        rootLayout.setMinHeight(700);
        rootLayout.setPrefWidth(1200);
        rootLayout.setPrefHeight(800);

        // Header migliorato
        createHeader();
        
        // Footer migliorato con più informazioni
        createFooter();

        Scene scene = new Scene(rootLayout);
        
        // ABILITA CONTESTO MENU (tasto destro)
        scene.setOnContextMenuRequested(null); // Rimuove eventuali blocchi
        
        stage.setTitle("PT Application - Personal Trainer Management System");
        stage.setScene(scene);
        
        // Imposta dimensioni iniziali
        stage.setWidth(1100);
        stage.setHeight(900);
        stage.setMinWidth(1100);
        stage.setMinHeight(900);
        
        stage.show();
    }

    private void createHeader() {
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setStyle("-fx-background-color: linear-gradient(to right, #2E86C1, #3498DB); " +
                       "-fx-padding: 15; " +
                       "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 2);");
        
        // Logo e titolo
        HBox titleContainer = new HBox(10);
        titleContainer.setAlignment(Pos.CENTER_LEFT);
        titleContainer.setPadding(new Insets(0, 0, 0, 20));
        
        // Icona/titolo
        Label iconLabel = new Label("💪");
        iconLabel.setStyle("-fx-font-size: 24px;");
        
        VBox titleBox = new VBox(2);
        Label mainTitle = new Label("PT APPLICATION");
        mainTitle.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;");
        
        Label subtitle = new Label("Personal Trainer Management System");
        subtitle.setStyle("-fx-text-fill: #E8F6F3; -fx-font-size: 12px;");
        
        titleBox.getChildren().addAll(mainTitle, subtitle);
        titleContainer.getChildren().addAll(iconLabel, titleBox);
        
        // Spacer per centrare il titolo
        HBox.setHgrow(titleContainer, javafx.scene.layout.Priority.ALWAYS);
        titleContainer.setMaxWidth(Double.MAX_VALUE);
        
        header.getChildren().add(titleContainer);
        rootLayout.setTop(header);
    }

    private void createFooter() {
        footer = new HBox(20);
        footer.setAlignment(Pos.CENTER);
        footer.setStyle("-fx-background-color: #2C3E50; " +
                       "-fx-padding: 12; " +
                       "-fx-border-color: #34495E; " +
                       "-fx-border-width: 1 0 0 0;");
        
        // Copyright
        Label copyrightLabel = new Label("© 2025 PT Application - Renato Esposito");
        copyrightLabel.setStyle("-fx-text-fill: #BDC3C7; -fx-font-size: 12px;");

        // Separatore
        Label separator1 = new Label("|");
        separator1.setStyle("-fx-text-fill: #7F8C8D;");

        // Link contatti - ORA FUNZIONANTE
        contactLink = new Hyperlink("✉ Contattaci");
        contactLink.setStyle("-fx-text-fill: #3498DB; -fx-border-color: transparent; -fx-underline: false; -fx-font-size: 12px;");
        contactLink.setTooltip(new Tooltip("Apri finestra contatti"));
        
        // Effetto hover per il link contatti
        contactLink.setOnMouseEntered(e -> 
            contactLink.setStyle("-fx-text-fill: #5DADE2; -fx-border-color: transparent; -fx-underline: true; -fx-font-size: 12px;")
        );
        contactLink.setOnMouseExited(e -> 
            contactLink.setStyle("-fx-text-fill: #3498DB; -fx-border-color: transparent; -fx-underline: false; -fx-font-size: 12px;")
        );

        // Separatore
        Label separator2 = new Label("|");
        separator2.setStyle("-fx-text-fill: #7F8C8D;");

        // Bottone help
        helpButton = new Button("❓ Help");
        helpButton.setStyle("-fx-background-color: transparent; " +
                          "-fx-text-fill: #BDC3C7; " +
                          "-fx-border-color: #7F8C8D; " +
                          "-fx-border-width: 1; " +
                          "-fx-border-radius: 12; " +
                          "-fx-background-radius: 12; " +
                          "-fx-font-size: 11px; " +
                          "-fx-padding: 2 8; " +
                          "-fx-cursor: hand;");
        helpButton.setTooltip(new Tooltip("Ottieni aiuto e supporto"));
        
        // Effetto hover per il bottone help
        helpButton.setOnMouseEntered(e -> 
            helpButton.setStyle("-fx-background-color: #34495E; " +
                             "-fx-text-fill: white; " +
                             "-fx-border-color: #3498DB; " +
                             "-fx-border-width: 1; " +
                             "-fx-border-radius: 12; " +
                             "-fx-background-radius: 12; " +
                             "-fx-font-size: 11px; " +
                             "-fx-padding: 2 8; " +
                             "-fx-cursor: hand;")
        );
        helpButton.setOnMouseExited(e -> 
            helpButton.setStyle("-fx-background-color: transparent; " +
                             "-fx-text-fill: #BDC3C7; " +
                             "-fx-border-color: #7F8C8D; " +
                             "-fx-border-width: 1; " +
                             "-fx-border-radius: 12; " +
                             "-fx-background-radius: 12; " +
                             "-fx-font-size: 11px; " +
                             "-fx-padding: 2 8; " +
                             "-fx-cursor: hand;")
        );

        footer.getChildren().addAll(copyrightLabel, separator1, contactLink, separator2, helpButton);
        rootLayout.setBottom(footer);
    }

    // Metodi per gestire gli eventi dei componenti del footer
    public void setOnContactAction(EventHandler<ActionEvent> handler) {
        if (contactLink != null) {
            contactLink.setOnAction(handler);
        }
    }

    public void setOnHelpAction(EventHandler<ActionEvent> handler) {
        if (helpButton != null) {
            helpButton.setOnAction(handler);
        }
    }

    // Metodo per mostrare una finestra di contatti - ORA CON EMAIL CLICCABILE
    public void showContactDialog() {
        Stage contactStage = new Stage();
        contactStage.setTitle("Contatti - Supporto");
        
        VBox dialogContent = new VBox(15);
        dialogContent.setPadding(new Insets(20));
        dialogContent.setAlignment(Pos.CENTER);
        dialogContent.setStyle("-fx-background-color: white;");
        
        Label title = new Label("📧 Contattaci");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2C3E50;");
        
        Label emailLabel = new Label("Email di supporto:");
        emailLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #2C3E50;");
        
        // EMAIL CLICCABILE CHE APRE LA MAIL
        Hyperlink emailLink = new Hyperlink("support@ptapplication.com");
        emailLink.setStyle("-fx-font-size: 14px; -fx-text-fill: #3498DB;");
        emailLink.setOnAction(e -> {
            // Apre il client email predefinito
            try {
                java.awt.Desktop.getDesktop().mail(
                    new java.net.URI("mailto:support@ptapplication.com?subject=Supporto PT Application")
                );
            } catch (Exception ex) {
                // Fallback: copia l'email negli appunti
                final java.awt.datatransfer.Clipboard clipboard = 
                    java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
                final java.awt.datatransfer.StringSelection selection = 
                    new java.awt.datatransfer.StringSelection("support@ptapplication.com");
                clipboard.setContents(selection, selection);
                
                // Mostra messaggio
                showInfoMessage("Email copiata negli appunti: support@ptapplication.com");
            }
        });
        
        Label phoneLabel = new Label("Telefono: +39 02 1234567");
        phoneLabel.setStyle("-fx-text-fill: #7F8C8D;");
        
        Label hoursLabel = new Label("Orari supporto: Lun-Ven 9:00-18:00");
        hoursLabel.setStyle("-fx-text-fill: #7F8C8D; -fx-font-size: 12px;");
        
        Button closeButton = new Button("Chiudi");
        closeButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 16;");
        closeButton.setOnAction(e -> contactStage.close());
        
        dialogContent.getChildren().addAll(title, emailLabel, emailLink, phoneLabel, hoursLabel, closeButton);
        
        Scene dialogScene = new Scene(dialogContent, 320, 240);
        contactStage.setScene(dialogScene);
        contactStage.show();
    }

    // Metodo per mostrare help
    public void showHelpDialog() {
        Stage helpStage = new Stage();
        helpStage.setTitle("Help - Guida all'uso");
        
        VBox helpContent = new VBox(15);
        helpContent.setPadding(new Insets(20));
        helpContent.setAlignment(Pos.CENTER_LEFT);
        helpContent.setStyle("-fx-background-color: white;");
        
        Label title = new Label("❓ Guida e Supporto");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2C3E50;");
        
        Label helpText = new Label(
            "Benvenuto in PT Application!\n\n" +
            "• Login: Accedi con le tue credenziali\n" +
            "• Registrazione: Crea un nuovo account\n" +
            "• Gestione Clienti: Aggiungi e gestisci i tuoi clienti\n" +
            "• Programmi Allenamento: Crea schede personalizzate\n\n" +
            "Per assistenza contatta il supporto tecnico."
        );
        helpText.setStyle("-fx-text-fill: #2C3E50; -fx-font-size: 13px;");
        helpText.setWrapText(true);
        
        Button closeButton = new Button("Chiudi");
        closeButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 16;");
        closeButton.setOnAction(e -> helpStage.close());
        
        helpContent.getChildren().addAll(title, helpText, closeButton);
        
        Scene helpScene = new Scene(helpContent, 400, 280);
        helpStage.setScene(helpScene);
        helpStage.show();
    }

    // Metodo utility per messaggi
    private void showInfoMessage(String message) {
        Stage infoStage = new Stage();
        infoStage.setTitle("Informazione");
        
        VBox content = new VBox(15);
        content.setPadding(new Insets(20));
        content.setAlignment(Pos.CENTER);
        content.setStyle("-fx-background-color: white;");
        
        Label messageLabel = new Label(message);
        messageLabel.setStyle("-fx-text-fill: #2C3E50; -fx-font-size: 14px;");
        
        Button okButton = new Button("OK");
        okButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");
        okButton.setOnAction(e -> infoStage.close());
        
        content.getChildren().addAll(messageLabel, okButton);
        
        Scene scene = new Scene(content, 300, 150);
        infoStage.setScene(scene);
        infoStage.show();
    }

    public void setCenter(javafx.scene.Node node) {
        rootLayout.setCenter(node);
    }

    public Stage getStage() {
        return stage;
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }
}