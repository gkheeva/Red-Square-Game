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
		enemies[0] = new Enemy((int) Math.ceil(gameWidth*0.04), (int) Math.ceil(gameHeight*0.2),
				50, 50, gameWidth, gameHeight);
		enemies[1] = new Enemy((int) Math.ceil(gameWidth*0.95) - 40, (int) Math.ceil(gameHeight*0.2),
				50, 40, gameWidth, gameHeight);
		enemies[2] = new Enemy((int) Math.ceil(gameWidth*0.03), (int) Math.ceil(gameHeight*0.8) - 40,
				25, 50, gameWidth, gameHeight);
		enemies[3] = new Enemy((int) Math.ceil(gameWidth*0.97) - 40, (int) Math.ceil(gameHeight*0.8),
				75, 15, gameWidth, gameHeight);
		}
	
	public void move(){
		enemies[0].move();
		enemies[1].move();
		enemies[2].move();
		enemies[3].move();
		player.move();
	}
	
	public void checkCollision(){
		//
	}
	
	@Override
	public void paint(Graphics g){
		border.paint(g);
		player.paint(g);
		
		enemies[0].paint(g);
		enemies[1].paint(g);
		enemies[2].paint(g);
		enemies[3].paint(g);
	}
	
	
	
}
