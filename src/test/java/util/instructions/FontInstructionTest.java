package test.java.util.instructions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Font;

import main.java.gui.CodeWriter;
import main.java.gui.GuiContainer;
import main.java.util.instructions.FontInstruction;

import org.junit.Before;
import org.junit.Test;

public class FontInstructionTest {

	GuiContainer gui;
	FontInstruction instr;

	@Before
	/**
	 * Test setup.
	 */
	public void setUp()
	{
		gui = CodeWriter.getRunnable().getInstance().guiContainer;
		instr = new FontInstruction();
		gui.getOutput().setFont(Font.getFont("default"));
	}

	@Test
	/**
	 * Test changing text font.
	 */
	public void testChangeFont()
	{
		String font = gui.getOutput().getFont().getFontName();
		assertNotEquals(font, "Times New Roman");

		String input = "make the font times new roman";
		instr.execute(input);

		// Verify text style
		font = gui.getOutput().getFont().getFontName();
		assertEquals(font, "Times New Roman");
	}

	@Test
	/**
	 * Test invalid font.
	 */
	public void testInvalidFont()
	{
		boolean result = instr.execute("no font name in this string");
		assertFalse(result);
		result = instr.execute("make font times new roman");
		assertTrue(result);
	}

}
