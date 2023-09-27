package main.m06programmingassignment1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application
{
    private Connection connection;
    private Label lblID = new Label("ID");
    private TextField tfID = new TextField();
    private Label lblLastName = new Label("Last Name");
    private TextField tfLastName = new TextField();
    private Label lblFirstName = new Label("First Name");
    private TextField tfFirstName = new TextField();
    private Label lblMiddleName = new Label("MI");
    private TextField tfMiddleName = new TextField();
    private Label lblAddress = new Label("Address");
    private TextField tfAddress = new TextField();
    private Label lblCity = new Label("City");
    private TextField tfCity = new TextField();
    private Label lblState = new Label("State");
    private TextField tfState = new TextField();
    private Label lblTelephone = new Label("Telephone");
    private TextField tfTelephone = new TextField();
    private Button btViewStaff = new Button("View");
    private Button btInsertStaff = new Button("Insert");
    private Button btUpdateStaff = new Button("Update");
    private Button btClearForm = new Button("Clear");

    @Override
    public void start(Stage stage) throws IOException
    {
        initializeDatabase();

        VBox form = new VBox();
        Label lblQueryStatus = new Label();
        HBox idRow = createIdRow();
        HBox fullNameRow = createFullNameRow();
        HBox addressRow = createAddressRow();
        HBox cityStateRow = createCityStateRow();
        HBox phoneNumberRow = createPhoneNumberRow();
        HBox buttonRow = createButtonRow(form);
        form.getChildren()
            .addAll(lblQueryStatus, idRow, fullNameRow, addressRow, cityStateRow, phoneNumberRow, buttonRow);

        Scene scene = new Scene(form);

        stage.setTitle("Exercise34_01");
        stage.setScene(scene);
        stage.show();
    }

    private void initializeDatabase()
    {
        try
        {
            System.out.println("Loading driver...");

            try
            {
                Class.forName("org.mariadb.jdbc.Driver");
                System.out.println("Driver loaded!");
            }
            catch (ClassNotFoundException e)
            {
                throw new IllegalStateException("Cannot find the driver in the classpath!", e);
            }

            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/sdev_programmingassignments?user=root");
            System.out.println("Database connected...");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private HBox createIdRow()
    {
        HBox idRow = new HBox(5);
        lblID = new Label("ID");
        tfID = new TextField();
        lblID.setLabelFor(tfID);
        idRow.getChildren().addAll(lblID, tfID);
        return idRow;
    }

    private HBox createFullNameRow()
    {
        HBox fullNameRow = new HBox(5);
        lblLastName = new Label("Last Name");
        tfLastName = new TextField();
        lblLastName.setLabelFor(tfLastName);

        lblFirstName = new Label("First Name");
        tfFirstName = new TextField();
        lblFirstName.setLabelFor(tfFirstName);

        lblMiddleName = new Label("MI");
        tfMiddleName = new TextField();
        tfMiddleName.setMaxWidth(25);
        lblMiddleName.setLabelFor(tfMiddleName);

        fullNameRow.getChildren()
                   .addAll(lblLastName, tfLastName, lblFirstName, tfFirstName, lblMiddleName, tfMiddleName);
        return fullNameRow;
    }

    private HBox createAddressRow()
    {
        HBox addressRow = new HBox(5);
        lblAddress = new Label("Address");
        tfAddress = new TextField();
        lblAddress.setLabelFor(tfAddress);

        addressRow.getChildren().addAll(lblAddress, tfAddress);
        return addressRow;
    }

    private HBox createCityStateRow()
    {
        HBox cityStateRow = new HBox(5);
        lblCity = new Label("City");
        tfCity = new TextField();
        lblCity.setLabelFor(tfCity);

        lblState = new Label("State");
        tfState = new TextField();
        lblState.setLabelFor(tfState);

        cityStateRow.getChildren().addAll(lblCity, tfCity, lblState, tfState);
        return cityStateRow;
    }

    private HBox createPhoneNumberRow()
    {
        HBox phoneNumberRow = new HBox(5);
        lblTelephone = new Label("Phone Number");
        tfTelephone = new TextField();
        lblTelephone.setLabelFor(tfTelephone);

        phoneNumberRow.getChildren().addAll(lblTelephone, tfTelephone);
        return phoneNumberRow;
    }

    private HBox createButtonRow(VBox form)
    {
        HBox buttonRow = new HBox(5);
        btViewStaff = new Button("View");
        btViewStaff.setOnAction(e -> viewStaff(form));

        btInsertStaff = new Button("Insert");
        btInsertStaff.setOnAction(e -> insertStaff(form));

        btUpdateStaff = new Button("Update");
        btUpdateStaff.setOnAction(e -> updateStaff(form));

        btClearForm = new Button("Clear");
        btClearForm.setOnAction(e -> clearForm(form));

        buttonRow.getChildren().addAll(btViewStaff, btInsertStaff, btUpdateStaff, btClearForm);
        buttonRow.setAlignment(Pos.CENTER);
        return buttonRow;
    }

    private void viewStaff(VBox form)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT id, lastName, firstName, mi, address, city, state, telephone FROM staff ");
        sb.append(" WHERE id = ? ");

        try
        {
            PreparedStatement statement = connection.prepareStatement(sb.toString());
            statement.setString(1, tfID.getText());
            ResultSet result = statement.executeQuery();

            while (result.next())
            {
                tfID.setText(result.getString("id"));
                tfLastName.setText(result.getString("lastName"));
                tfFirstName.setText(result.getString("firstName"));
                tfMiddleName.setText(result.getString("mi"));
                tfAddress.setText(result.getString("address"));
                tfCity.setText(result.getString("city"));
                tfState.setText(result.getString("state"));
                tfTelephone.setText(result.getString("telephone"));
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void insertStaff(VBox form)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(" INSERT INTO staff ");
        sb.append(" (id, lastName, firstName, mi, address, city, state, telephone, email) ");
        sb.append(" VALUES ");
        sb.append(" (?, ?, ?, ?, ?, ?, ?, ?, ?) ");

        try
        {
            PreparedStatement statement = connection.prepareStatement(sb.toString());
            statement.setString(1, tfID.getText());
            statement.setString(2, tfLastName.getText());
            statement.setString(3, tfFirstName.getText());
            statement.setString(4, tfMiddleName.getText());
            statement.setString(5, tfAddress.getText());
            statement.setString(6, tfCity.getText());
            statement.setString(7, tfState.getText());
            statement.setString(8, tfTelephone.getText());
            statement.setString(9, "");
            statement.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void updateStaff(VBox form)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE staff ");
        sb.append(" SET id = ?, lastName = ?, firstName = ?, mi = ?, ");
        sb.append(" address = ?, city = ?, state = ?, telephone = ?, email = ? ");
        sb.append(" WHERE id = ? ");

        try
        {
            PreparedStatement statement = connection.prepareStatement(sb.toString());
            statement.setString(1, tfID.getText());
            statement.setString(2, tfLastName.getText());
            statement.setString(3, tfFirstName.getText());
            statement.setString(4, tfMiddleName.getText());
            statement.setString(5, tfAddress.getText());
            statement.setString(6, tfCity.getText());
            statement.setString(7, tfState.getText());
            statement.setString(8, tfTelephone.getText());
            statement.setString(9, "");
            statement.setString(10, tfID.getText());
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void clearForm(VBox form)
    {
        tfID.clear();
        tfLastName.clear();
        tfFirstName.clear();
        tfMiddleName.clear();
        tfAddress.clear();
        tfCity.clear();
        tfState.clear();
        tfTelephone.clear();
    }
}