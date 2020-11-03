package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Menu extends JFrame implements ActionListener {
    public static final int HORIZONTAL_OFFSET = 15;
    public static final int VERTICAL_OFFSET = 25;
    public static final int WIDGET_WIDTH = 200;
    public static final int WIDGET_HEIGHT = 50;
    public static final int VERTICAL_WIDGET_SPACING = 20;
    public static JComboBox<String> levelSelect;

    public Menu(){
        MyMenu();
    }
    public void MyMenu(){
        //initialise panel
        String[] levels = {"Level 1"};
        JPanel menuPanel = new JPanel();
        menuPanel.setVisible(true);
        menuPanel.setLayout(null);

        String text = "PAUSE";
        JLabel menuLbl = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
        menuLbl.setSize(WIDGET_WIDTH, WIDGET_HEIGHT);
        menuLbl.setLocation(50, 50);
        menuLbl.setVisible(true);

        JButton playButton = new JButton("Play");
        playButton.setSize(WIDGET_WIDTH, WIDGET_HEIGHT);
        playButton.setLocation(HORIZONTAL_OFFSET, VERTICAL_OFFSET + WIDGET_HEIGHT + VERTICAL_WIDGET_SPACING);
        playButton.setVisible(true);
        playButton.addActionListener(this);
        playButton.setActionCommand("Play");

        JButton exitButton = new JButton("Exit");
        exitButton.setSize(WIDGET_WIDTH, WIDGET_HEIGHT);
        exitButton.setLocation(HORIZONTAL_OFFSET, VERTICAL_OFFSET + (WIDGET_HEIGHT*2) + (VERTICAL_WIDGET_SPACING*2));
        exitButton.setVisible(true);
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Exit");

        levelSelect = new JComboBox<String>(levels);
        levelSelect.setSize(WIDGET_WIDTH, WIDGET_HEIGHT);
        levelSelect.setLocation(HORIZONTAL_OFFSET, VERTICAL_OFFSET + (WIDGET_HEIGHT*3) + (VERTICAL_WIDGET_SPACING*3));
        levelSelect.setVisible(true);

        menuPanel.add(menuLbl);
        menuPanel.add(playButton);
        menuPanel.add(exitButton);
        menuPanel.add(levelSelect);

        //initialise frame
        Dimension dimension = new Dimension(250, 400);
        setPreferredSize(dimension);
        setTitle("Menu");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        add(menuPanel);
        pack();
        setVisible(true);
    }

    public static void loadMenu(){
        //creates a new menu JFrame
        Menu menu = new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Play"){
            Game.currentLevel = levelSelect.getSelectedItem().toString();
            Game.running = true;
            setVisible(true);
            dispose();
        }
        else if(e.getActionCommand() == "Exit"){
            System.exit(1);
        }
    }
}
