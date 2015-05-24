package test.java.util.instructions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
     * Test input color instruction
     */
    public void init()
    {
        gui = CodeWriter.getRunnable().getInstance().guiContainer;
        instr = new ColorInstruction();
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
        ColorInstruction instr = new ColorInstruction();
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
        ColorInstruction instr = new ColorInstruction();
        instr.execute(input);

        // Verify background color
        color = gui.getOutput().getBackground();
        assertEquals(color, Color.YELLOW);
    }

}
