package main.java.gui.instructions;

import java.awt.Font;

import javax.swing.JTextArea;

import main.java.gui.CodeWriter;

public class StyleInstruction implements IInstruction {

	@Override
	public boolean execute(String input)
	{
		input = input.toLowerCase();
		JTextArea output = CodeWriter.guiContainer.getOutput();
		Font font = output.getFont();

		// Determine font style
		if (input.contains("text"))
		{
			int style = input.contains("bold") ? Font.BOLD : input.contains("italic") ? Font.ITALIC : font.getStyle();
			if (style != font.getStyle())
			{
				output.setFont(new Font(font.getFontName(), style, font.getSize()));
				return true;
			}
		}

		return false;
	}

}
