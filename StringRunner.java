import javax.swing.JFrame;
public class StringRunner 
{
    public static void main(String[] args) 
    {
        int width = 600;
        int height = 800;
        StringPanel panel = new StringPanel(width, height);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}