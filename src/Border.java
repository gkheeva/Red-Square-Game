import java.awt.Color;


public class Border {
	int width, height;
	int thickness;
	Color color;
	
	public Border(int gameWidth, int gameHeight){
		this.width = gameWidth;
		this.height = gameHeight;
		thickness = (int) Math.ceil(((gameWidth + gameHeight) / 2) * 0.85);
		color = Color.black;
	}
}
