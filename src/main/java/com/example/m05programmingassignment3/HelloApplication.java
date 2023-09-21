package com.example.m05programmingassignment3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        VBox vBox = new VBox();

        StackPane textPane = new StackPane();
        Text showColors = new Text("Show Colors");
        showColors.setTextAlignment(TextAlignment.CENTER);
        textPane.getChildren().add(showColors);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);

        gridPane.add(new Label("Red"), 0, 0);
        ScrollBar redScrollBar = new ScrollBar();
        redScrollBar.setMax(255);
        redScrollBar.setBlockIncrement(1);
        redScrollBar.valueProperty().addListener(e -> changeTextColor(showColors, redScrollBar, "Red"));
        gridPane.add(redScrollBar, 1, 0);

        gridPane.add(new Label("Green"), 0, 1);
        ScrollBar greenScrollBar = new ScrollBar();
        greenScrollBar.setMax(255);
        greenScrollBar.setBlockIncrement(1);
        greenScrollBar.valueProperty().addListener(e -> changeTextColor(showColors, greenScrollBar, "Green"));
        gridPane.add(greenScrollBar, 1, 1);

        gridPane.add(new Label("Blue"), 0, 2);
        ScrollBar blueScrollBar = new ScrollBar();
        blueScrollBar.setMax(255);
        blueScrollBar.setBlockIncrement(1);
        blueScrollBar.valueProperty().addListener(e -> changeTextColor(showColors, blueScrollBar, "Blue"));
        gridPane.add(blueScrollBar, 1, 2);

        gridPane.add(new Label("Opacity"), 0, 3);
        ScrollBar opacityScrollBar = new ScrollBar();
        opacityScrollBar.setMax(1);
        opacityScrollBar.setBlockIncrement(.01);
        opacityScrollBar.setUnitIncrement(.01);
        opacityScrollBar.setValue(opacityScrollBar.getMax());
        opacityScrollBar.valueProperty().addListener(e -> changeTextColor(showColors, opacityScrollBar, "Opacity"));
        gridPane.add(opacityScrollBar, 1, 3);

        vBox.getChildren().add(textPane);
        vBox.getChildren().add(gridPane);

        Scene scene = new Scene(vBox, 250, 250);
        stage.setTitle("Exercise16_17");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeTextColor(Text text, ScrollBar scrollBar, String valueChanged)
    {
        Color textFill = (Color) text.getFill();
        int red = (int) (textFill.getRed() * 255);
        int green = (int) (textFill.getGreen() * 255);
        int blue = (int) (textFill.getBlue() * 255);
        double opacity = textFill.getOpacity();

        switch (valueChanged)
        {
            case "Red" -> red = (int) scrollBar.getValue();
            case "Green" -> green = (int) scrollBar.getValue();
            case "Blue" -> blue = (int) scrollBar.getValue();
            case "Opacity" -> opacity = scrollBar.getValue();
        }

        text.setFill(Color.rgb(red, green, blue, opacity));
    }

    public static void main(String[] args)
    {
        launch();
    }
}