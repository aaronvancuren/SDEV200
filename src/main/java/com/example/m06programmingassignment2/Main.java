package com.example.m06programmingassignment2;

import database.DatabaseConnection;
import database.MariaProvider;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigInteger;
import java.util.Optional;

public class Main extends Application
{
    private MariaProvider mariaProvider;
    private final Label lblQueryStatus = new Label("Needs Connection");
    private final TextArea taBatchPerformance = new TextArea(createBatchPerformanceResults());
    private BigInteger elapsedTimeBatchUpdate = BigInteger.valueOf(0);
    private BigInteger elapsedTimeNonBatchUpdate = BigInteger.valueOf(0);
    private final Button btConnectToDatabaseDialog = new Button("Connect to Database");
    private final Button btUpdateBatch = new Button("Batch Update");
    private final Button btUpdateNonBatch = new Button("Non-Batch Update");

    @Override
    public void start(Stage stage)
    {
        VBox form = new VBox();
        HBox databaseRow = createDatabaseRow();
        HBox buttonRow = createButtonRow();
        form.getChildren().addAll(databaseRow, taBatchPerformance, buttonRow);

        Scene scene = new Scene(form, 320, 240);
        stage.setTitle("Exercise35_01");
        stage.setScene(scene);
        stage.show();
    }

    private HBox createDatabaseRow()
    {
        HBox row = new HBox(10);
        lblQueryStatus.setAlignment(Pos.CENTER_LEFT);
        lblQueryStatus.setPadding(new Insets(10, 10, 10, 30));

        btConnectToDatabaseDialog.setPadding(new Insets(10));
        btConnectToDatabaseDialog.setAlignment(Pos.CENTER_RIGHT);
        btConnectToDatabaseDialog.setOnAction(e -> connectToDatabaseDialog());

        row.getChildren().addAll(lblQueryStatus, btConnectToDatabaseDialog);
        row.setAlignment(Pos.CENTER);
        return row;
    }

    private void connectToDatabaseDialog()
    {
        try
        {
            Dialog<DatabaseConnection> dialog = new DatabaseConnectionDialog(
                    new DatabaseConnection("org.mariadb.jdbc.Driver",
                                           "jdbc:mariadb://localhost:3306/sdev_programmingassignments", "root", ""));
            Optional<DatabaseConnection> result = dialog.showAndWait();
            if (result.isPresent())
            {
                DatabaseConnection databaseConnection = result.get();
                mariaProvider = new MariaProvider(databaseConnection);
                lblQueryStatus.setText("Connection to database succeeded");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private String createBatchPerformanceResults()
    {
        return "Batch update completed\n" + "The elapsed time is " + elapsedTimeBatchUpdate + "\n\n" + "Non-Batch update completed\n" + "The elapsed time is " + elapsedTimeNonBatchUpdate + "\n\n";
    }

    private HBox createButtonRow()
    {
        HBox row = new HBox(10);
        btUpdateBatch.setPadding(new Insets(10));
        btUpdateBatch.setOnAction(e -> updateBatch());

        btUpdateNonBatch.setPadding(new Insets(10));
        btUpdateNonBatch.setOnAction(e -> updateNonBatch());

        row.getChildren().addAll(btUpdateBatch, btUpdateNonBatch);
        row.setAlignment(Pos.CENTER);
        return row;
    }

    private void updateBatch()
    {
        try
        {
            elapsedTimeBatchUpdate = mariaProvider.updateBatch();
            taBatchPerformance.setText(createBatchPerformanceResults());
            lblQueryStatus.setText("Batch update succeeded");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void updateNonBatch()
    {
        try
        {
            elapsedTimeNonBatchUpdate = mariaProvider.updateNonBatch();
            taBatchPerformance.setText(createBatchPerformanceResults());
            lblQueryStatus.setText("Non-Batch update succeeded");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}