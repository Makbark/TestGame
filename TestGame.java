package com.example.firstjavafxproject;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestGame extends Application {
    private Pane root = new Pane();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Player player = new Player(300, 750, 40, 40, "player", Color.PURPLE, new ArrayList<Enemy>(),root);
    private Scene scene = new Scene(createContent());
    private PlayerController playerCon = new PlayerController(scene, player);
    private EnemyController enemyCon;
    private double t = 0;
    private boolean running = true;
    @Override
    public void start(Stage stage) throws Exception {

        timer.start();
        timer2.start();
        playerCon.movementSetup();
        nextLevel();

        for(Enemy enemy: enemies){

            enemyCon = new EnemyController(enemy);
            enemyCon.enemyMovment(enemyCon.LEFT);
            System.out.println("o");
        }
        stage.setScene(scene);
        stage.show();
    }

    public boolean isRunning() {
        return running;
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {

            player.getCollision();
            //System.out.println(player.getLayoutX());
            //checks the boolean value of if the key is press and if it is it will move in the direction of corresponding key
            if(player.getW_pressed()){
                player.moveUp();
            }
            if(player.getA_pressed()){
                player.moveLeft();
            }
            if(player.getS_pressed()){
                player.moveDown();
            }
            if(player.getD_pressed()){
                player.moveRight();
            }
        }
    };
    AnimationTimer timer2 = new AnimationTimer() {
        private long lastUpdate = 0;
        @Override
        public void handle(long timestamp) {


            for(Enemy enemy: enemies){
                enemy.getCollision();
                //System.out.println(enemy.getLayoutX());
                if(enemy.getMovingLeft()){
                    enemy.moveLeft();
                }
                if(enemy.getMovingRight()){
                    enemy.moveRight();
                }
                if(enemy.getMovingUp()){
                    enemy.moveUp();
                }
                if(enemy.getMovingDown()){
                    enemy.moveDown();
                }
            }



        }
    };

    private Parent createContent(){

        root.setPrefSize(600,800);
        root.getChildren().add(player);//might not work

        return root;
    }

    private void nextLevel() {

        //creates the enemies
        for (int i = 0; i < 2; i++) {

            Enemy s = new Enemy(90 + i*100, 150, 30, 30, "enemy", Color.RED, new ArrayList<Enemy>(), root);
            //add to array list of enemies

            enemies.add(s);
            root.getChildren().add(s);
            player.addEnemies(s);
        }

        for(Enemy enemy: enemies){
            for(int i = 0; i < enemies.size(); i++) {
                if(enemies.get(i) != enemy){
                    enemy.addEnemies(enemies.get(i));
                }
            }
        }


    }

    private List<Player> players() {
        return root.getChildren().stream().map(n -> (Player)n).collect(Collectors.toList());
    }

    private void update(){
        t += 0.016;

        root.getChildren().removeIf(n -> {
            Player s = (Player) n;
            return s.dead;
        });

        if (t > 2) {
            t = 0;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
