package test.java.util;

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
