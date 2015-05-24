package test.java.util;

import main.java.util.Definitions;
import main.java.util.instructions.ColorInstruction;
import main.java.util.instructions.IInstruction;

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
    public void testExceptionParseInstruction()
    {
        Definitions mockDef = Mockito.mock(Definitions.class);

        try {
            Mockito.when(mockDef.getClassInstance(ColorInstruction.class)).thenThrow(new InstantiationException());
            mockDef.parseInstruction("make text color yellow");
            //Assert.assertNull(instr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testValidParseInstruction()
    {
        String input = "make the text color yellow";
        IInstruction instr = def.parseInstruction(input);
        Assert.assertTrue(instr instanceof ColorInstruction);
    }

    @Test
    public void testInvalidParseInstruction()
    {
        String input = "make the text yellow";
        IInstruction instr = def.parseInstruction(input);
        Assert.assertEquals(instr, null);
    }

}
