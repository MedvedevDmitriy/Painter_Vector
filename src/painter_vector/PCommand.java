package painter_vector;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.*;

public class PCommand 
{
	public ArrayList<PPanel> plist = new ArrayList<PPanel>();
	PData data = null;
	PPanel pp = null;
	JTabbedPane jtp = null;
	
	public PCommand(PData data, JTabbedPane jtp)
	{
		this.data = data;
		this.jtp = jtp;
	}
	
	TabAction tabAction = new TabAction(this);
	
	ActionColor actionColor = new ActionColor();
	ActionWidth actionWidth = new ActionWidth();
	ActionFigure actionFigure = new ActionFigure();
	
	ColorChooser colorChooser = new ColorChooser();
	WidthChooser widthChooser = new WidthChooser();

	Load load = new Load();
	Save save = new Save();
	About about = new About();
	Exit exit = new Exit();

	class ActionColor implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String str = e.getActionCommand();
			switch (str)
			{
				case "red": data.setColor(Color.red); break;
				case "black": data.setColor(Color.black); break;
				case "blue": data.setColor(Color.blue); break;
			}
		}
	}

	class ActionWidth implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String str = e.getActionCommand();
			switch (str)
			{
				case "width10": data.setWidth(10); break;
				case "width20": data.setWidth(20); break;
				case "width30": data.setWidth(30); break;
			}
		}
	}

	class ActionFigure implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String str = e.getActionCommand();
			if (e.getSource() instanceof JButton)
			{
				str = ((JButton)e.getSource()).getText();
			}
			else if (e.getSource() instanceof JMenuItem)
			{
				str = ((JMenuItem)e.getSource()).getText();
			}
			switch (str)
			{
				case "Curve": data.setShape(0); break;
				case "Line": data.setShape(1); break;
				case "Oval": data.setShape(2); break;
				case "Rect": data.setShape(3); break;
				case "RoundRect": data.setShape(4); break;
			}
		}
	}

	class WidthChooser implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			new PSliderDialog(data);
		}
	}

	class ColorChooser implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			new PColorDialog(data);
		}
	}

	class Load implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JFileChooser dialog = new JFileChooser();
			dialog.setFileFilter(new FileNameExtensionFilter("*.json", "json"));
			int result = dialog.showOpenDialog(null);
			
			if (result == JFileChooser.APPROVE_OPTION) 
			{
				new SaveLoad_JSON(pp.al).load(dialog.getSelectedFile().getPath());
				pp.repaint();
			}
		}
	}

	class Save implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JFileChooser dialog = new JFileChooser();
			dialog.setFileFilter(new FileNameExtensionFilter("*.json", "json"));
			int result = dialog.showSaveDialog(null);
			
			if (result == JFileChooser.APPROVE_OPTION) 
			{
				new SaveLoad_JSON(pp.al).save(dialog.getSelectedFile().getPath());
			}
		}
	}

	class About implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new PAboutDialog();
		}
	}

	class Exit implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
	}
	
	class TabAction implements ActionListener 
	{
		PCommand cmd = null;
		
		public TabAction(PCommand cmd)
		{
			this.cmd = cmd;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String str = "";
			if (e.getSource() instanceof JButton)
			{
				str = ((JButton)e.getSource()).getText();
			}
			switch(str)
			{
				case ("addTab"): plist.add(new PPanel(cmd, data)); jtp.addTab("title", plist.get(plist.size()-1)); jtp.setSelectedIndex(plist.size()-1); break;
				case ("deleteTab"): plist.remove(jtp.getSelectedIndex()); jtp.removeTabAt(jtp.getSelectedIndex()); break;
			}
		}
	}
}