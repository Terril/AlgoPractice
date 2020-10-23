import java.util.HashSet;
import java.util.Set;

public class DCP181 {
    public static void main(String args[]) {
        palindromeSubStrs("racecarannakayak");
    }

    public static void palindromeSubStrs(String str) {
        Set<String> set = new HashSet<String>();
        String subString = "";

        for (int i = 0; i < str.length(); i++) {
            subString = str.charAt(i) + "";
//Add current item to subset.
            set.add(subString);

            addStrings(str, i - 1, i + 1, subString, set);

//            if (i > 1 && str.charAt(i - 1) == str.charAt(i)) {
//                subString = str.charAt(i - 1) + "" + str.charAt(i);
//                set.add(subString);
//                addStrings(str, i - 2, i + 1, subString, set);
//            }

        }

        for (String s : set) {
            System.out.println(s);
        }
    }

    /**
     * Iterate over pivot point and add matching strings
     * Iteration happen 1 + 3 + 5 ...+ n/2.. 5 + 3 +1 = logn
     **/
    public static void addStrings(String str, int posLeft, int posRight, String subString, Set<String> set) {
//if left > 0 && right < 0 and left char == right char
        while (posLeft >= 0 && posRight <= str.length() - 1 && (str.charAt(posLeft) == str.charAt(posRight))) {
            subString = str.charAt(posLeft) + subString + str.charAt(posRight);
            set.add(subString);

            posLeft--;
            posRight++;
        }

    }


}
