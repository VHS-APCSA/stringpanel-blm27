import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
public class StringPanel extends JPanel implements Runnable
{
	private int width;
	private int height;
	private Thread thread;
	private String word;
	private int wordX, wordY;
	private int wordVx, wordVy;
	private Color changeColor;
	public StringPanel() 
	{
		width = 0;
		height = 0;
		word = "";
		wordX = wordY = 0;
		wordVx = wordVy = 0;
		changeColor = Color.black;
		
	}
	public StringPanel(int width, int height)
	{
		thread = new Thread(this);
		thread.start();
		this.width = width;
		this.height = height;
		word = "runnable";
		wordX = width / 2;
		wordY = height / 2;
		wordVx = (int)(Math.random() * 7) + 3;
		wordVy = (int)(Math.random() * 7) + 3;
		setBackground(Color.black);
	}
	@Override
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) { 
				System.out.println("Thread stopped");
				thread.interrupt();
				return;
			}
			repaint();
		}
	}
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.setColor(changeColor);
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, 24));
		width = getWidth();
		height = getHeight();
		g.drawString(word, wordX, wordY);
		if(wordX > width)
		{
			changeColor = Color.blue;
			wordVx
		}

		wordX += wordVx;
		wordY += wordVy;

		if(word.length() == 0) {
			thread.interrupt();
		}
		//smooths drawing on linux
		Toolkit.getDefaultToolkit().sync();
	}
}
// if(wordX > width)
//{
//g.setColor(Color.blue);
//}
//
