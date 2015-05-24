package test.java.gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import main.java.gui.CodeWriter;
import main.java.gui.CodeWriter.CodeWriterRunnable;

import org.junit.Before;
import org.junit.Test;

public class CodeWriterTest {

	private CodeWriter main;

	@Before
	/**
	 * Create class instance for testing.
	 */
	public void testSetup()
	{
		main = CodeWriterRunnable.getInstance();
	}

	@SuppressWarnings("static-access")
	@Test
	/**
	 * Ensure main is executable.
	 */
	public void testMain()
	{
		main.main(new String[] { "1", "2" });
	}

	@Test
	/**
	 * Test that main creates a runnable instance of program.
	 */
	public void testRunnableInstance()
	{
		CodeWriterRunnable runnable = CodeWriter.getRunnable();
		assertNotNull(runnable);
		runnable.run(); // Will create instance and set window to visible
		assertEquals(CodeWriterRunnable.getInstance().isVisible(), true);
	}

	@Test
	/**
	 * Test GUI initialization parameters.
	 */
	public void testGuiInit()
	{
		CodeWriter main = CodeWriterRunnable.getInstance();
		main.initUserInterface();
		assertEquals(main.getTitle(), "CodeWriter");
	}

}
