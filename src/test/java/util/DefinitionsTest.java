package test.java.util;

import java.lang.reflect.Field;

import main.java.gui.instructions.ColorInstruction;
import main.java.gui.instructions.IInstruction;
import main.java.util.Definitions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefinitionsTest
{
    Definitions def;

    @Before
    /**
     * Test setup
     */
    public void setUp()
    {
        def = new Definitions();
    }

    @Test
    /**
     * Test the parsing exception branch.
     */
    public void testExceptionParseInstruction() throws InstantiationException, IllegalAccessException
    {
        Definitions spyDef = Mockito.spy(new Definitions());
        Mockito.when(spyDef.getClassInstance(ColorInstruction.class)).thenThrow(new InstantiationException());
        spyDef.parseInstruction("make text color yellow");
    }

    @Test
    /**
     * Test a valid color instruction.
     */
    public void testValidParseInstruction()
    {
        String input = "make the text color yellow";
        IInstruction instr = def.parseInstruction(input);
        Assert.assertTrue(instr instanceof ColorInstruction);
    }

    @Test
    /**
     * Test an invalid color instruction.
     */
    public void testInvalidParseInstruction()
    {
        String input = "make the text yellow";
        IInstruction instr = def.parseInstruction(input);
        Assert.assertEquals(instr, null);
    }

    @Test
    /**
     * Test giving long instructions with multiple keywords
     */
    public void testLongInstruction()
    {
        String input = "text color style font bold arial times new roman blue background foreground text";
        IInstruction instr = def.parseInstruction(input);
        Assert.assertTrue(instr instanceof ColorInstruction);
    }

    @Test
    /**
     * Test all valid colors.
     */
    public void testAllColors() throws SecurityException, ClassNotFoundException
    {
        Field[] fields = Class.forName("java.awt.Color").getFields();
        for (Field field : fields)
        {
            try {
                String input = "text color " + field.getName();
                IInstruction instr = def.parseInstruction(input);
                Assert.assertTrue(instr instanceof ColorInstruction);
            } catch (Exception e) {}
        }
    }

    @Test
    /**
     * Test that 1,000,000 instructions can be parsed in less than 500 milliseconds.
     */
    public void testInstructionDuration()
    {
        long startTime = System.nanoTime();

        for (int i = 0; i < 500000; ++i)
        {
            String input = "make the text color yellow";
            IInstruction instr = def.parseInstruction(input);
            Assert.assertTrue(instr instanceof ColorInstruction);
            input = "make the text yellow";
            instr = def.parseInstruction(input);
            Assert.assertEquals(instr, null);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        Assert.assertTrue(duration < 500);
    }

}
