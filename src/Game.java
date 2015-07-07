import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel{

	Enemy[] enemies;
	Player player;
	Border border;
	boolean clickedOnPlayer;
	
	public Game(int gameWidth, int gameHeight){
		clickedOnPlayer = false;
		this.player = new Player(gameWidth, gameHeight);
		this.border = new Border(gameWidth, gameHeight);
		enemies = new Enemy[4];
		enemies[0] = new Enemy((int) Math.ceil(gameWidth*0.18), (int) Math.ceil(gameHeight*0.2),
				50, 50, gameWidth, gameHeight);
		enemies[1] = new Enemy((int) Math.ceil(gameWidth*0.8) - 40, (int) Math.ceil(gameHeight*0.2),
				50, 40, gameWidth, gameHeight);
		enemies[2] = new Enemy((int) Math.ceil(gameWidth*0.2), (int) Math.ceil(gameHeight*0.8) - 40,
				25, 50, gameWidth, gameHeight);
		enemies[3] = new Enemy((int) Math.ceil(gameWidth*0.77) - 40, (int) Math.ceil(gameHeight*0.8),
				75, 15, gameWidth, gameHeight);
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(clickedOnPlayer){
				player.x  = e.getX() - player.width/2;
				player.y = e.getY() - player.height/2;
				}
			}
		});
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				clickedOnPlayer = false;
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				int mx = e.getX();
				int my = e.getY();
				
				if(mx >= player.x && mx <= (player.x + player.width) &&
						my >= player.y && my <= player.y + player.height){
					clickedOnPlayer = true;
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void move(){
		enemies[0].move();
		enemies[1].move();
		enemies[2].move();
		enemies[3].move();
		player.move();
	}
	
	public void checkCollision(){
		//TODO
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
