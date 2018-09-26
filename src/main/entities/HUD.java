package main.entities;

import java.awt.*;

/**
 * Created by tayyibah on 26/09/2018.
 */
public class HUD {
    public int scorePerBoard = 10;
    public int totalScore;

    public HUD(){
        totalScore = 0;
    }

    public void draw(Graphics2D g){
        g.setColor(Color.PINK);
        g.drawString("SCORE: " + totalScore, 20, 20);
    }
}
