package com.example.firstjavafxproject;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class PlayerCollisionChecker implements CollisionChecker {


    private Player player;
    private ArrayList<Enemy> enemies;
    private Pane root;
    private boolean playerCollision = false;
    private boolean enemyCollision = false;

    PlayerCollisionChecker(Player player, ArrayList<Enemy> enemies, Pane root){
        this.player = player;
        this.enemies = enemies;
        this.root = root;
    }


    public boolean collision(double left_bouond, double right_bound, double top_bound, double bottom_bound){
        boolean playerOutOfPanel = !(player.getBoundsInParent().intersects(root.getLayoutBounds()))
                || !(root.getLayoutBounds().contains((player.getBoundsInParent())));


        for(Enemy e : enemies){
            boolean playerCollideEnemy = player.getBoundsInParent().intersects(e.getBoundsInParent());

            if(playerCollideEnemy){
                System.out.println("player collision with enemy");
                playerCollision = true;

            } else if (playerOutOfPanel){
                if(player.getLayoutX() <= left_bouond){
                    player.setLayoutX(left_bouond);
                }
                if(player.getLayoutX() >= right_bound){
                    player.setLayoutX(right_bound);
                }
                if(player.getLayoutY() <= top_bound){
                    player.setLayoutY(top_bound);
                }
                if(player.getLayoutY() >= bottom_bound){
                    player.setLayoutY(bottom_bound);
                }

                System.out.println("player collision with pane");
                playerCollision = true;
            } else {
                playerCollision = false;
            }

        }
        return  playerCollision;
    }



}
