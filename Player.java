package com.example.firstjavafxproject;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Player extends MovableSprite{
    boolean dead;
    String type = "Player";
    private double velX = 0.0;
    private double velY = 0.0;
    private double x = getTranslateX();
    private double y = getTranslateY();
    private  int movementVariable = 2;
    private boolean w_pressed = false;
    private boolean a_pressed = false;
    private boolean s_pressed = false;
    private boolean d_pressed = false;
    private ArrayList<Sprite> enemies;
    private Pane root;
    private PlayerCollisionChecker collChecker;

    Player(int x, int y, int w, int h, String type, Color color,ArrayList<Sprite> enemies ,Pane root) {
        super(w, h, color);
        this.type = type;
        this.enemies = enemies;
        this.root = root;
        collChecker = new PlayerCollisionChecker(this, enemies, root);
        setTranslateX(x);
        setTranslateY(y);
    }

    public void moveLeft() {
        setLayoutX(getLayoutX() - movementVariable);
    }

    public void moveRight() {
        setLayoutX(getLayoutX() + movementVariable);
    }

    public void moveUp() {
        setLayoutY(getLayoutY() - movementVariable);
    }

    public void moveDown() {
        setLayoutY(getLayoutY() + movementVariable);
    }


    public boolean getCollision() {
        return collChecker.collision(-300,260,-750,10);
    }



    public void setW_pressed(boolean w_pressed) {this.w_pressed = w_pressed;}
    public void setA_pressed(boolean a_pressed){this.a_pressed = a_pressed;}
    public void setS_pressed(boolean s_pressed){this.s_pressed = s_pressed;}
    public void setD_pressed(boolean d_pressed){this.d_pressed = d_pressed;}

    public boolean getW_pressed() {
        return w_pressed;
    }
    public boolean getA_pressed(){
        return a_pressed;
    }
    public boolean getS_pressed(){
        return s_pressed;
    }
    public boolean getD_pressed(){
        return d_pressed;
    }

    public void setVelX(double velX){
        this.velX = velX;
    }
    public void setVelY(double velY){
        this.velY = velY;
    }

    public void addSprites(Sprite sprite){
        enemies.add(sprite);

    }
}
