package main;

import java.awt.*;

/**
 * Created by tayyibah on 25/09/2018.
 */
public class Ball {

    public int xPos;
    public int yPos;
    public int xDir;
    public int yDir;

    public int ballSizeWidth = 30;
    public int ballSizeHeight = 30;

    public Ball() {
        xPos = 200;
        yPos = 200;
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
        g.setStroke(new BasicStroke(3));
        g.drawOval(xPos, yPos, ballSizeWidth, ballSizeHeight);
    }
}
