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
        //btwn 2 and 40 chars
        if(input == null || input.length()  < 2 || input.length() > 40){
            return false;
        }
        //cannot start with hyphen or single quote
        if (input.startsWith("-") || input.startsWith("'")) {
            return false;
        }
        boolean lastWasHyphen = false;
        int singleQuote = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '\'') singleQuote++;
            if (Character.isAlphabetic(ch)) {
                lastWasHyphen = false;
            }
            //if character is a hyphen or quote and the last character was a hyphen or quote then return false
            else if ((ch == '-' || ch == '\'') && lastWasHyphen) {
                return false;
            }
            //if char is smth else entirely
            else if (ch != '-' && ch != '\'') {
                return false;
            }
            else if (singleQuote >= 2){
                return false;
            }
            else {
                lastWasHyphen = (ch == '-');
            }
        }
        return true;
    }
}
