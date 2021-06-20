public class LargestOddNumber {
    public static void main(String args[]) {
        System.out.println(largestOddNumber("32782489638346578713315098393010310518347382"));
    }

    public static String largestOddNumber(String num) {

        int len = num.length() - 1;
        char ch = num.charAt(len);
        int x = Character.getNumericValue(ch);

        if ((x % 2) == 1) {
            return num;
        }
        //helper(num, len - 1, len);
         for(int i = len; i >= 0; i--) {
             char c = num.charAt(i);
             int val = Character.getNumericValue(c);
             if(val % 2 == 1) {
                 return num.substring(0, i + 1);
             }
         }


        return  "";
    }

    private static int helper(String num, int startIndex, int endIndex) {
        if(startIndex <= 0) {
            return 1;
        }
        String val = num.substring(startIndex, endIndex);
        int oddV = Integer.parseInt(val);
        if (oddV % 2 == 1) {
           helper(num, startIndex - 1, endIndex);
        }

        return oddV;
    }
}
