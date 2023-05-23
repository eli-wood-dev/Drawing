package com.example.drawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

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
    Button reset;
    //select shapes
    Button square;
    Button circle;
    Button line;


    public void reset(){
        for(int i = 0; i < shapes.size(); i++){
            shapes.remove(i);
            i--;
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        //setup
        Pane root = new Pane();
        Scene scene = new Scene(root, 1200, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        Canvas canvas = new Canvas(1200, 600);

        reset = new Button("reset");

        root.getChildren().addAll(canvas, reset);

        gc = canvas.getGraphicsContext2D();

        //style and relocate
        reset.relocate(100, 650);

        //get user input
        //mouse

        //buttons
        try{
            reset.setOnAction(event -> reset());
        } catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Unknown Error");//default error, shouldn't reach
        }
        //draw shapes
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