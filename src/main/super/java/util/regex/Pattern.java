package java.util.regex;

import com.google.gwt.regexp.shared.RegExp;

/**
 * Emulation of the {@link Pattern} class, uses {@link RegExp} as internal
 * implementation.
 * 
 * @author hneuer
 */
public class Pattern {
    /**
     * Declares that regular expressions should be matched across line borders.
     */
    public final static int MULTILINE = 1;

    /**
     * Declares that characters are matched reglardless of case.
     */
    public final static int CASE_INSENSITIVE = 2;

    public final static int DOTALL = 3;

    final RegExp regExp;

    private Pattern(String pattern) {
        this(pattern, 0);
    }

    /**
     * Class constructor
     *
     * @param pattern Regular expression
     * @param flags
     */
    public Pattern(String pattern, int flags) {
        String sFlags = "";
        if ((flags & MULTILINE) != 0)  sFlags += "m";
        if ((flags & CASE_INSENSITIVE) != 0) sFlags += "i";
        if ((flags & DOTALL) != 0) sFlags += "s";
        if(sFlags.isEmpty()) sFlags = "g";
        this.regExp = RegExp.compile(pattern, sFlags);
    }

    public static Pattern compile(String pattern) {
        return new Pattern(pattern);
    }

    public static Pattern compile(String pattern, int flags) {
        return new Pattern(pattern, flags);
    }

    /**
     * Escape a provided string so that it will be interpreted as a literal in
     * regular expressions. The current implementation does escape each character
     * even if not neccessary, generating verbose literals.
     *
     * @param input
     * @return
     */
    public static String quote(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output += "\\" + input.charAt(i);
        }
        return output;
    }

    /**
     * Create a matcher for this pattern and a given input character sequence
     *
     * @param cs The input character sequence
     * @return A new matcher
     */
    public Matcher matcher(CharSequence input) {
        return new Matcher(this, input);
    }
}