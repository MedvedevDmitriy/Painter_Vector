package painter_vector;

import java.awt.*;

public class POval extends PShape
{
	public POval(int x1, int y1, int x2, int y2, int clr, int width) 
	{
		this.x1 = (x2 < x1) ? x2 : x1;
		this.x2 = (x1 > x2) ? x1 : x2;
		this.y1 = (y2 < y1) ? y2 : y1;
		this.y2 = (y1 > y2) ? y1 : y2;
		this.clr = clr;
		this.width = width;
		this.shape = 1;
	}

	@Override
	public void draw(Graphics2D gg) 
	{
		gg.setStroke(new BasicStroke(width));
		gg.setColor(new Color(clr));
		gg.drawOval(x1, y1, x2 - x1, y2 - y1);
	}
}