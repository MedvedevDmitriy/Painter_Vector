package painter_vector;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class PPanel extends JPanel implements MouseListener, MouseMotionListener
{
	private int x;
	private int y;
	public ArrayList<PShape> al = new ArrayList<PShape>();
	
	PData data = null;
	PCommand cmd = null;
	PShape figure = null;
	PStatusBar sb = null;
	
	public PPanel(PCommand cmd, PData data)
	{
		setBounds(0, 200, 1600, 500);
		setBackground(Color.WHITE);
		this.data = data;
		cmd.pp = this;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		for(PShape p: al)
		{
			p.draw(gg);
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		Graphics2D gg = (Graphics2D)getGraphics();
		gg.setColor(data.getColor());  
		//String strColor = "" + data.getColor().getRGB();
		//int shapeType = data.getShape();
		switch(data.getShape())
		{
		case 1:
			figure = new PLine(x, y, e.getX(), e.getY(), data.getColor().getRGB(), data.getWidth());
			break;
		case 2:
			figure = new POval(x, y, e.getX(), e.getY(), data.getColor().getRGB(), data.getWidth());
			break;
		case 3:
			figure = new PRect(x, y, e.getX(), e.getY(), data.getColor().getRGB(), data.getWidth());
			break;
		case 4:
			figure = new PRoundRect(x, y, e.getX(), e.getY(), data.getColor().getRGB(), data.getWidth());
			break;
		}		
		if (data.getShape() > 0)
		{
			al.add(figure);
		}
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		Graphics2D gg = (Graphics2D)getGraphics();
		gg.setColor(data.getColor());  
		//String strColor = "" + data.getColor().getRGB();
		//int shapeType = data.getShape();
		if (data.getShape() == 0)
		{
			figure = new PLine(x, y, e.getX(), e.getY(), data.getColor().getRGB(), data.getWidth());
			al.add(figure);
			x = e.getX();
			y = e.getY();  
		}
		repaint();
	}

	public void setStatusBar(PStatusBar sb)
	{
		this.sb = sb;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		sb.setStatus("X: " + e.getX() + "  " + "Y: " + e.getY());
	}
	
	/*@Override
	public void setBackground(Color bg) 
	{
		super.setBackground(Color.white);
	}*/

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}