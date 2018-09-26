package main.entities;

import main.BBMain;

import java.awt.*;

/**
 * Created by tayyibah on 25/09/2018.
 */
public class Paddle {

    //Paddle only moves in the xPos axis
    private double xPos;
    private int width;
    private int height;

    public final int YPOS = BBMain.HEIGHT - 100;

    public Paddle() {
        width = 100;
        height = 20;
        xPos = BBMain.WIDTH/2 - width/2;
    }

    public void update(){

    }

    public void draw(Graphics2D g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int) xPos, YPOS, width, height);
    }

    public void mousePosition(int mousePosition){
        this.xPos = mousePosition;
        //Prevent paddle from going off the canvas
        if(xPos > BBMain.WIDTH - width - 5){
            this.xPos = BBMain.WIDTH - width - 5;
        }
    }

    public Rectangle getRectangle(){
        return new Rectangle((int)xPos, YPOS, width, height);
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
