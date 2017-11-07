package painter_vector;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PStatusBar extends JPanel 
{
	private static final JLabel status = new JLabel();

	public PStatusBar(String s) 
	{
		setLayout(new BorderLayout());
		status.setText(s);
		status.setBorder(new EtchedBorder());
		add(status, BorderLayout.SOUTH);
	}

	public static void setStatus(String s) 
	{
		status.setText(s);
	}
}