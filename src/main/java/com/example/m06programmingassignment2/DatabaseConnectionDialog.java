package com.example.m06programmingassignment2;

import database.DatabaseConnection;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class DatabaseConnectionDialog extends Dialog<DatabaseConnection>
{
    private final DatabaseConnection databaseConnection;
    private final Label lblConnection = new Label("No Active Connection");
    private final ComboBox<String> cbJdbcDrive = new ComboBox<>();
    private final ComboBox<String> cbDatabaseUrl = new ComboBox<>();
    private final TextField tfUsername = new TextField();
    private final TextField tfPassword = new TextField();

    public DatabaseConnectionDialog(DatabaseConnection databaseConnection)
    {
        super();
        this.setTitle("Connect to DB");
        this.databaseConnection = databaseConnection;
        getDialogPane().setContent(creatGridPane());

        ButtonType btConnectToDatabase = new ButtonType("Connect to DB", ButtonBar.ButtonData.OK_DONE);
        ButtonType btCloseDialog = new ButtonType("Close Dialog", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(btConnectToDatabase, btCloseDialog);
        setPropertyBindings();
        setResultConverter();
    }

    private void setResultConverter()
    {
        Callback<ButtonType, DatabaseConnection> databaseConnectionCallback = buttonType -> {
            if (buttonType != ButtonType.CANCEL && buttonType != ButtonType.CLOSE && buttonType.getText()
                                                                                               .equals("Connect to DB"))
            {
                return databaseConnection;
            }

            return null;
        };

        setResultConverter(databaseConnectionCallback);
    }

    private void setPropertyBindings()
    {
        cbJdbcDrive.valueProperty().bindBidirectional(databaseConnection.getJdbcDriveProperty());
        cbDatabaseUrl.valueProperty().bindBidirectional(databaseConnection.getDatabaseUrlProperty());
        lblConnection.textProperty().bind(cbDatabaseUrl.valueProperty());
        tfUsername.textProperty().bindBidirectional(databaseConnection.getUsernameProperty());
        tfPassword.textProperty().bindBidirectional(databaseConnection.getPasswordProperty());
    }

    public Pane creatGridPane()
    {
        VBox content = new VBox(10);
        Label lblJdbcDrive = new Label("JDBC Drive");
        lblJdbcDrive.setLabelFor(cbJdbcDrive);

        Label lblDatabaseUrl = new Label("Database URL");
        lblDatabaseUrl.setLabelFor(cbDatabaseUrl);

        Label lblUsername = new Label("Username");
        lblUsername.setLabelFor(tfUsername);

        Label lblPassword = new Label("Password");
        lblPassword.setLabelFor(tfPassword);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(5);

        grid.add(lblConnection, 0, 0);

        cbJdbcDrive.setMinWidth(50);
        cbDatabaseUrl.setMinWidth(50);
        grid.addRow(1, lblJdbcDrive, cbJdbcDrive);
        grid.addRow(2, lblDatabaseUrl, cbDatabaseUrl);
        grid.addRow(3, lblUsername, tfUsername);
        grid.addRow(4, lblPassword, tfPassword);

        content.getChildren().add(grid);
        return content;
    }
}
