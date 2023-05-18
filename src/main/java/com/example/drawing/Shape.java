package com.example.drawing;

/**
 * Abstract shape class
 *
 * @author EliWood
 * @version 1
 *
 */
public abstract class Shape implements Drawable{
    private double x;
    private double y;
    private double width;
    private double height;

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
}
