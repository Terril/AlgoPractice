package dcp;

import java.util.Arrays;
import java.util.List;

/*
* This problem was asked by Nest.
*
* Create a basic sentence checker that takes in a stream of characters and determines whether they form valid sentences.
* If a sentence is valid, the program should print it out.

We can consider a sentence valid if it conforms to the following rules:

1. The sentence must start with a capital letter, followed by a lowercase letter or a space.
2. All other characters must be lowercase letters, separators (,,;,:) or terminal marks (.,?,!,‽).
3. There must be a single space between each word.
4. The sentence must end with a terminal mark immediately following a word.
*
* */
public class DCP263 {
    public static void main(String args[]) {
        List<String> list = Arrays.asList(
                "This sentence is syntactically correct.",

                "This sentence is syntactically  incorrect as two " +
                        "continuous spaces are not allowed.",

                "This sentence is syntactically correct Y.",

                "This sentence is syntactically incorRect as uppercase " +
                        "character is not allowed midway of the String.",

                "THis sentence is syntactically incorrect as two " +
                        "continuous uppercase characters are not allowed.",

                "This sentence is syntactically incorrect as it doesn't " +
                        "end with a full stop"
        );

        System.out.println("The valid sentences are:");
        for (String sentence : list) {
            if (validateSentence(sentence.toCharArray())) {
                System.out.println(sentence);
            }
        }
    }

    private static boolean validateSentence(char[] items) {
        int index = 0;
        String terminals = ".,?,!,‽";
        if (Character.isLowerCase(items[index])) {  // 1st condition
            return false;
        }

        while (index < items.length) {
            if (Character.isUpperCase(items[index])) {
                if (Character.isUpperCase(items[index + 1])) {      // 1th condition
                    return false;
                }

                if (index - 1 >= 0 && items[index - 1] != ' ') {    // 2nd condition
                    return false;
                }
            }

            if (items[index] == ' ' && items[index + 1] == ' ') {   // 3rd condition
                return false;
            }

            index++;
        }

        char terminal = ' ';
        for (char c : terminals.toCharArray()) {
            if (items[index - 1] == c) {
                terminal = c;
                break;
            }
        }

        if (items[index - 2] == ' ' || items[index - 1] != terminal) {   // 4th condition
            return false;
        }

        return true;
    }
}
