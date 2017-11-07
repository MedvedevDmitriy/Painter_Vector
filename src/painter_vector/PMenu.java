package painter_vector;

import javax.swing.*;

public class PMenu extends JMenuBar
{
	PCommand cmd = null;
	
	public PMenu(PCommand cmd)
	{
		this.cmd = cmd;
		add(createFileMenu());
		add(createDrawMenu());
		add(createStrokeMenu());
		add(createColorMenu());
		add(createAboutMenu());
	}
	
	private JMenu createFileMenu() 
	{
		JMenu file = new JMenu("File");
		
		JMenuItem load = new JMenuItem("Load");
		JMenuItem save = new JMenuItem("Save");	
		JMenuItem exit = new JMenuItem("Exit");

		load.addActionListener(cmd.load);
		save.addActionListener(cmd.save);
		exit.addActionListener(cmd.exit); 
		
		file.add(load);
		file.add(save);
		file.addSeparator();	
		file.add(exit);
	
		return file;
	}

	private JMenu createDrawMenu() 
	{
		JMenu draw = new JMenu("Draw");
		String[] str2 = {"Curve", "Line", "Oval", "Rect", "RoundRect"};
		for (int i = 0; i < str2.length; i++)
		{
			JMenuItem item = new JMenuItem(str2[i]);
			item.addActionListener(cmd.actionFigure);
			draw.add(item);
		}
		return draw;
	}

	private JMenu createStrokeMenu() 
	{
		JMenu stroke = new JMenu("Stroke");
		String[] str3 = {"width10", "width20", "width30", "choose"};
		for (int i = 0; i < str3.length; i++)
		{
			JMenuItem item = new JMenuItem(str3[i]);
			item.addActionListener(cmd.actionWidth);
			stroke.add(item);
			if (i == 3)
			{
				item.addActionListener(cmd.widthChooser);
				stroke.add(item);
			}
		}
		return stroke;
	}

	private JMenu createColorMenu() 
	{
		JMenu color = new JMenu("Color");
		String[] str4 = {"red", "black", "blue", "choose"};
		for (int i = 0; i < str4.length; i++)
		{
			JMenuItem item = new JMenuItem(str4[i]);
			item.addActionListener(cmd.actionColor);
			color.add(item);
			if (i == 3)
			{
				item.addActionListener(cmd.colorChooser);
				color.add(item);
			}
		}
		return color;
	}
	
	private JMenu createAboutMenu() 
	{
		JMenu about = new JMenu("About");
		
		JMenuItem content = new JMenuItem("About");
		content.addActionListener(cmd.about);
		
		about.add(content);
		
		return about;
	}
}