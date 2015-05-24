package main.java.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import main.java.util.Definitions;
import main.java.util.instructions.IInstruction;

public class GuiContainer extends JPanel {

    private static final long serialVersionUID = 1L;

    GridBagConstraints c;

    private JTextArea inputText;
    private JTextArea outputText;
    private JScrollPane inputScrollPane;
    private JScrollPane outputScrollPane;

    public GuiContainer(JFrame frame)
    {
        super(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;

        inputText = new JTextArea();
        inputText.setLineWrap(true);
        inputText.setWrapStyleWord(true);

        inputText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) { }

            @Override
            public void keyReleased(KeyEvent e)
            {
                try {
                    int line = inputText.getLineOfOffset(inputText.getCaretPosition());
                    int pos_start = inputText.getLineStartOffset(line);
                    int pos_end = inputText.getLineEndOffset(line);
                    String str = inputText.getText().substring(pos_start, pos_end);
                    Definitions def = new Definitions();
                    IInstruction instr = def.parseInstruction(str);
                    if (instr != null)
                    {
                        instr.execute(str);
                    }
                } catch (BadLocationException e1) {	}
            }
        });

        outputText = new JTextArea("This is the output text box.\nWrite instructions in the box on the left, such as:\n\n\"color the text yellow\"\n\nor\n\n\"make the background color black\"");
        outputText.setLineWrap(true);
        outputText.setWrapStyleWord(true);

        // Create input text scroll pane
        inputScrollPane = new JScrollPane(inputText);
        inputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        c.gridx = 0;
        add(inputScrollPane, c);

        // Create output text scroll pane
        outputScrollPane = new JScrollPane(outputText);
        outputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        c.gridx = 1;
        add(outputScrollPane, c);
    }

    public JTextArea getInput()
    {
        return inputText;
    }

    public JTextArea getOutput()
    {
        return outputText;
    }

}
