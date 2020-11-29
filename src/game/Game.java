package game;

import javax.swing.JFrame;
import java.awt.*;
import java.util.Arrays;

public class Game extends JFrame {
    public static final int WINDOW_WIDTH = 1500;
    public static final int WINDOW_HEIGHT = 750;
    public static boolean running = false;
    public static String currentLevel = "";
    public static String requestedLevel = "";
    public static Square square;
    public static final int[] level1 = {0,9, 1,0, 1,1, 1,3, 1,4, 1,6, 1,8, 2,3, 2,6, 3,1, 3,2, 3,3, 3,4,
            3,5, 3,6, 3,7, 3,8, 4,1, 4,5, 4,7, 5,3, 5,7, 5,9, 6,0, 6,1, 6,2, 6,3, 6,4, 6,5, 6,7, 7,5,
            7,7, 7,8, 8,4, 8,5, 8,7, 8,8, 9,1, 9,2, 9,7, 10,2, 10,4, 10,5, 10,6, 10,7, 10,9, 11,0, 11,2,
            11,6, 12,2, 12,3, 12,4, 12,7, 12,8, 13,1, 13,2, 13,4, 13,5, 13,6, 14,5, 14,8, 14,9, 15,0,
            15,1, 15,4, 15,7, 16,1, 16,2, 16,3, 16,4, 17,1, 17,3, 17,4, 17,5, 17,6, 17,7, 17,8, 18,1,
            18,4, 18,8, 19,6};
    public static int size;
    public static int finishX;
    public static int finishY;
    public static int score = 800;
    public static int[] level = {};


    public Game() {
        Square square = new Square();

        setDefaultCloseOperation(3); // makes the program close when the window is closed
        setSize(WINDOW_WIDTH + 16, WINDOW_HEIGHT + 39);
        setVisible(true);
        setTitle("Maze");
        setResizable(false);
        add(square);
    }

    public static void main(String[] args) {
        Game game = new Game();
        square = new Square();
        Menu menu = new Menu();
    }

    public static void unPause() {
        running = true;
        if (!requestedLevel.equals(currentLevel)) {
            //TODO: new level will have to be loaded
            currentLevel = requestedLevel;
            if (currentLevel.equals("Level 1")) {
                level = level1;
                size = 75;
                score = 100;
                finishX = 16;
                finishY = 0;
            }
            Square.loadLevel();
        }
        square.repaint();
    }
}
