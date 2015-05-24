package test.java.util.instructions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Font;

import main.java.gui.CodeWriter;
import main.java.gui.GuiContainer;
import main.java.util.instructions.StyleInstruction;

import org.junit.Before;
import org.junit.Test;

public class StyleInstructionTest {

	GuiContainer gui;
	StyleInstruction instr;

	@Before
	/**
	 * Test setup.
	 */
	public void setUp()
	{
		gui = CodeWriter.getRunnable().getInstance().guiContainer;
		instr = new StyleInstruction();
		gui.getOutput().setFont(Font.getFont("default"));
	}

	@Test
	/**
	 * Test changing text style to bold.
	 */
	public void testChangeStyleToBold()
	{
		Font font = gui.getOutput().getFont();
		assertFalse(font.isBold());

		String input = "make the text style bold";
		instr.execute(input);

		// Verify text style
		font = gui.getOutput().getFont();
		assertTrue(font.isBold());
	}

	@Test
	/**
	 * Test changing text style to italicized.
	 */
	public void testChangeStyleToItalicized()
	{
		Font font = gui.getOutput().getFont();
		assertFalse(font.isItalic());

		String input = "make the text style italic";
		instr.execute(input);

		// Verify text style
		font = gui.getOutput().getFont();
		assertTrue(font.isItalic());
	}

	@Test
	/**
	 * Test invalid style.
	 */
	public void testInvalidStyle()
	{
		boolean result = instr.execute("no text style in this string");
		assertFalse(result);
		result = instr.execute("make text style bold");
		assertTrue(result);
	}

}
