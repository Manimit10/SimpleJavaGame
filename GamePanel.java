import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class GamePanel extends JPanel implements KeyListener {
    private Player player;
    private ArrayList<GameObject> objects;
    private Timer timer;
    private int score = 0;
    private String userName = "Player";

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);

        player = new Player(375, 500, 50, 20); // Initial position
        objects = new ArrayList<>();

        timer = new Timer(50, e -> {
            for (GameObject obj : objects) {
                obj.moveDown(5);
            }
            checkCollisions();
            repaint();
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        for (GameObject obj: objects) {
            obj.draw(g);
        }
        g.setColor(Color.WHITE);
        g.drawString("User: " + userName, 650, 20);
        g.drawString("Score: " + score, 650, 40);
    }

    private void checkCollisions() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject obj = objects.get(i);
            if (player.getBounds().intersects(obj.getBounds())) {
                if (obj instanceof Food) {
                    score += 10; // Increment score
                } else if (obj instanceof Enemy) {
                    score -= 10; // Decrement score
                }
                objects.remove(i); // Remove the object
                i--;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.move(-10);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.move(10);
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
