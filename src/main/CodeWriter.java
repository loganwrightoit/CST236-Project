package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CodeWriter extends JFrame {

	private static final long serialVersionUID = 1L;

	private CodeWriter()
	{
		initUserInterface();
	}

	public void initUserInterface()
	{
		setTitle("CodeWriter");
		setSize(400, 200);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(getRunnable());
	}

	public static CodeWriterRunnable getRunnable()
	{
		return new CodeWriterRunnable();
	}

	/**
	 * A runnable with overrides
	 */
	public static class CodeWriterRunnable implements Runnable {

		private static CodeWriter instance = null;

		@Override
		public void run()
		{
            CodeWriter ex = getInstance();
            ex.setVisible(true);
		}

        public static CodeWriter getInstance()
        {
        	if (instance == null)
        	{
        		instance = new CodeWriter();
        	}
        	return instance;
        }

	}

}
