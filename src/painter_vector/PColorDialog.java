package painter_vector;

import java.awt.*;
import javax.swing.*;

public class PColorDialog extends JDialog 
{
	JColorChooser colorChooser = new JColorChooser();
	PData data = null;
		
	public PColorDialog(PData data)
	{		
		this.data = data;
			
		Color color = colorChooser.showDialog(null, "Color", Color.BLUE);
		data.setColor(color);
		add(colorChooser);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
		setModal(true);
		setResizable(false);
	}
}