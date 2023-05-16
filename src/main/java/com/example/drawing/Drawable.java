package com.example.drawing;

import javafx.scene.canvas.GraphicsContext;

/**
 * An interface for a drawable object
 *
 * @author EliWood
 * @version 1
 *
 */
public interface Drawable {
    /**
     * Draw the object
     *
     * @author EliWood
     * @version 1
     * @param gc the graphics context to draw the object on
     *
     */
    public void draw(GraphicsContext gc);


}
