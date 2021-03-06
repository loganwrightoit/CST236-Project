package main.java.util;

import java.util.Hashtable;
import java.util.StringTokenizer;

import main.java.gui.instructions.ColorInstruction;
import main.java.gui.instructions.FontInstruction;
import main.java.gui.instructions.IInstruction;
import main.java.gui.instructions.StyleInstruction;

public class Definitions {

    // Stores keyword and associated instruction class type
    private static Hashtable<String, Class<? extends IInstruction>> keywords;
    static {
        keywords = new Hashtable<String, Class<? extends IInstruction>>();
        keywords.put("color", ColorInstruction.class);
        keywords.put("style", StyleInstruction.class);
        keywords.put("font", FontInstruction.class);
    }

    /**
     * Parses a string into an executable instruction.
     *
     * @param input
     * @return an {@link IInstruction instruction}
     */
    public IInstruction parseInstruction(String input)
    {
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens())
        {
            // Look for a keyword
            String token = st.nextToken();
            Class<? extends IInstruction> clazz = keywords.get(token);

            if (clazz != null)
            {
                try {
                    return getClassInstance(clazz);
                } catch (Exception e) { }
            }
        }

        return null;
    }

    /**
     * Grabs a new instance of the class and returns it.
     *
     * @param clazz
     * @return an {@link IInstruction instruction}
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public IInstruction getClassInstance(Class<? extends IInstruction> clazz) throws InstantiationException, IllegalAccessException
    {
        return clazz.newInstance();
    }

}
