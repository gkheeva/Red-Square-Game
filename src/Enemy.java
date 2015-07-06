import java.awt.Color;
import java.awt.Graphics;


public class Enemy {
	int speed = 1;
	int x, y;
	int width, height;
	int direction; //1-4
	Color color;
	int gameWidth, gameHeight;
	
	public Enemy(int startX, int startY, int width, int height, int gameWidth, int gameHeight){
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
		this.x = startX;
		this.y = startY;
		this.width = width;
		this.height = height;
		direction = randomDirection();
		color = Color.decode("#000099");
	}
	
	public int randomDirection(){
		return randomNumber();
	}

	
	public int randomNumber(){
		int lower = 1;
		int upper = 5;
		int r = (int) (Math.random() * (upper - lower)) + lower;
		return r;
	}
	
	public void move(){
		
		
		switch (direction){
			case 1:        //right down
				this.x++;
				this.y++;
				if(x + width == gameWidth)
					direction = 4;
				if(y + height == gameHeight)
					direction = 2;
				break;
			case 2:
				this.x++;  //right up
				this.y--;
				if(x + width == gameWidth) 
					direction = 3;
				if(y == 0) 
					direction = 1;
				break;
			case 3:
				this.x--;  //left up
				this.y--;
				if(x == 0){
					direction = 2;
				}
				if(y == 0){
					direction = 4;
				}
				break;
			case 4:
				this.x--;  //left down
				this.y++;
				if (x == 0){
					direction = 1;
				}
				if (y + height == gameHeight)
					direction = 3;
				break;
		}
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
