package main;

import java.awt.*;
import java.awt.event.*;

public class Player {
    private int x, y;
    private int width = 50, height = 50;
    private boolean left, right, jumping;
    private int velocityY = 0;
    private int groundY;
    private int windowWidth, windowHeight;

    public Player(int x, int y, int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.groundY = windowHeight - 100; // Set ground 100 pixels from bottom
        this.x = x;
        this.y = groundY - height; // Start the player above the ground
    }

    public void update() {
        if (left) x -= 5;
        if (right) x += 5;

        velocityY += 1; // gravity
        y += velocityY;

        // Ground collision
        if (y > groundY - height) {
            y = groundY - height;
            velocityY = 0;
            jumping = false;
        }
        
        // Prevent the player from moving off the left side of the screen
        if (x < 0) {
            x = 0;
        }
        
        // Prevent the player from moving off the right side of the screen
        if (x > windowWidth - width) {
            x = windowWidth - width;
        }
    }

    public void draw(Graphics g) {
        // Draw the ground
        g.setColor(Color.GREEN);
        g.fillRect(0, groundY, windowWidth, windowHeight - groundY);

        // Draw the player
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, width, height);
    }

    // ... (rest of the code remains the same)

    public void updateWindowSize(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.groundY = windowHeight - 100; // Update ground position
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