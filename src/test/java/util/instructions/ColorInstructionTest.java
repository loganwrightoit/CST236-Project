package test.java.util.instructions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import main.java.gui.CodeWriter;
import main.java.gui.GuiContainer;
import main.java.util.instructions.ColorInstruction;

import org.junit.Before;
import org.junit.Test;

public class ColorInstructionTest {

	GuiContainer gui;
	ColorInstruction instr;

	@Before
	/**
	 * Test setup.
	 */
	public void setUp()
	{
		gui = CodeWriter.getRunnable().getInstance().guiContainer;
		instr = new ColorInstruction();
		gui.getOutput().setForeground(Color.BLACK);
		gui.getOutput().setBackground(Color.WHITE);
	}

	@Test
	/**
	 * Test changing text color.
	 */
	public void testChangeForegroundColor()
	{
		Color color = gui.getOutput().getForeground();
		assertNotEquals(color, Color.PINK);

		String input = "make the text color pink";
		instr.execute(input);

		// Test color already set branch
		instr.execute(input);

		// Test alternate keyword
		input = "make the foreground color pink";
		instr.execute(input);

		// Verify text color
		color = gui.getOutput().getForeground();
		assertEquals(color, Color.PINK);
	}

	@Test
	/**
	 * Test changing background color.
	 */
	public void testChangeBackgroundColor()
	{
		Color color = gui.getOutput().getBackground();
		assertNotEquals(color, Color.YELLOW);

		String input = "make the background color yellow";
		instr.execute(input);

		// Test color already set branch
		instr.execute(input);

		// Verify background color
		color = gui.getOutput().getBackground();
		assertEquals(color, Color.YELLOW);
	}

	@Test
	/**
	 * Test identifying hex color.
	 */
	public void testHexColor()
	{
		Color color = gui.getOutput().getBackground();
		assertNotEquals(color, Color.decode("0xffee22"));

		String input = "make the background color 0xffee22";
		instr.execute(input);

		// Verify background color
		color = gui.getOutput().getBackground();
		assertEquals(color, Color.decode("0xffee22"));
	}

	@Test
	/**
	 * Test color decoding.
	 */
	public void testColorDecoding()
	{
		boolean result = instr.execute("no color in this string");
		assertFalse(result);
		result = instr.execute("make text color yellow");
		assertTrue(result);
	}

}
