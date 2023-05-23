package com.example.drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse extends Shape{

    /**
     * Constructor
     *
     * @param x the x of the ellipse
     * @param y the y of the ellipse
     * @param width the width of the ellipse
     * @param height the height of the ellipse
     * @param colour the colour of the ellipse
     * @param stroke the colour of the ellipse
     * @param strokeWidth the width of the ellipse
     * @author EliWood
     * @version 1
     */
    public Ellipse(double x, double y, double width, double height, Color colour, Color stroke, int strokeWidth) {
        super(x, y, width, height, colour, stroke, strokeWidth);
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(colour);
        gc.setStroke(stroke);
        gc.fillOval(x, y, width, height);
        gc.strokeOval(x, y, width, height);
    }
}
