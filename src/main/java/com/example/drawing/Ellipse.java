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
     * @param x the x of the top left
     * @param y the y of the top left
     * @param width the width of the ellipse
     * @param height the height of the ellipse
     * @param colour the colour of the ellipse
     * @param stroke the colour of the outline
     * @param strokeWidth the width of the ellipse
     * @author EliWood
     * @version 1
     */
    public Ellipse(double x, double y, double width, double height, Color colour, Color stroke, int strokeWidth) {
        super(x, y, width, height, colour, stroke, strokeWidth);
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
        double tempX = x;
        double tempY = y;
        double tempW = width;
        double tempH = height;
        if(width < 0){
            tempX += tempW;
            tempW *= -1;
        }
        if(height < 0){
            tempY += tempH;
            tempH *= -1;
        }

        gc.strokeOval(tempX, tempY, tempW, tempH);
        gc.fillOval(tempX, tempY, tempW, tempH);
    }
}
