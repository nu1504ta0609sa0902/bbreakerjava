package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by tayyibah on 24/09/2018.
 */
public class GamePanel extends JPanel{

    boolean running;
    BufferedImage image;
    Graphics2D g;

    public GamePanel(){
        init();
    }

    private void init() {
        image = new BufferedImage(BBMain.WIDTH, BBMain.HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
    }

    public void playGame() {
        //Game Loop
        while (running){
            //Update
            updateStates();
            //Render
            draw();
            //Display - repaint
        }
    }

    private void updateStates() {

    }

    private void draw() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }
}
