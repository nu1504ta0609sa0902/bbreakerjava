package main.entities;

import main.BBMain;

import java.awt.*;

/**
 * Created by tayyibah on 25/09/2018.
 */
public class Paddle {

    //Paddle only moves in the x axis
    private int x;
    private int width;
    private int height;

    public final int YPOS = BBMain.HEIGHT - 100;

    public Paddle() {
        width = 100;
        height = 20;
        x = BBMain.WIDTH/2 - width/2;
    }

    public void update(){

    }

    public void draw(Graphics2D g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, YPOS, width, height);
    }

    public void mousePosition(int xPos){
        x = xPos;
    }
}
