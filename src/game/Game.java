package game;
import javax.swing.JFrame;
import java.awt.*;
import java.util.Arrays;

public class Game extends JFrame{
    public static final int WINDOW_WIDTH = 1500;
    public static final int WINDOW_HEIGHT = 750;
    public static boolean running = false;
    public static String currentLevel = "";
    public static String requestedLevel = "";
    public static Square square;
    public static final int[] level1 = {0,10, 1,0,  1,1,  1,3,  1,4,  1,6,  1,8};
    public static int size;
    public static int finishX;
    public static int finishY;
    public static int[] level = {};


    public Game(){
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

    public static void unPause(){
        running = true;
        if(requestedLevel.equals(currentLevel)){
            running = true;
        }
        else{
            //TODO: new level will have to be loaded
            currentLevel = requestedLevel;
            if(currentLevel.equals("Level 1")){
                level = level1;
                size = 75;
            }
        }
        square.repaint();
    }
}
