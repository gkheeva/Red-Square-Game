import java.awt.Color;
import java.awt.Graphics;


public class Enemy {
	int speed = 1;
	int x, y;
	int width, height;
	int direction; //1-10
	Color color;
	
	public Enemy(int startX, int startY, int width, int height){
		this.x = startX;
		this.y = startY;
		this.width = width;
		this.height = height;
		direction = randomDirection();
		color = Color.decode("#000099");
	}

	private int randomDirection() {
		double r = Math.random();
		int direction = (int) Math.ceil(r*10);
		return direction;
	}
	
	public void move(){
		//move
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
