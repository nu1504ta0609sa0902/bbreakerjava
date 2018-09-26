package main.entities;

import main.BBMain;

import java.awt.*;

/**
 * Created by tayyibah on 25/09/2018.
 */
public class Ball {

    public double xPos;
    public double yPos;
    public double xDir;
    public double yDir;

    public int ballSizeWidth = 15;
    public int ballSizeHeight = 15;

    public Ball() {
        xPos = BBMain.WIDTH/2;
        yPos = BBMain.HEIGHT * 0.6;
        xDir = 1;
        yDir = 3;
    }

    /**
     * Updates the postion of the ball
     */
    public void update(){
        setPosition();
    }

    private void setPosition() {
        xPos += xDir;
        yPos += yDir;

        //Logic to check if edge of frame is reached
        if(xPos < 0){
            xDir = -xDir;
        }
        if(yPos < 0){
            yDir = -yDir;
        }

        if(xPos > BBMain.WIDTH - ballSizeWidth){
            xDir = -xDir;
        }
        if(yPos > BBMain.HEIGHT - ballSizeHeight){
            yDir = -yDir;
        }
    }

    /**
     * Redraws the ball on the canvas
     */
    public void draw(Graphics2D g){
        g.setColor(Color.CYAN);
        g.setStroke(new BasicStroke(2));
        //g.drawOval((int)xPos, (int)yPos, ballSizeWidth, ballSizeHeight);
        g.fillOval((int)xPos, (int)yPos, ballSizeWidth, ballSizeHeight);
    }

    public Rectangle getRectangle(){
        return new Rectangle((int)xPos, (int)yPos, ballSizeWidth, ballSizeHeight);
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyDir() {
        return yDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }

    public double getxDir() {
        return xDir;
    }

    public void setxDir(double xDir) {
        this.xDir = xDir;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }
}
