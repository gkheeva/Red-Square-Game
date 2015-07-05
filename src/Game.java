import java.awt.Graphics;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel{

	Enemy[] enemies;
	Player player;
	Border border;
	
	public Game(int gameWidth, int gameHeight){
		this.player = new Player(gameWidth, gameHeight);
		this.border = new Border(gameWidth, gameHeight);
		enemies = new Enemy[4];
		enemies[0] = new Enemy();
		enemies[1] = new Enemy();
		enemies[2] = new Enemy();
		enemies[3] = new Enemy();
		}
	
	public void move(){
		enemies[0].move();
		enemies[1].move();
		enemies[2].move();
		enemies[3].move();
		player.move();
	}
	
	@Override
	public void paint(Graphics g){
		
		player.paint(g);
		
	}
	
	
	
}
