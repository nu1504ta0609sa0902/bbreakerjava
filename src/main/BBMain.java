package main;

import javax.swing.*;

/**
 * Created by tayyibah on 24/09/2018.
 */
public class BBMain {
    public final static int WIDTH = 640, HEIGHT = 480;

    public static void main(String args[]){

        //Create a frame for our game
        JFrame theFrame = new JFrame("Brick Breaker");
        GamePanel thePanel = new GamePanel();
        Thread theThread = new Thread(thePanel);
        theThread.start();

        theFrame.setSize(WIDTH, HEIGHT);
        theFrame.setResizable(false);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add Game panel to JFrame
        theFrame.add(thePanel);

        //Centrallise the location
        theFrame.setLocationRelativeTo(null);
        theFrame.setVisible(true);

    }
}
