package edu.sjsu;

public class NameChecker {
    /**
     * Checks if a given string is a valid name following these rules:
     * - Between 2 to 40 characters
     * - Contains only alphabetic characters, non-consecutive hyphens, or a single quote
     * - Cannot start with a hyphen or single quote
     * 
     * @param input Name to check
     * @return True if input is a valid name, else false
     */
    public static boolean check(String input) {
        if(input == null || input.length()  < 2 || input.length() > 40){
            return false;
        }
        if (input.startsWith("-") || input.startsWith("'")) {
            return false;
        }
        boolean lastWasHyphen = false;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isAlphabetic(ch)) {
                lastWasHyphen = false;
            } else if ((ch == '-' || ch == '\'') && (lastWasHyphen || i == input.length() - 1)) {
                return false;
            } else if (ch != '-' && ch != '\'') {
                return false;
            } else {
                lastWasHyphen = (ch == '-');
            }
        }
        return true;
    }
}
