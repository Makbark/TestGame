package com.example.firstjavafxproject;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite extends Rectangle {

    public String getType(){
       return null;
    }
    Sprite(int w, int h, Color color){
        super(w,h,color);
    }

    public void setMovingUp(boolean movingUp){}
    public void setMovingDown(boolean movingDown){}
    public void setMovingLeft(boolean movingLeft){}
    public void setMovingRight(boolean movingRight){}

    public void addEnemies(Sprite enemy){
    }

    public void moveLeft() {

    }

    public void moveRight() {

    }

    public void moveUp() {

    }

    public void moveDown() {

    }

    public boolean getMovingUp(){return false;}
    public boolean getMovingDown(){return false;}
    public boolean getMovingLeft(){return false;}
    public boolean getMovingRight(){return false;}

    public boolean getCollision() {
        return false;
    }
}
