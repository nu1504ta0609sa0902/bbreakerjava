package main;

import main.entities.Ball;
import main.entities.BrickMap;
import main.entities.Paddle;
import main.listeners.PaddleMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by tayyibah on 24/09/2018.
 */
public class GamePanel extends JPanel implements Runnable{

    //Mouse motion lisner
    PaddleMouseListener paddleMouseListener;

    // Panels
    boolean running;
    BufferedImage image;
    Graphics2D g;

    // Entity
    Ball theBall;
    Paddle thePaddle;
    BrickMap theMap;

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
        theMap = new BrickMap(5, 5);

        //Add listener
        paddleMouseListener = new PaddleMouseListener(thePaddle);
        addMouseMotionListener(paddleMouseListener);
    }

    @Override
    public void run() {
        //Game Loop
        while (running){
            //Update
            updateStates();
            //Render
            draw();
            //Display - repaint
            repaint();

            //Add a delay
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateStates() {
        collisionBallToPaddle();
        theBall.update();
    }

    private void collisionBallToPaddle() {
        Rectangle theBallRectangle = theBall.getRectangle();
        Rectangle thePaddleRectangle = thePaddle.getRectangle();
        if(theBallRectangle.intersects(thePaddleRectangle)){
            theBall.yDir = -theBall.yDir;
        }
    }

    public void draw() {
        //Draw background of the image (redraw)
        g.setColor(Color.WHITE);
        g.fillRect(0,0, BBMain.WIDTH, BBMain.HEIGHT);
        theBall.draw(g);
        thePaddle.draw(g);
        theMap.draw(g);
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
