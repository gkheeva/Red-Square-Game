import java.awt.Color;
import java.awt.Graphics;


public class Border {
	int width, height;
	int thickness;
	Color color;
	
	public Border(int gameWidth, int gameHeight){
		this.width = gameWidth;
		this.height = gameHeight;
		thickness = (int) Math.ceil(((gameWidth + gameHeight) / 2) * 0.1);
		System.out.print(thickness);
		color = Color.black;
	}
	
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(0, 0, width, thickness); //top part
		g.fillRect(width - thickness, 0, thickness, height); // right part
		g.fillRect(0, height - thickness, width, thickness); //bottom part
		g.fillRect(0, 0, thickness, height); //left part
	}
}
