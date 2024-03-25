package com.example.firstjavafxproject;

import java.util.ArrayList;
import java.util.Random;

public class EnemyController extends Thread{

    private Enemy enemy;
    private int ran;
    public final int UP = 0;
    public final int DOWN = 1;
    public final int LEFT = 2;
    public final int RIGHT = 3;


    EnemyController(Enemy enemy){
        this.enemy = enemy;
    }

    public void run(){


    }

    public void enemyMovment(int direction){

        switch (direction){
            case UP:
                enemy.setMovingUp(true);
                break;
            case DOWN:
                enemy.setMovingDown(true);
                break;
            case LEFT:
                enemy.setMovingLeft(true);
                break;
            case RIGHT:
                enemy.setMovingRight(true);
                break;
        }


    }


}
