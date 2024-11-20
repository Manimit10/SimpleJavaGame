import java.awt.*;

public class Food extends GameObject {
    public Food(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
}
