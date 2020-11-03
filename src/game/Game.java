package game;
import javax.swing.JFrame;
import java.awt.*;

public class Game extends JFrame{
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    public static boolean running = false;
    public static String currentLevel = "Level 1";
    public static String requestedLevel = "";


    public Game(){
        Square square = new Square();

        setDefaultCloseOperation(3); // makes the program close when the window is closed
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
        setTitle("Maze");
        setResizable(false);
        add(square);
    }

    public static void main(String[] args) {
        Game game = new Game();
        Square square = new Square();
        Menu menu = new Menu();
    }

    public void unPause(){
        if(requestedLevel == currentLevel){
            running = true;
        }
        else{
            //TODO: new level will have to be loaded

            Square.xpos = 0;
            Square.ypos = 0;

        }
    }
}
