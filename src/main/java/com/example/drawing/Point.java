package com.example.drawing;

import javafx.scene.paint.Color;

public class Point extends Line{

    /**
     * Constructor
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param colour the colour of the segment
     * @param width the width of the segment
     * @author EliWood
     * @version 1
     */
    public Point(double x, double y, Color colour, int width) {
        super(x, y, x, y, colour, width);
    }
}
