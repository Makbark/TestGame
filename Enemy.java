package com.example.firstjavafxproject;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Enemy extends MovableSprite {
    boolean dead;
    String type = "Player";
    private double velX = 0.0;
    private double velY = 0.0;
    private double x = getTranslateX();
    private double y = getTranslateY();
    private int movementVariable = 2;
    private boolean movingUp = false;
    private boolean movingLeft = false;
    private boolean movingDown = false;
    private boolean movingRight = false;
    private ArrayList<Sprite> enemies;
    private Pane root;
    private EnemyCollisionChecker collChecker;

    Enemy(int x, int y, int w, int h, String type, Color color,ArrayList<Sprite> enemies,Pane root) {
        super(w, h, color);
        this.type = type;
        this.enemies = enemies;
        this.root = root;
        collChecker = new EnemyCollisionChecker(this, enemies, root);
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

    public boolean getMovingUp(){return movingUp; }
    public boolean getMovingDown(){return movingDown; }
    public boolean getMovingLeft(){return movingLeft; }
    public boolean getMovingRight(){return movingRight; }

    public void setMovingUp(boolean movingUp){this.movingUp = movingUp; }
    public void setMovingDown(boolean movingDown){this.movingDown = movingDown; }
    public void setMovingLeft(boolean movingLeft){this.movingLeft = movingLeft; }
    public void setMovingRight(boolean movingRight){this.movingRight = movingRight; }




    public boolean getCollision() {
        return collChecker.collision(0,0,-750,10);
    }

    public void addSprites(Sprite sprites){
        enemies.add(sprites);
    }
    public ArrayList<Sprite> getSprites(){
        return enemies;
    }
}
