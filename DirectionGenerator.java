package com.example.firstjavafxproject;

import java.util.Random;

public class DirectionGenerator extends Thread{

    private int ran;



    @Override
    public void run() {


            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){

            }
            generateNum();
            System.out.println(getRan());


    }

    private int generateNum(){

        Random random = new Random();
        ran = random.nextInt(5);

        return ran;
    }

    public int getRan(){
        return ran;
    }
}
