import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;


@SuppressWarnings("serial")
public class Game extends JPanel{

	Enemy[] enemies;
	Player player;
	Border border;
	boolean clickedOnPlayer;
	boolean running;
	boolean gameOver;
	double timeSurvived = 0;
	int gameWidth, gameHeight;
	
	public Game(int gameWidth, int gameHeight){
		running = true;
		gameOver = false;
		clickedOnPlayer = false;
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
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
					//move enemies;
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
		if(collisionWithEnemy()){
			System.out.println("GameOver");
			running = false;
		}
	}
	
	public void gameOver (double time){
		gameOver = true;
		timeSurvived = time;
	}
	
	public boolean collisionWithEnemy(){
		for (int i = 0; i < enemies.length; i++){
			if(player.getBounds().intersects(enemies[i].getBounds()))
				return true;
		}
		return false;
	}
	
	@Override
	public void paint(Graphics g){
		if(!gameOver){
			border.paint(g);
			player.paint(g);
			enemies[0].paint(g);
			enemies[1].paint(g);
			enemies[2].paint(g);
			enemies[3].paint(g);
		}
		else{
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, gameWidth, gameHeight);
			g.setColor(Color.BLACK);
			Font font = new Font(Font.MONOSPACED, Font.BOLD, 19);
			g.setFont(font);
			String str = "Survived: " + timeSurvived + " seconds.";
			g.drawString(str, 20, gameHeight/2 - 5);
		}
	}
}
