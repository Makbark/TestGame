package com.example.firstjavafxproject;

import javafx.scene.paint.Color;

public class MovableSprite extends Sprite{


    MovableSprite(int w, int h, Color color) {
        super(w, h, color);
    }

    public boolean getCollision() {
        return false;
    }
}
