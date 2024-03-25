package com.example.firstjavafxproject;

import javafx.scene.shape.Rectangle;

public interface Entity {

    void moveLeft();
    void moveRight();
    void moveUp();
    void moveDown();

    boolean getCollision();

}
