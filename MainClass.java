package main;

import javax.swing.JFrame;

public class MainClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Roguelike Platformer");
        Game game = new Game();
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        game.start();
    }
}