import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player {
	
	int x, y;
	int width, height;
	Color color;
	
	
	
	public Player(int gameWidth, int gameHeight){	
		color = Color.decode("#990000");
		width = 40;
		height = 40;
		this.x = gameWidth/2 - (this.width/2);
		this.y = gameHeight/2 - (this.height/2);
	}
	
	public void move(){
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, width, height);
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
}
