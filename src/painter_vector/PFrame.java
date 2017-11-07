package painter_vector;

import java.awt.*;
import javax.swing.*;

public class PFrame extends JFrame
{
	PData data = new PData();
	JTabbedPane jtp = new JTabbedPane();
	PCommand cmd = new PCommand(data, jtp);
	PPanel pp = new PPanel(cmd, data);	
	PButtonPanel bp = new PButtonPanel(cmd);
	
	public PFrame()
	{
		setLayout(null);
		setTitle("Painter");
		setBounds(50, 50, 1800, 900);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
		
		jtp.setBounds(0, 200, 1600, 500);
		jtp.addTab("title", pp);
		add(jtp);
		
		bp.setBounds(1600, 50, 200, 900);		
		add(bp);
		
		PStatusBar sb = new PStatusBar("Welcome");
		sb.setBounds(0, 800, 1800, 20);
		pp.setStatusBar(sb);
		add(sb);
		
		setJMenuBar(new PMenu(cmd));
		
		PToolBar tb = new PToolBar(cmd);
		tb.setBounds(0, 100, 1800, 50);
		add(tb);
		
		setVisible(true);
	}	
}