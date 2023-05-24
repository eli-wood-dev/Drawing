package com.example.drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Basic Line class
 *
 * @author EliWood
 * @version 1
 *
 */
public class Line extends Shape{
    /**
     * Constructor
     *
     * @author EliWood
     * @version 1
     *
     * @param x1 the first x coordinate
     * @param y1 the first y coordinate
     * @param x2 the second x coordinate
     * @param y2 the second y coordinate
     * @param colour the colour of the line
     * @param width the width of the line
     */
    public Line(double x1, double y1, double x2, double y2, Color colour, int width){
        super(x1, y1, x2-x1, y2-y1, colour, null, width);
    }

    /**
     * Draws the line
     *
     * @author EliWood
     * @version 1
     * @param gc the graphics context to draw the line on
     *
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(width);
        gc.setStroke(colour);
        gc.strokeLine(x, y, width + x, height + y);
    }
}
