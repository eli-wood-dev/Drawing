package com.example.drawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

import java.io.IOException;

/**
 * Allows the user to draw shapes
 *
 * @author EliWood
 * @version 1
 *
 */
public class Main extends Application {
    GraphicsContext gc;
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1200, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        Canvas canvas = new Canvas(1000, 700);

        root.getChildren().addAll(canvas);

        gc = canvas.getGraphicsContext2D();

        for(Shape s: shapes){
            s.draw(gc);
        }

        stage.show();
    }

    /**
     * launches the app
     *
     * @author EliWood
     * @version 1
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch();
    }
}