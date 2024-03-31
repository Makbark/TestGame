package com.example.firstjavafxproject;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestGame extends Application {
    private Pane root = new Pane();

    private HashMap<String,ArrayList<Sprite>> sprites = new HashMap();
    private Player player = new Player(275, 600, 40, 40, "player", Color.PURPLE, new ArrayList<Sprite>(),root);
    private Scene scene = new Scene(createContent());
    private PlayerController playerCon = new PlayerController(scene, player);
    private EnemyController enemyCon;
    private double t = 0;
    private boolean running = true;
    private Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        timer.start();
        timer2.start();
        playerCon.movementSetup();
        nextLevel();

        for(Sprite enemy: sprites){
            if(enemy instanceof MovableSprite){
                enemyCon = new EnemyController(enemy);
                enemyCon.enemyMovment(enemyCon.LEFT);
                System.out.println("o");
            }

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
            System.out.println(player.getLayoutX());
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


            for(Sprite enemy: sprites){
                if(enemy instanceof Enemy){
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



        }
    };

    private Parent createContent(){
        //root.setLayoutX(0);
        //root.setLayoutY(0);
        root.setMaxWidth(600);
        root.setMaxHeight(800);
        root.setPrefSize(600,800);
        root.getChildren().add(player);
        //System.out.println(root.getLayoutBounds());
        return root;
    }

    private void nextLevel() {
        ArrayList<Sprite> bariers = new ArrayList<>();

        Barier top_barier = new Barier(0, 0,600,100,"barier",Color.BLACK);
        Barier left_barier = new Barier(0,100,70,800,"barier",Color.BLACK);
        Barier right_barier = new Barier(530, 100,70,700,"barier",Color.BLACK);
        Barier bottom_barier = new Barier(70, 730,460,100,"barier",Color.BLACK);

        bariers.add(top_barier);
        bariers.add(left_barier);
        bariers.add(right_barier);
        bariers.add(bottom_barier);

        sprites.put("Bariers", bariers);

        root.getChildren().add(top_barier);
        root.getChildren().add(left_barier);
        root.getChildren().add(right_barier);
        root.getChildren().add(bottom_barier);
        //creates the enemies

        ArrayList<Sprite> enemies = new ArrayList<>();
        for (int i = 0; i < 2; i++) {

            Sprite enemy = new Enemy(90 + i*100, 150, 30, 30, "enemy", Color.RED, new ArrayList<Sprite>(),root);
            //add to array list of enemies

            if(!sprites.containsKey("Enemies")){
                sprites.put("Enemies", enemies);
            }
            sprites.get("Enemies").add(enemy);
            root.getChildren().add(enemy);
            player.addEnemies(enemy);
        }

        for(Sprite enemy: sprites){
            if (enemy instanceof Enemy) {
                for(int i = 0; i < sprites.size(); i++) {
                    if(sprites.get(i) != enemy){
                        enemy.addEnemies(sprites.get(i));
                    }
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
