package painter_vector;

import java.awt.*;
import javax.swing.*;

public class PButtonPanel extends JPanel
{
	PCommand cmd = null;
	
	public PButtonPanel(PCommand cmd)
	{
		this.cmd = cmd;
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(13, 1, 0, 30));
		add(buttonPanel);

		String[] str = {"red", "black", "blue", "width10", "width20", "width30", "addTab", "deleteTab",
						"Curve", "Line", "Oval", "Rect", "RoundRect"};
		
		for (int i = 0; i < str.length; i++)
		{
			if (i < str.length-10)
			{
				JButton button = new JButton(str[i]);
				button.addActionListener(cmd.actionColor);
				buttonPanel.add(button);
			}
			
			else if (i >= str.length-10 && i < str.length-7)
			{
				JButton button = new JButton(str[i]);
				button.addActionListener(cmd.actionWidth);
				buttonPanel.add(button);
			}
			
			else if (i >= str.length-7 && i < str.length-5)
			{
				JButton button = new JButton(str[i]);
				button.addActionListener(cmd.tabAction);
				buttonPanel.add(button);
			}
			
			else
			{
				JButton button = new JButton(str[i]);
				button.addActionListener(cmd.actionFigure);
				buttonPanel.add(button);
			}
		}
	}
}