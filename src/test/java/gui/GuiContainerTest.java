package test.java.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.java.gui.CodeWriter;
import main.java.gui.GuiContainer;

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
    }

}
