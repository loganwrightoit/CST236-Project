package java.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.main.CodeWriter;
import java.main.CodeWriter.CodeWriterRunnable;

import org.junit.Test;

public class CodeWriterTest {

	@SuppressWarnings("static-access")
	@Test
	/**
	 * Ensure main is executable.
	 */
	public void testMain()
	{
		CodeWriter main = CodeWriterRunnable.getInstance();
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
