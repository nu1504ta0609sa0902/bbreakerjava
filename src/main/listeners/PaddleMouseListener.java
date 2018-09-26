package main.listeners;

import main.entities.Paddle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by tayyibah on 25/09/2018.
 */
public class PaddleMouseListener implements MouseMotionListener {

    public static int mouseX;
    Paddle paddle;

    public PaddleMouseListener(Paddle paddle) {
        this.paddle = paddle;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        //We want the paddle to move when our mouse moves
        paddle.mousePosition(e.getX());
    }
}
