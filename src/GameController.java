import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;


public class GameController {

	static Game game;
	static int width = 300, height = 300;
	static String frameTitle = "Red Square Game";
	
	public static void main(String[] args) throws InterruptedException {
		game = new Game(width, height);
		JFrame frame = new JFrame(frameTitle);
		
		game.setPreferredSize(new Dimension(width, height));
		frame.add(game);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while(game.running){
			game.repaint();
			game.move();
			Thread.sleep(10);
		}
		Calendar cal = Calendar.getInstance();
		Date time2 = cal.getTime();
		long end = time2.getTime();
		double time = end - game.timeStarted;
		double survivedTime = (time/1000);
		game.gameOver(survivedTime);
		game.repaint();
	}
}