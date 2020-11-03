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

    public static int xpos = 0;
    public static int ypos = 0;
    public static final int SQUARE_SIZE = 30;
    public static final int DISTANCE_MOVED = 30;

@Override
    protected void paintComponent(Graphics g) {
        if(Game.running) {
            super.paintComponent(g);
            this.setBackground(Color.WHITE);

            //draw the box
            g.setColor(Color.ORANGE);
            g.fillRect(xpos, ypos, SQUARE_SIZE, SQUARE_SIZE);

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        char ch = e.getKeyChar();

        //detect key press and move the square. If square moves past boundaries, reset position.
        if(Game.running){
            if (ch == 'w') {
                ypos -= DISTANCE_MOVED;
                if (ypos < 0) {
                    ypos = 0;
                }
            } else if (ch == 'a') {
                xpos -= DISTANCE_MOVED;
                if (xpos < 0) {
                    xpos = 0;
                }
            } else if (ch == 's') {
                ypos += DISTANCE_MOVED;
                if (ypos > Game.WINDOW_HEIGHT - SQUARE_SIZE) {
                    ypos = Game.WINDOW_HEIGHT - SQUARE_SIZE;
                }
            } else if (ch == 'd') {
                xpos += DISTANCE_MOVED;
                if (xpos > Game.WINDOW_WIDTH - SQUARE_SIZE) {
                    xpos = Game.WINDOW_WIDTH - SQUARE_SIZE;
                }
            } else if (ch == 'p') {
                Menu.loadMenu();
                Game.running = false;
            }
        }
        repaint();
        }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
