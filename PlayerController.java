package com.example.firstjavafxproject;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class PlayerController {
    private Scene scene;
    private Player player;

    PlayerController(Scene scene, Player player){
        this.scene = scene;
        this.player = player;
    }

    public void movementSetup() {
        //Player movement
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                player.setW_pressed(true);
            }
            if (event.getCode() == KeyCode.A) {
                player.setA_pressed(true);
            }
            if (event.getCode() == KeyCode.S) {
                player.setS_pressed(true);
            }
            if (event.getCode() == KeyCode.D) {
                player.setD_pressed(true);
            }
        });
        //If key is released set if the key is pressed to fasle to stop movement in that direction
        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.W) {
                player.setW_pressed(false);
            }
            if (event.getCode() == KeyCode.A) {
                player.setA_pressed(false);
            }
            if (event.getCode() == KeyCode.S) {
                player.setS_pressed(false);
            }
            if (event.getCode() == KeyCode.D) {
                player.setD_pressed(false);
            }
        });
    }


}
