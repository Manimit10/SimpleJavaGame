import java.awt.*;

public class Player {
    private int x;
    private final int y;
    private final int width;
    private final int height;

    public Player(int x, int y, int width, int height){
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public void move(int dx){
        x += dx;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}
