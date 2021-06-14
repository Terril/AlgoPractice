public class CaesarCipher {
    public static void main(String args[]) {

        System.out.println(caesarCipher("middle-Outz", 2));
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        String output = "";

        for (char c : s.toCharArray()) {
            int val = c;
            if(val >= 97 && val <= 122) {
                 val = ((c + k - 97) % 26 + 97);
            } else if(val >= 65 && val <= 90) {
                val = ((c + k - 65) % 26 + 65);
            }
            c = (char) val;
            output += c;
        }

        return output;
    }
}
