package com.example.drawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

import java.io.IOException;

import javafx.scene.input.MouseButton;

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
    Alert a = new Alert(Alert.AlertType.NONE);


    public void reset(){
        //cover everything
        shapes.add(new Rectangle(0, 0, 1200, 600, Color.WHITE, Color.WHITE, 0));
        shapes.get(shapes.size()-1).draw(gc);

        //remove everything
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

        reset = new Button("Reset");
        circle = new Button("Circle");
        square = new Button("Rectangle");
        line = new Button("Line");

        root.getChildren().addAll(canvas, reset, circle, square, line);

        gc = canvas.getGraphicsContext2D();
        reset();//initialize

        //style and relocate
        reset.relocate(100, 650);
        circle.relocate(150, 650);
        square.relocate(200, 650);
        line.relocate(275, 650);

        //get user input
        //mouse

        //buttons
        try{
            reset.setOnAction(event -> reset());
        } catch(Exception e){
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Error");
            a.show();
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