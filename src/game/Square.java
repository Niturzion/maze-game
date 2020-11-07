package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Square extends JPanel implements KeyListener {

    public Square(){
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
    }
    public static int[] obstacles = {1, 1, 4, 5};
    public static int numberOfObstacles = 2;
    public static int xpos = 0;
    public static int ypos = 0;
    public static int SQUARE_SIZE = 75;
    public static int finishX = 5;
    public static int finishY = 5;

@Override
    protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.setBackground(Color.WHITE);
            int i = 0;

            //draw the box
            g.setColor(Color.ORANGE);
            g.fillRect(xpos, ypos, SQUARE_SIZE, SQUARE_SIZE);

            //draw all the obstacles using the coordinates in list obstacles
            g.setColor(Color.BLACK);
            while(i < numberOfObstacles + 1){
                g.fillRect(obstacles[i] * SQUARE_SIZE, obstacles[i+1] * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                i += 2;
            }

            g.setColor(Color.GREEN);
            g.fillRect(finishX * SQUARE_SIZE, finishY * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        char ch = e.getKeyChar();

        //detect key press and move the square. If square moves past boundaries, reset position.
        if(Game.running){
            if (ch == 'w') {
                movePlayer("Up");
            } else if (ch == 'a') {
                movePlayer("Left");
            } else if (ch == 's') {
                movePlayer("Down");
            } else if (ch == 'd') {
                movePlayer("Right");
            } else if (ch == 'p') {
                Menu.loadMenu();
            }
        }
        repaint();
        }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void loadLevel(int[] level, int finishX, int finishY, int size){
    SQUARE_SIZE = size;
    obstacles = level;
    numberOfObstacles = level.length;
    xpos = 0;
    ypos = 0;
    }

    public void movePlayer(String direction){
    boolean canMove = true;
    int newXpos = 0;
    int newYpos = 0;
    int i = 0;
        if(direction.equals("Left")){
           newXpos = xpos - SQUARE_SIZE;
           newYpos = ypos;
           }
        if(direction.equals("Right")){
            newXpos = xpos + SQUARE_SIZE;
            newYpos = ypos;
        }
        if(direction.equals("Up")){
            newXpos = xpos;
            newYpos = ypos - SQUARE_SIZE;
        }
        if(direction.equals("Down")){
            newXpos = xpos;
            newYpos = ypos + SQUARE_SIZE;
        }

        //hit detection with the map.
        while(i < numberOfObstacles + 1){
            if(newXpos == obstacles[i] * SQUARE_SIZE && newYpos == obstacles[i+1] * SQUARE_SIZE){
                canMove = false;
            }
            i += 2;
        }

        if(canMove){
            xpos = newXpos;
            ypos = newYpos;

            //prevent square from moving off map.
            if(xpos < 0){
                xpos = 0;
            }
            else if (xpos > Game.WINDOW_WIDTH - SQUARE_SIZE){
                xpos = Game.WINDOW_WIDTH - SQUARE_SIZE;
            }
            if(ypos < 0){
                ypos = 0;
            }
            else if (ypos > Game.WINDOW_HEIGHT - SQUARE_SIZE){
                ypos = Game.WINDOW_HEIGHT - SQUARE_SIZE;
            }
        }
    }
}
