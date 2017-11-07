package painter_vector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SaveLoad_JSON implements ImportExport
{
	ArrayList<PShape> al = null;
	
	public SaveLoad_JSON(ArrayList<PShape> al)
	{
		this.al = al;
	}

	@Override
	public void load(String path)
	{
		al.clear();
		String str = "";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			str = br.readLine();
			br.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		StringTokenizer strTk = new StringTokenizer(str, "{[:, \"]}");
		String[] strParsed = new String[strTk.countTokens()];
		int count = 0;
		while (strTk.hasMoreTokens())
		{
			strParsed[count++] = strTk.nextToken();
		}
		PShape figure = null;
		for (int i = 0; i < strParsed.length; i++)
		{
			if (strParsed[i].equals("shape"))
			{
				int	shapeType = Integer.parseInt(strParsed[i + 1]);
				int	parsedX1 = (strParsed[i + 2].equals("x1")) ? Integer.parseInt(strParsed[i + 3]) : 0;
				int	parsedY1 = (strParsed[i + 4].equals("y1"))? Integer.parseInt(strParsed[i + 5]) : 0;
				int parsedX2 = (strParsed[i + 6].equals("x2"))? Integer.parseInt(strParsed[i + 7]) : 0;
				int parsedY2 = (strParsed[i + 8].equals("y2"))? Integer.parseInt(strParsed[i + 9]) : 0;
				int	parsedColor	= (strParsed[i + 10].equals("clr"))? Integer.parseInt(strParsed[i + 11]) : 0;
				int	parsedWidth	= (strParsed[i + 12].equals("width"))? Integer.parseInt(strParsed[i + 13]) : 0;
				switch (shapeType)
				{
					case 0: figure = new PLine(parsedX1, parsedY1, parsedX2, parsedY2, parsedColor, parsedWidth); break;
					case 1: figure = new POval(parsedX1, parsedY1, parsedX2, parsedY2, parsedColor, parsedWidth); break;
					case 2: figure = new PRect(parsedX1, parsedY1, parsedX2, parsedY2, parsedColor, parsedWidth); break;
					case 3: figure = new PRoundRect(parsedX1, parsedY1, parsedX2, parsedY2, parsedColor, parsedWidth); break;
				}
				al.add(figure);
				figure = null;
			}
		}
	}

	@Override
	public void save(String path)
	{
		String str = "[";
		for (PShape figure : al)
		{
			str += "{\"shape:\"" + figure.shape + "\"x1\"" + figure.x1 + "\"y1\"" + figure.y1 + "\"x2\"" + figure.x2 +
				   "\"y2\"" + figure.y2 + "\"clr\"" + figure.clr + "\"width\"" + figure.width + "}";
			if (figure != al.get(al.size() - 1))
			{
				str += ", ";
			}
		}
		str += "]";
		try
		{
			if (path.equals(""))
			{
				path = "untitled.json";
			}
			BufferedWriter br = new BufferedWriter(new FileWriter(path));
			br.write(str);
			br.flush();
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}