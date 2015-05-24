package test.java.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import main.java.gui.CodeWriter;
import main.java.gui.GuiContainer;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class GuiContainerTest {

    GuiContainer gui;

    @Before
    /**
     * Test initializations
     */
    public void init()
    {
        gui = CodeWriter.getRunnable().getInstance().guiContainer;
    }

    @Test
    /**
     * Coverage for key listener events.
     */
    public void testTypeKeys()
    {
        // This test is only meant for coverage
        KeyEvent key = new KeyEvent(gui, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_UP,'Z');
        KeyListener listener = gui.getInput().getKeyListeners()[0];
        listener.keyPressed(key);
        listener.keyReleased(key);
        listener.keyTyped(key);

        // Exception branch coverage
        JTextArea mockText = EasyMock.createMock(JTextArea.class);
        try {
            EasyMock.expect(mockText.getLineOfOffset(1)).andThrow(new BadLocationException("", 0));
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
