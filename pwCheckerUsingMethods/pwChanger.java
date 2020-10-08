/*
    Password changer
    User is asked to change their password
    Check if the password meets complexity criteria
    Must contain a number, special character
    Cannot be the same as the last 3 passwords used
    Cannot contain a word from a defined dictionary (list of most commonly used words)
    If an invalid password is chosen, it should ask for another one
    Possible way to approach it:
    public static void main(String[] args) {
       String currPw;
       String[] prevPw = {"adam", "sandler", "president"};


       currPw = changePw(prevPw);
    }


    static String changePw(String[] prevPw) {
       //loop through until a new password is set
       String aNewPwThatIsValid;
       return aNewPwThatIsValid;
    }

 */

import java.util.Scanner;

public class PwChanger {
    static Scanner key = new Scanner(System.in);

    public static void main(String[] args) {
        String currPw;
        String[] prevPw = {"adam", "sandler", "president"};

        currPw = changePw(prevPw);
    }

    static String changePw(String[] prevPw) {
        //loop through until a new password is set
        final int NUM_TRIES = 99;
        int tries = 0;
        boolean isValid = false;
        // assume true then flip to false if a condition isn't met
        String pw="";

        while (tries < NUM_TRIES && !isValid) {
            isValid = true;
            System.out.println("Please enter new password that meets minimum complexity criteria: ");
            pw = key.next();

            // check for each of the criteria
            // if it doesn't contain a number, flip flag
            if (!containsNumber(pw)) {
                isValid = false;
            }

            // if it doesn't container a special character, flip flag
            if (!containsSpecial(pw)) {
                isValid = false;
            }

            // if it was already used, flip flag
            if (previouslyUsed(pw, prevPw)) {
                isValid = false;
            }

            // if it's in dictionary, flip flag
            if (foundInDictionary(pw)) {

            }
            tries++;
        }

        return pw;
    }

    static boolean containsNumber(String pw) {
        for (int i = 0; i < pw.length(); i++) {
            /*
            char thing = pw.charAt(i);
            boolean isNumber = Character.isDigit(thing);
            if (isNumber) return true;
             */
            if (Character.isDigit(pw.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    static boolean containsSpecial(String pw) {
        return true;
    }

    static boolean previouslyUsed(String pw, String[] prev) {
        return false;
    }

    static boolean foundInDictionary(String pw) {
        return false;
    }
}
