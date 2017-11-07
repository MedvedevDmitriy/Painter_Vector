package painter_vector;

import javax.swing.*;

public class PToolBar extends JToolBar 
{
	PCommand cmd = null;

	public PToolBar(PCommand cmd) 
	{
		this.cmd = cmd;

		JButton load = new JButton();
		JButton save = new JButton();
		JButton about = new JButton();
		JButton exit = new JButton();

		load.setIcon(new ImageIcon("icons/folder-icon.png"));
		save.setIcon(new ImageIcon("icons/save-icon.png"));
		about.setIcon(new ImageIcon("icons/computer-icon.png"));
		exit.setIcon(new ImageIcon("icons/close-icon.png"));

		load.addActionListener(cmd.load);
		save.addActionListener(cmd.save);
		about.addActionListener(cmd.about);
		exit.addActionListener(cmd.exit);
		
		add(load);
		add(save);
		addSeparator();
		add(about);
		addSeparator();
		add(exit);
	}
}