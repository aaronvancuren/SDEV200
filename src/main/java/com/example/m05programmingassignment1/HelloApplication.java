package com.example.m05programmingassignment1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(5));

        HBox rowOne = new HBox();
        rowOne.setPadding(new Insets(5));
        rowOne.setSpacing(5);
        Image image = new Image("D:\\Projects\\SDEV200\\M05ProgrammingAssignment1\\src\\image\\us.gif");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(150);
        rowOne.getChildren().add(imageView);

        image = new Image("D:\\Projects\\SDEV200\\M05ProgrammingAssignment1\\src\\image\\ca.gif");
        imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(150);
        rowOne.getChildren().add(imageView);

        HBox rowTwo = new HBox();
        rowTwo.setPadding(new Insets(5));
        rowTwo.setSpacing(5);

        image = new Image("D:\\Projects\\SDEV200\\M05ProgrammingAssignment1\\src\\image\\uk.gif");
        imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(150);
        rowTwo.getChildren().add(imageView);

        image = new Image("D:\\Projects\\SDEV200\\M05ProgrammingAssignment1\\src\\image\\china.gif");
        imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(150);
        rowTwo.getChildren().add(imageView);

        vBox.getChildren().add(rowOne);
        vBox.getChildren().add(rowTwo);

        Scene scene = new Scene(vBox);
        stage.setTitle("Exercise14_01");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}