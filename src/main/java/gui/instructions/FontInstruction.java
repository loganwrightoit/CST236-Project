package main.java.gui.instructions;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextArea;

import main.java.gui.CodeWriter;

public class FontInstruction implements IInstruction {

	@Override
	public boolean execute(String input)
	{
		input = input.toLowerCase();
		JTextArea output = CodeWriter.guiContainer.getOutput();
		Font font = output.getFont();
		String font_str = font.getFontName();

		// Iterate through font names looking for match
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String fnt : fonts)
		{
			if (input.contains(fnt.toLowerCase()))
			{
				font_str = fnt;
			}
		}

		if (font.getFontName() != font_str)
		{
			output.setFont(new Font(font_str, font.getStyle(), font.getSize()));
			return true;
		}

		return false;
	}

}
