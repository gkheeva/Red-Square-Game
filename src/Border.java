import java.awt.Color;
import java.awt.Graphics;


public class Border {
	int width, height;
	int thickness;
	Color color;
	
	public Border(int gameWidth, int gameHeight){
		this.width = gameWidth;
		this.height = gameHeight;
		thickness = (int) Math.ceil(((gameWidth + gameHeight) / 2) * 0.15);
		System.out.print(thickness);
		color = Color.black;
	}
	
	public void paint(Graphics g){
		g.setColor(color);
	}
}
