package test.java.util;

import main.java.util.Definitions;
import main.java.util.instructions.ColorInstruction;
import main.java.util.instructions.IInstruction;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ColorInstruction.class, Definitions.class })
public class DefinitionsTest
{
    @Test
    /**
     * Strictly for 100% coverage.
     */
    public void testExceptionParseInstruction()
    {
        Definitions def = new Definitions();
        try {
            PowerMock.expectNew(ColorInstruction.class).andThrow(new InstantiationException());
        } catch (Exception e) {
            e.printStackTrace();
        }
        IInstruction instr = def.parseInstruction("make the text color yellow");
        Assert.assertNull(instr);
    }

    @Test
    public void testValidParseInstruction()
    {
        String input = "make the text color yellow";
        IInstruction instr = Definitions.parseInstruction(input);
        Assert.assertTrue(instr instanceof ColorInstruction);
    }

    @Test
    public void testInvalidParseInstruction()
    {
        String input = "make the text yellow";
        IInstruction instr = Definitions.parseInstruction(input);
        Assert.assertFalse(instr instanceof ColorInstruction);
    }

}
