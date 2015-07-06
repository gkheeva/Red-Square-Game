import java.awt.Dimension;

import javax.swing.JFrame;


public class GameController {

	static Game game;
	static int width = 300, height = 300;
	static String frameTitle = "Red Square Game";
	static boolean running;
	
	public static void main(String[] args) throws InterruptedException {
		running = true;
		game = new Game(width, height);
		JFrame frame = new JFrame(frameTitle);
		
		game.setPreferredSize(new Dimension(width, height));
		frame.add(game);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(running){
			game.repaint();
			game.move();
			game.checkCollision();
			Thread.sleep(10);
		}
	}
}