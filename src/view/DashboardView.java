package src.view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;

public class DashboardView extends BorderPane {

    private Label welcomeLabel;
    private Label emailLabel;
    private Button logoutButton;
    private Button addClientButton;
    private TableView<Client> clientsTable;
    private Label statsLabel;

    public DashboardView() {
        setStyle("-fx-background-color: #f8f9fa;");
        initializeUI();
    }

    private void initializeUI() {
        // Header con informazioni personal trainer
        createHeader();
        
        // Centro con tabella clienti
        createCenter();
        
        // Footer con statistiche
        createFooter();
    }

    private void createHeader() {
        HBox header = new HBox(20);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: white; " +
                       "-fx-padding: 20; " +
                       "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 2);");
        
        // Informazioni personal trainer
        VBox infoBox = new VBox(5);
        infoBox.setAlignment(Pos.CENTER_LEFT);
        
        welcomeLabel = new Label("Benvenuto, [Username]");
        welcomeLabel.setStyle("-fx-text-fill: #2c3e50; -fx-font-size: 24px; -fx-font-weight: bold;");
        
        this.emailLabel = new Label("Email: [email@example.com]");
        this.emailLabel.setStyle("-fx-text-fill: #7f8c8d; -fx-font-size: 14px;");
        
        infoBox.getChildren().addAll(welcomeLabel, emailLabel);
        
