package main;

import main.entities.Ball;
import main.entities.Paddle;
import main.listeners.PaddleMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by tayyibah on 24/09/2018.
 */
public class GamePanel extends JPanel{

    //Mouse motion lisner
    PaddleMouseListener paddleMouseListener;

    // Panels
    boolean running;
    BufferedImage image;
    Graphics2D g;

    // Entity
    Ball theBall;
    Paddle thePaddle;

    public GamePanel(){
        init();
    }

    private void init() {
        running = true;
        image = new BufferedImage(BBMain.WIDTH, BBMain.HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        theBall = new Ball();
        thePaddle = new Paddle();

        //Add listener
        paddleMouseListener = new PaddleMouseListener(thePaddle);
        addMouseMotionListener(paddleMouseListener);
    }

    public void playGame() throws InterruptedException {
        //Game Loop
        while (running){
            //Update
            updateStates();
            //Render
            draw();
            //Display - repaint
            repaint();

            //Add a delay
            Thread.sleep(5);
        }
    }

    public void updateStates() {
        theBall.update();
        thePaddle.update();
    }

    public void draw() {
        //Draw background of the image (redraw)
        g.setColor(Color.WHITE);
        g.fillRect(0,0, BBMain.WIDTH, BBMain.HEIGHT);
        theBall.draw(g);
        thePaddle.draw(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Repaint whats in buffered image
        g2.drawImage(image, 0, 0, BBMain.WIDTH, BBMain.HEIGHT, null);

        g2.dispose();
    }
}
