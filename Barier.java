package com.example.firstjavafxproject;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Barier extends Sprite {
    private String type;

    Barier(int x, int y, int w, int h, String type, Color color){
        super(w,h,color);
        this.type = type;
        setTranslateX(x);
        setTranslateY(y);
    }




}
