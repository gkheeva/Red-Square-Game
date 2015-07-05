import java.awt.Dimension;

import javax.swing.JFrame;


public class GameController {

	static Game game;
	static int width = 400, height = 400;
	static String frameTitle = "myGame";
	
	public static void main(String[] args) {
		game = new Game();
		JFrame frame = new JFrame(frameTitle);
		
		game.setPreferredSize(new Dimension(width, height));
		frame.add(game);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
