package main.entities;

import main.BBMain;

import java.awt.*;

/**
 * Created by tayyibah on 26/09/2018.
 */
public class BrickMap {

    private int [][] brickMap;
    private int brickWidth;
    private int brickHeight;

    public final int HOR_PAD = 80, VERT_PAD = 50;

    public BrickMap(int row, int col) {
        initBrickMap(row,col);

        //set brick width and height
        brickWidth = (BBMain.WIDTH - 2 * HOR_PAD) / col;
        brickHeight = ((BBMain.HEIGHT / 2) - VERT_PAD*2) / row;
    }

    /**
     * Initialise the brickMap
     *
     * Will be changed later
     * @param row
     * @param col
     */
    private void initBrickMap(int row, int col) {
        brickMap = new int[row][col];
        for(int i = 0; i < brickMap.length; i++){
            for(int j= 0; j < brickMap[0].length; j++){
                brickMap[i][j] = 1;
            }
        }
    }



    public void draw(Graphics2D g){
        for(int row = 0; row < brickMap.length; row++){
            for(int col= 0; col < brickMap[0].length; col++){
                //Only redraw if its a visible block
                if(brickMap[row][col] == 1) {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(col * brickWidth + HOR_PAD, row * brickHeight + VERT_PAD, brickWidth, brickHeight);

                    g.setStroke(new BasicStroke(3));

                    g.setColor(Color.BLUE);
                    g.drawRect(col * brickWidth + HOR_PAD, row * brickHeight + VERT_PAD, brickWidth, brickHeight);
                }
            }
        }
    }

    public void update() {
    }

    public int[][] getBrickMap() {
        return brickMap;
    }

    public void setBrickStatus(int row, int col, int value){
        if(value < 1 || value > 1){
            value = 0;
        }
        brickMap[row][col] = value;
    }

    public Rectangle getBrickRectangle(int row, int col) {
        return new Rectangle(col * brickWidth + HOR_PAD, row * brickHeight + VERT_PAD, brickWidth, brickHeight);
    }
}
