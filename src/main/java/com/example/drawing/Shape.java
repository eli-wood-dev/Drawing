package com.example.drawing;

import javafx.scene.paint.Color;

/**
 * Abstract shape class
 *
 * @author EliWood
 * @version 1
 *
 */
public abstract class Shape implements Drawable{
    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected Color colour;
    protected Color stroke;
    protected int strokeWidth;

    /**
     * Constructor
     *
     * @author EliWood
     * @version 1
     *
     * @param x the x of the shape
     * @param y the y of the shape
     * @param width the width of the shape
     * @param height the height of the shape
     * @param colour the colour of the shape
     * @param stroke the colour of the outline
     * @param strokeWidth the width of the outline
     */
    public Shape(double x, double y, double width, double height, Color colour, Color stroke, int strokeWidth){
        this.colour = colour;
        this.y = y;
        this.x = x;
        this.width = width;
        this.height = height;
    }

    /**
     * gets the x of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @return the x of the shape
     */
    public double getX() {
        return x;
    }

    /**
     * sets the x of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @param x the new x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * gets the y of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @return the y of the shape
     */
    public double getY() {
        return y;
    }

    /**
     * sets the y of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @param y the new y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * gets the width of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @return the width of the shape
     */
    public double getWidth() {
        return width;
    }

    /**
     * sets the width of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @param width the new width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * gets the height of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @return the height of the shape
     */
    public double getHeight() {
        return height;
    }

    /**
     * sets the height of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @param height the new height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * gets the colour of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @return the shape's colour
     */
    public Color getColour() {
        return colour;
    }

    /**
     * sets the colour of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @param colour the new colour
     */
    public void setColour(Color colour) {
        this.colour = colour;
    }

    /**
     * gets the colour of the outline
     *
     * @author EliWood
     * @version 1
     *
     * @return the outline's colour
     */
    public Color getStroke() {
        return stroke;
    }

    /**
     * sets the colour of the outline
     *
     * @author EliWood
     * @version 1
     *
     * @param stroke the new outline colour
     */
    public void setStroke(Color stroke) {
        this.stroke = stroke;
    }

    /**
     * gets the outline thickness of the shape
     *
     * @author EliWood
     * @version 1
     *
     * @return the outline's thickness
     */
    public int getStrokeWidth() {
        return strokeWidth;
    }

    /**
     * sets the thickness of the outline
     *
     * @author EliWood
     * @version 1
     *
     * @param strokeWidth the new outline thickness
     */
    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}
