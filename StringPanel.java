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
		if(wordX >= width)
		{
			changeColor = Color.blue;
			wordVx = (int)(Math.random() * (6) + -8);
			word = word.substring(word.length() -1) + word.substring(0, word.length()-1);
		}
		else if(wordY >= height)
		{
			changeColor = Color.pink;
			wordVy = (int)(Math.random() * (6) + -10);
			word = word.substring(0, word.length()/2) + word.substring(word.length()/2, word.length()/2 + 1) + word.substring(word.length()/2);
		}
		else if(wordX <= 0)
		{
			changeColor = Color.orange;
			wordVx = (int)(Math.random() * (4) + 4);
			word = word.substring(2, word.length()/2) + word.substring(0,1) + word.substring(word.length()/2 +1) + word.substring(1,2);
		}
		else if(wordY <= 0)
		{
			changeColor = Color.green;
			wordVy = (int)(Math.random() * (10) + 2);
			if(word.length() > 1) 
			{
				word = word.substring(0, word.length()/2) + word.substring(word.length()/2 +2);
			}
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
