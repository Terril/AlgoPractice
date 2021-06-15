import java.util.Arrays;

public class Panagram {
    public static void main(String args[]) {
        String s = "We promptly judged antique ivory buckles for the next prize";
        System.out.println(pangrams(s));
    }

    public static String pangrams(String s) {
        // Write your code here

        int [] alpha = new int[26];
        Arrays.fill(alpha, -1);

        s = s.toLowerCase().replaceAll("\\s","").trim();
        for (char c: s.toCharArray()) {
            int pos = (int) c - 'a';
            alpha[pos] = 1;
        }

        for(int i = 0; i < alpha.length; i++) {
            if(alpha[i] == -1) {
                return "not pangram";
            }
        }

        return "pangram";
    }
}
