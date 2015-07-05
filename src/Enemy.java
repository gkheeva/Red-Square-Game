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
		this.gameHeight = gameWidth;
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
			case 1:        //right up
				
				if(x + width == gameWidth)
					direction = 4;
				if(y == 0)
					direction = 2;
				this.x++;
				this.y++;
				break;
			case 2:
				
				if(x + width == gameWidth) 
					direction = 3;
				if(y + height == gameHeight) 
					direction = 1;
				this.x++;  //right down
				this.y--;
				break;
			case 3:
				
				if(x == 0){
					direction = 2;
				}
				if(y + height == gameHeight){
					direction = 4;
				}
				this.x--;  //left down
				this.y--;
				break;
			case 4:
				
				if (x == 0){
					direction = 1;
				}
				if (y == 0)
					direction = 3;
				this.x--;  //left up
				this.y++;
				break;
		}
		
		if (x == 0 && direction == 3){   //going left down
			direction = 2;
		}
		
		if (x == 0 && direction == 4){  //going left up
			direction = 1;
		}
		
		
		
		
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
