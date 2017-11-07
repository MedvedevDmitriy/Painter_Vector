package painter_vector;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PSliderDialog extends JDialog implements ActionListener
{
	JSlider slider = new JSlider();
	PData data = null;
	private int width = 0;
	
	public PSliderDialog(PData data)
	{
		JButton button = new JButton("OK");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);
		
		this.data = data;
		
		slider.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				JSlider theSlider = (JSlider) e.getSource();
				data.setWidth(theSlider.getValue());
			}
		});
		
		
		int width = 300;
		int height = 100;
		int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2;
		setLocation(x, y);
		setSize(width, height);
		setModal(true);
		
		slider.setMinimum(1);
		slider.setMaximum(100);
		add(slider, BorderLayout.NORTH);
		
		//pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		dispose();
	}
}