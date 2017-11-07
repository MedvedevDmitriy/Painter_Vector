package painter_vector;

import java.awt.*;

public class PLine extends PShape
{
	public PLine(int x1, int y1, int x2, int y2, int clr, int width)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.clr = clr;
		this.width = width;
		this.shape = 0;
	}
	
	@Override
	public void draw(Graphics2D gg)
	{
		gg.setColor(new Color(clr));
		gg.setStroke(new BasicStroke(width));
		gg.drawLine(x1, y1, x2, y2);
	}
}