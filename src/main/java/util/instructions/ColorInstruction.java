package main.java.util.instructions;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

import main.java.gui.CodeWriter;

public class ColorInstruction implements IInstruction {

	@Override
	public boolean execute(String input)
	{
		input = input.toLowerCase();
		JTextArea output = CodeWriter.guiContainer.getOutput();
		Color color = null;

		StringTokenizer st = new StringTokenizer(input);
		while (st.hasMoreTokens())
		{
			// Parse inputs and look for color
			String token = st.nextToken();
			Field field = null;
			try {
				// Check for standard color names
				field = Class.forName("java.awt.Color").getField(token.toLowerCase());
				color = (Color)field.get(null);
				break;
			} catch (Exception e) { }
			try {
				// Check for octal and hexadecimal colors
				color = Color.decode(token);
				break;
			}
			catch (NumberFormatException e) { }
		}

		if (color != null)
		{
			// Determine element to colorize
			if (input.contains("background") && color != output.getBackground())
			{
				output.setBackground(color);
				return true;
			}
			else if ((input.contains("text") || input.contains("foreground")) && color != output.getForeground())
			{
				output.setForeground(color);
				return true;
			}
		}

		return false;
	}

}
