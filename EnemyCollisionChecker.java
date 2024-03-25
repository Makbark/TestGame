package com.example.firstjavafxproject;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class EnemyCollisionChecker implements CollisionChecker {
    private Enemy enemy;
    private ArrayList<Enemy> enemies;
    private Pane root;
    private boolean enemyCollision = false;

    EnemyCollisionChecker(Enemy enemy, ArrayList<Enemy> enemies, Pane root){
        this.enemy = enemy;
        this.enemies = enemies;
        this.root = root;
    }

    public boolean collision(double left_bouond, double right_bound, double top_bound, double bottom_bound){

        boolean enemyOutOfPanel = !(enemy.getBoundsInParent().intersects(root.getLayoutBounds()))
                || !(root.getLayoutBounds().contains((enemy.getBoundsInParent())));
        //System.out.println(enemyOutOfPanel);
        boolean enemyCollideEnemy = false;




        if(enemyCollideEnemy){
            System.out.println("enemy collision with enemy");
            enemyCollision = true;
        }
        if (enemyOutOfPanel){

            if(enemy.getLayoutX() <= 10){
                enemy.setMovingLeft(false);
                enemy.setMovingRight(true);
            }
            if(enemy.getLayoutX() >= right_bound){
                enemy.setMovingRight(false);
                enemy.setMovingLeft(true);
            }
            if(enemy.getLayoutY() <= top_bound){
                enemy.setMovingUp(false);
                enemy.setMovingDown(true);
            }
            if(enemy.getLayoutY() >= bottom_bound){
                enemy.setMovingDown(false);
                enemy.setMovingUp(true);
            }

            System.out.println("enemy collision with pane");
             enemyCollision = true;
        } else {
             enemyCollision = false;
        }
        return enemyCollision;

    }



}
