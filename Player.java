package main;

import java.awt.*;
import java.awt.event.*;

public class Player {
    private int x, y;
    private int width = 50, height = 50;
    private boolean left, right, jumping;
    private int velocityY = 0;
    private int groundY = 500; // Y position of the ground

    public Player(int x, int y) {
        this.x = x;
        this.y = groundY - height; // Start the player above the ground
    }

    public void update() { // displacement
        if (left) x -= 5;
        if (right) x += 5;

        // Gravity: add 1 to the velocity when falling
        velocityY += 1; // gravity
        y += velocityY;

        // Ground collision
        if (y > groundY) {
            y = groundY; // Reset to ground level
            velocityY = 0; // Reset vertical velocity
            jumping = false; // don't allow jumping again
        }
        
        // Prevent the player from moving off the left side of the screen
        if (x < 0) {
            x = 0;
        }
        
        // Prevent the player from moving off the right side of the screen
        if (x > 1530 - width) {
            x = 1530 - width;
        }
    }

    public void draw(Graphics g) {
        // Draw the ground
        g.setColor(Color.GREEN);
        g.fillRect(0, groundY, 1920, 400); // Adjust width and height as needed

        // Draw the player
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, width, height);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !jumping) {
            jumping = true; // Set jumping to true
            velocityY = -15; // Jump strength (negative for upward motion)
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
    }
}
