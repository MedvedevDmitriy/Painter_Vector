package painter_vector;

import java.awt.*;

public class PData
{
	private int width = 1;
	private Color clr = Color.black;
	private int shape = 0;
	
	public Color getColor()
	{
		return this.clr;
	}
	
	public void setColor(Color clr)
	{
		this.clr = clr;
	}

	public int getShape()
	{
		return this.shape;
	}

	public void setShape(int shape)
	{
		this.shape = shape;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}	
}