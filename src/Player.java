import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Player implements MouseListener{
	
	int x, y;
	int width, height;
	Color color;
	
	public Player(int gameWidth, int gameHeight){	
		color = Color.red;
		width = 20;
		height = 20;
		this.x = gameWidth/2 - (this.width/2);
		this.y = gameHeight/2 - (this.height/2);
	}
	
	public void move(){
		
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}
	
}
