package com.example.drawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javafx.scene.control.*;

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
    Button free;
    Alert a = new Alert(Alert.AlertType.NONE);
    Shape selected; //what shape is currently selected
    ColorPicker cPicker;
    ColorPicker sPicker;
    TextField sSelect;
    int strokeWidth;

    /**
     * clears the screen then draws all the shapes
     *
     * @author EliWood
     * @version 1
     *
     */
    public void drawAll(){
        new Rectangle(0, 0, 1200, 600, Color.WHITE, Color.WHITE, 0).draw(gc);

        for(Shape s : shapes){
            s.draw(gc);
        }

    }

    /**
     * clears the screen then deletes everything
     *
     * @author EliWood
     * @version 1
     *
     */
    public void reset(){
        //cover everything
        new Rectangle(0, 0, 1200, 600, Color.WHITE, Color.WHITE, 0).draw(gc);

        //remove everything
        shapes.clear();
    }

    /**
     * selects a rectangle as your drawing shape
     *
     * @author EliWood
     * @version 1
     *
     */
    public void selectRect(){
        selected = new Rectangle(0, 0, 0, 0, null, null, 0);//empty rect
    }

    /**
     * selects an ellipse as your drawing shape
     *
     * @author EliWood
     * @version 1
     *
     */
    public void selectEllipse(){
        selected = new Ellipse(0, 0, 0, 0, null, null, 0);//empty ellipse
    }

    /**
     * selects a line as your drawing shape
     *
     * @author EliWood
     * @version 1
     *
     */
    public void selectLine(){
        selected = new Line(0, 0, 0, 0, null, 0);//empty line
    }

    /**
     * selects free draw as your drawing shape
     *
     * @author EliWood
     * @version 1
     *
     */
    public void selectFree(){
        selected = new Point(0, 0, null, 0);
    }

    /**
     * constantly updates your shape based on mouse position
     *
     * @author EliWood
     * @version 1
     *
     * @param mouse the user's mouse
     */
    public void drawShape(MouseEvent mouse){
        try {
            getStroke();
        } catch (Exception e) {
            a.setAlertType(Alert.AlertType.WARNING);
            a.setContentText(e.getMessage());
            a.show();
        }

        sSelect.setText(String.valueOf(strokeWidth));
        Shape temp = shapes.get(shapes.size()-1);
        if(temp instanceof Point){
            shapes.add(new Line(temp.getX(), temp.getY(), mouse.getX(), mouse.getY(), cPicker.getValue(), strokeWidth));
            shapes.add(new Point(mouse.getX(), mouse.getY(), cPicker.getValue(), strokeWidth));
        } else if(temp instanceof Line){
            temp.setWidth(mouse.getX() - temp.getX());
            temp.setHeight(mouse.getY() - temp.getY());
        } else if (temp instanceof Ellipse || temp instanceof Rectangle){
            temp.setWidth(mouse.getX() - temp.getX());
            temp.setHeight(mouse.getY() - temp.getY());
        }

        drawAll();
    }

    /**
     * creates a shape at the mouse's position
     *
     * @author EliWood
     * @version 1
     *
     * @param mouse the user's mouse
     */
    public void startShape(MouseEvent mouse){
        try {
            getStroke();
        } catch (Exception e) {
            a.setAlertType(Alert.AlertType.WARNING);
            a.setContentText(e.getMessage());
            a.show();
        }

        sSelect.setText(String.valueOf(strokeWidth));
        if(selected instanceof Point){
            shapes.add(new Point(mouse.getX(), mouse.getY(), cPicker.getValue(), strokeWidth));
        } else if(selected instanceof Line){
            shapes.add(new Line(mouse.getX(), mouse.getY(), mouse.getX(), mouse.getY(), cPicker.getValue(), strokeWidth));
        } else if (selected instanceof Ellipse) {
            shapes.add(new Ellipse(mouse.getX(), mouse.getY(), 0, 0, cPicker.getValue(), sPicker.getValue(), strokeWidth));
        } else if (selected instanceof Rectangle) {
            shapes.add(new Rectangle(mouse.getX(), mouse.getY(), 0, 0, cPicker.getValue(), sPicker.getValue(), strokeWidth));
        }
        shapes.get(shapes.size()-1).draw(gc);
    }

    /**
     * gets the value from the stroke text box
     *
     * @author EliWood
     * @version 1
     *
     * @throws Exception if the number is invalid
     */
    public void getStroke() throws Exception{
        strokeWidth = 2;
        try {
            strokeWidth = Integer.parseInt(sSelect.getText());
        } catch(Exception e){
            throw new Exception("Invalid number selected");
        }
        if(strokeWidth <= 0){
            throw new Exception("Requires positive number");
        }
    }

    /**
     * main drawing program
     *
     * @author EliWood
     * @version 1
     *
     * @param stage the stage to draw on
     */
    @Override
    public void start(Stage stage){
        //setup
        Pane root = new Pane();
        Scene scene = new Scene(root, 1200, 700);
        stage.setTitle("Bad paint");
        stage.setScene(scene);

        Canvas canvas = new Canvas(1200, 600);

        reset = new Button("Reset");
        circle = new Button("Circle");
        square = new Button("Rectangle");
        line = new Button("Line");
        free = new Button("Free Draw");

        cPicker = new ColorPicker(Color.BLACK);
        sPicker = new ColorPicker(Color.BLACK);

        sSelect = new TextField("2");

        root.getChildren().addAll(canvas, reset, circle, square, line, free, cPicker, sPicker, sSelect);

        gc = canvas.getGraphicsContext2D();
        reset();//initialize

        //style and relocate
        reset.relocate(100, 650);
        circle.relocate(150, 650);
        square.relocate(200, 650);
        line.relocate(275, 650);
        free.relocate(325, 650);

        cPicker.relocate(400, 650);
        sPicker.relocate(525, 650);

        sSelect.relocate(650, 650);

        selectFree();

        //get user input

        //buttons
        try{
            reset.setOnAction(event -> reset());
            circle.setOnAction(event -> selectEllipse());
            square.setOnAction(event -> selectRect());
            line.setOnAction(event -> selectLine());
            free.setOnAction(event -> selectFree());

            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, mouse -> {

                try {
                    startShape(mouse);
                } catch (Exception e) {
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("No Shape Selected");
                    a.show();
                }

            });
            canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, mouse -> {
                try {
                    drawShape(mouse);
                } catch (Exception e) {
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("No Shape Selected");
                    a.show();
                }
            });
        } catch(Exception e){
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Error");
            a.show();
        }
        //draw shapes
        drawAll();

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