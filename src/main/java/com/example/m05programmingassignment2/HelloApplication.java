package com.example.m05programmingassignment2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        Circle circle = new Circle(100, 100, 50, Color.WHITE);
        circle.setStroke(Color.BLACK);

        Pane pane = new Pane();
        pane.getChildren().add(circle);

        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> circle.setFill(Color.BLACK));
        pane.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> circle.setFill(Color.WHITE));

        Scene scene = new Scene(pane, 200, 200);
        stage.setTitle("Exercise15_7");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}