        // Spacer
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        // Bottone logout
        logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #e74c3c; " +
                            "-fx-text-fill: white; " +
                            "-fx-font-weight: bold; " +
                            "-fx-font-size: 14; " +
                            "-fx-background-radius: 8; " +
                            "-fx-border-radius: 8; " +
                            "-fx-padding: 10 20; " +
                            "-fx-cursor: hand;");
        
        // Effetto hover logout
        logoutButton.setOnMouseEntered(e -> 
            logoutButton.setStyle("-fx-background-color: #c0392b; " +
                               "-fx-text-fill: white; " +
                               "-fx-font-weight: bold; " +
                               "-fx-font-size: 14; " +
                               "-fx-background-radius: 8; " +
                               "-fx-border-radius: 8; " +
                               "-fx-padding: 10 20; " +
                               "-fx-cursor: hand;")
        );
        logoutButton.setOnMouseExited(e -> 
            logoutButton.setStyle("-fx-background-color: #e74c3c; " +
                               "-fx-text-fill: white; " +
                               "-fx-font-weight: bold; " +
                               "-fx-font-size: 14; " +
                               "-fx-background-radius: 8; " +
                               "-fx-border-radius: 8; " +
                               "-fx-padding: 10 20; " +
                               "-fx-cursor: hand;")
        );

        header.getChildren().addAll(infoBox, spacer, logoutButton);
        setTop(header);
    }

    private void createCenter() {
        VBox centerContainer = new VBox(20);
        centerContainer.setPadding(new Insets(20));
        centerContainer.setAlignment(Pos.TOP_CENTER);

        // Titolo sezione
        Label clientsTitle = new Label("I Tuoi Clienti");
        clientsTitle.setStyle("-fx-text-fill: #2c3e50; -fx-font-size: 20px; -fx-font-weight: bold;");

        // Container tabella con pulsante
        VBox tableContainer = new VBox(15);
        tableContainer.setAlignment(Pos.TOP_CENTER);

        // Barra strumenti sopra la tabella
        HBox toolbar = new HBox(10);
        toolbar.setAlignment(Pos.CENTER_LEFT);
        
        addClientButton = new Button("➕ Aggiungi Cliente");
        addClientButton.setStyle("-fx-background-color: #27ae60; " +
                               "-fx-text-fill: white; " +
                               "-fx-font-weight: bold; " +
                               "-fx-font-size: 14; " +
                               "-fx-background-radius: 8; " +
                               "-fx-border-radius: 8; " +
                               "-fx-padding: 10 20; " +
                               "-fx-cursor: hand;");
        
        // Effetto hover aggiungi cliente
        addClientButton.setOnMouseEntered(e -> 
            addClientButton.setStyle("-fx-background-color: #229954; " +
                                  "-fx-text-fill: white; " +
                                  "-fx-font-weight: bold; " +
                                  "-fx-font-size: 14; " +
                                  "-fx-background-radius: 8; " +
                                  "-fx-border-radius: 8; " +
                                  "-fx-padding: 10 20; " +
                                  "-fx-cursor: hand;")
        );
        addClientButton.setOnMouseExited(e -> 
            addClientButton.setStyle("-fx-background-color: #27ae60; " +
                                  "-fx-text-fill: white; " +
                                  "-fx-font-weight: bold; " +
                                  "-fx-font-size: 14; " +
                                  "-fx-background-radius: 8; " +
                                  "-fx-border-radius: 8; " +
                                  "-fx-padding: 10 20; " +
                                  "-fx-cursor: hand;")
        );

        toolbar.getChildren().add(addClientButton);

        // Creazione tabella clienti
        createClientsTable();

        tableContainer.getChildren().addAll(toolbar, clientsTable);
        centerContainer.getChildren().addAll(clientsTitle, tableContainer);
        
        setCenter(centerContainer);
    }

    private void createClientsTable() {
        clientsTable = new TableView<>();
        clientsTable.setStyle("-fx-background-color: white; -fx-border-radius: 8; -fx-background-radius: 8;");
        clientsTable.setPlaceholder(new Label("Nessun cliente trovato. Clicca su 'Aggiungi Cliente' per iniziare."));

        // Colonne della tabella
        TableColumn<Client, String> nameCol = new TableColumn<>("Nome");
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameCol.setPrefWidth(120);

        TableColumn<Client, String> surnameCol = new TableColumn<>("Cognome");
        surnameCol.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        surnameCol.setPrefWidth(120);

        TableColumn<Client, Integer> ageCol = new TableColumn<>("Età");
        ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        ageCol.setPrefWidth(80);

        TableColumn<Client, Double> heightCol = new TableColumn<>("Altezza (cm)");
        heightCol.setCellValueFactory(cellData -> cellData.getValue().heightProperty().asObject());
        heightCol.setPrefWidth(100);

        TableColumn<Client, Double> weightCol = new TableColumn<>("Peso (kg)");
        weightCol.setCellValueFactory(cellData -> cellData.getValue().weightProperty().asObject());
        weightCol.setPrefWidth(100);

        TableColumn<Client, String> objectiveCol = new TableColumn<>("Obiettivo");
        objectiveCol.setCellValueFactory(cellData -> cellData.getValue().objectiveProperty());
        objectiveCol.setPrefWidth(150);

        // Colonna azioni
        TableColumn<Client, Void> actionsCol = new TableColumn<>("Azioni");
        actionsCol.setPrefWidth(120);
        actionsCol.setCellFactory(param -> new TableCell<Client, Void>() {
            private final Button viewButton = new Button("👁️ Dettagli");
            
            {
                viewButton.setStyle("-fx-background-color: #3498db; " +
                                 "-fx-text-fill: white; " +
                                 "-fx-font-size: 11; " +
                                 "-fx-background-radius: 6; " +
                                 "-fx-border-radius: 6; " +
                                 "-fx-padding: 5 10; " +
                                 "-fx-cursor: hand;");
                
                viewButton.setOnMouseEntered(e -> 
                    viewButton.setStyle("-fx-background-color: #2980b9; " +
                                     "-fx-text-fill: white; " +
                                     "-fx-font-size: 11; " +
                                     "-fx-background-radius: 6; " +
                                     "-fx-border-radius: 6; " +
                                     "-fx-padding: 5 10; " +
                                     "-fx-cursor: hand;")
                );
                viewButton.setOnMouseExited(e -> 
                    viewButton.setStyle("-fx-background-color: #3498db; " +
                                     "-fx-text-fill: white; " +
                                     "-fx-font-size: 11; " +
                                     "-fx-background-radius: 6; " +
                                     "-fx-border-radius: 6; " +
                                     "-fx-padding: 5 10; " +
                                     "-fx-cursor: hand;")
                );
                
                viewButton.setOnAction(event -> {
                    Client client = getTableView().getItems().get(getIndex());
                    showClientDetails(client);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(viewButton);
                }
            }
        });

        clientsTable.getColumns().add(nameCol);
        clientsTable.getColumns().add(surnameCol);
        clientsTable.getColumns().add(ageCol);
        clientsTable.getColumns().add(heightCol);
        clientsTable.getColumns().add(weightCol);
        clientsTable.getColumns().add(objectiveCol);
        clientsTable.getColumns().add(actionsCol);        
        // Imposta dimensioni tabella
        clientsTable.setPrefSize(800, 400);
    }

    private void createFooter() {
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setStyle("-fx-background-color: white; -fx-padding: 15; -fx-border-color: #ecf0f1; -fx-border-width: 1 0 0 0;");
        
        statsLabel = new Label("Totale clienti: 0");
        statsLabel.setStyle("-fx-text-fill: #7f8c8d; -fx-font-size: 14px;");
        
        footer.getChildren().add(statsLabel);
        setBottom(footer);
    }

    private void showClientDetails(Client client) {
        // Creazione finestra di dettaglio cliente
        Stage detailsStage = new Stage();
        detailsStage.setTitle("Dettagli Cliente - " + client.getFullName());

        VBox detailsContainer = new VBox(20);
        detailsContainer.setPadding(new Insets(25));
        detailsContainer.setStyle("-fx-background-color: white;");
        detailsContainer.setAlignment(Pos.TOP_LEFT);

        // Titolo
        Label titleLabel = new Label("📋 Scheda Cliente: " + client.getFullName());
        titleLabel.setStyle("-fx-text-fill: #2c3e50; -fx-font-size: 20px; -fx-font-weight: bold;");

        // Grid per i dati
        GridPane dataGrid = new GridPane();
        dataGrid.setHgap(15);
        dataGrid.setVgap(12);
        dataGrid.setAlignment(Pos.TOP_LEFT);

        // Aggiungi campi al grid
        addFieldToGrid(dataGrid, "Nome:", client.getName(), 0);
        addFieldToGrid(dataGrid, "Cognome:", client.getSurname(), 1);
        addFieldToGrid(dataGrid, "Età:", client.getAge() + " anni", 2);
        addFieldToGrid(dataGrid, "Altezza:", client.getHeight() + " cm", 3);
        addFieldToGrid(dataGrid, "Peso:", client.getWeight() + " kg", 4);
        addFieldToGrid(dataGrid, "Obiettivo:", client.getObjective(), 5);

        // Misure (se presenti)
        if (client.getMeasures() != null && !client.getMeasures().isEmpty()) {
            addFieldToGrid(dataGrid, "Misure:", client.getMeasures(), 6);
        }

        // Note (se presenti)
        if (client.getNotes() != null && !client.getNotes().isEmpty()) {
            Label notesLabel = new Label("Note:");
            notesLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #2c3e50;");
            
            TextArea notesArea = new TextArea(client.getNotes());
            notesArea.setEditable(false);
            notesArea.setWrapText(true);
            notesArea.setStyle("-fx-background-color: #f8f9fa; -fx-border-color: #bdc3c7;");
            notesArea.setPrefHeight(80);
            
            dataGrid.add(notesLabel, 0, 7);
            dataGrid.add(notesArea, 1, 7);
            GridPane.setColumnSpan(notesArea, 2);
        }

        // Bottone chiudi
        Button closeButton = new Button("Chiudi");
        closeButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20;");
        closeButton.setOnAction(e -> detailsStage.close());

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().add(closeButton);

        detailsContainer.getChildren().addAll(titleLabel, dataGrid, buttonBox);

        Scene detailsScene = new Scene(detailsContainer, 500, 500);
        detailsStage.setScene(detailsScene);
        detailsStage.show();
    }

    private void addFieldToGrid(GridPane grid, String label, String value, int row) {
        Label fieldLabel = new Label(label);
        fieldLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        Label valueLabel = new Label(value);
        valueLabel.setStyle("-fx-text-fill: #2c3e50;");
        
        grid.add(fieldLabel, 0, row);
        grid.add(valueLabel, 1, row);
    }

    // Metodi per aggiornare la vista
    public void setUserInfo(String username, String email) {
        welcomeLabel.setText("Benvenuto, " + username);
        emailLabel.setText("Email: " + email);
    }   

    public void updateStats(int totalClients) {
        statsLabel.setText("Totale clienti: " + totalClients);
    }

    // Getter methods
    public Button getLogoutButton() { return logoutButton; }
    public Button getAddClientButton() { return addClientButton; }
    public TableView<Client> getClientsTable() { return clientsTable; }

    // Classe Client per la tabella (da sostituire con la tua entity)
    public static class Client {
        private final StringProperty name = new SimpleStringProperty();
        private final StringProperty surname = new SimpleStringProperty();
        private final IntegerProperty age = new SimpleIntegerProperty();
        private final DoubleProperty height = new SimpleDoubleProperty();
        private final DoubleProperty weight = new SimpleDoubleProperty();
        private final StringProperty objective = new SimpleStringProperty();
        private String measures;
        private String notes;

        public Client(String name, String surname, int age, double height, double weight, String objective) {
            this.name.set(name);
            this.surname.set(surname);
            this.age.set(age);
            this.height.set(height);
            this.weight.set(weight);
            this.objective.set(objective);
        }

        // Getter e Property methods
        public String getName() { return name.get(); }
        public StringProperty nameProperty() { return name; }
        
        public String getSurname() { return surname.get(); }
        public StringProperty surnameProperty() { return surname; }
        
        public int getAge() { return age.get(); }
        public IntegerProperty ageProperty() { return age; }
        
        public double getHeight() { return height.get(); }
        public DoubleProperty heightProperty() { return height; }
        
        public double getWeight() { return weight.get(); }
        public DoubleProperty weightProperty() { return weight; }
        
        public String getObjective() { return objective.get(); }
        public StringProperty objectiveProperty() { return objective; }
        
        public String getMeasures() { return measures; }
        public void setMeasures(String measures) { this.measures = measures; }
        
        public String getNotes() { return notes; }
        public void setNotes(String notes) { this.notes = notes; }
        
        public String getFullName() { return name.get() + " " + surname.get(); }
    }
}