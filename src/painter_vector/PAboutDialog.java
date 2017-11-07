package painter_vector;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PAboutDialog extends JDialog implements ActionListener 
{
	public PAboutDialog() 
	{
		JButton button = new JButton("OK");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);
		add(new JLabel("Version 1.0.0"), BorderLayout.NORTH);
		int width = 300;
		int height = 100;	
		setSize(width, height);
		setModal(true);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2;
		setLocation(x, y);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		dispose();
	}
}