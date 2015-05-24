package test.java.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import main.java.gui.CodeWriter;
import main.java.gui.GuiContainer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GuiContainerTest {

	GuiContainer gui;

	@Before
	/**
	 * Test setup.
	 */
	public void init()
	{
		gui = CodeWriter.getRunnable().getInstance().guiContainer;
	}

	@Test
	/**
	 * Test key listener branches.
	 */
	public void testTypeKeys() throws BadLocationException
	{
		KeyEvent key = new KeyEvent(gui, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_UP,'Z');
		KeyListener listener = gui.getInput().getKeyListeners()[0];
		gui.getInput().setText("set text color to blue");
		listener.keyPressed(key);
		listener.keyReleased(key);
		listener.keyTyped(key);

		// Test exception branch
		JTextArea spyInput = Mockito.spy(new JTextArea());
		gui.inputText = spyInput;
		Mockito.when(spyInput.getLineOfOffset(Mockito.anyInt())).thenThrow(new BadLocationException(null, 0));
		listener.keyReleased(key);
	}

}
