package com.example.drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Basic Ellipse class
 *
 * @author EliWood
 * @version 1
 *
 */
public class Ellipse extends Shape{

    /**
     * Constructor
     *
     * @param x the x of the center
     * @param y the y of the center
     * @param width the width of the ellipse
     * @param height the height of the ellipse
     * @param colour the colour of the ellipse
     * @param stroke the colour of the outline
     * @param strokeWidth the width of the ellipse
     * @author EliWood
     * @version 1
     */
    public Ellipse(double x, double y, double width, double height, Color colour, Color stroke, int strokeWidth) {
        super(x - width/2, y - height/2, width, height, colour, stroke, strokeWidth);
    }

    /**
     * Draws the ellipse
     *
     * @author EliWood
     * @version 1
     * @param gc the graphics context to draw the ellipse on
     *
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(colour);
        gc.setStroke(stroke);
        gc.setLineWidth(strokeWidth);
        gc.fillOval(x, y, width, height);
        gc.strokeOval(x, y, width, height);
    }
}
