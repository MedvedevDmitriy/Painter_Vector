package painter_vector;

import java.awt.*;

public abstract class PShape
{
	int x1;
	int x2;
	int y1;
	int y2;
	int clr;
	int width;
	int shape;

	public abstract void draw(Graphics2D gg);
}