import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        setTitle("Game L5 Software Engineering");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        add(new GamePanel());
        setVisible(true);
    }
}
