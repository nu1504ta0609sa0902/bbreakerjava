package main.entities;

import java.awt.*;

/**
 * Created by tayyibah on 26/09/2018.
 */
public class HUD {

    public int score;

    public HUD(){
        score = 0;
    }

    public void draw(Graphics2D g){
        g.setColor(Color.PINK);
        g.drawString("SCORE: " + score, 20, 20);
    }
}
