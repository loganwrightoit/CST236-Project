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
    public void testTypeKeys()
    {
        KeyEvent key = new KeyEvent(gui, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_UP,'Z');
        KeyListener listener = gui.getInput().getKeyListeners()[0];
        gui.getInput().setText("set text color to blue");
        listener.keyPressed(key);
        listener.keyReleased(key);
        listener.keyTyped(key);
    }

}
