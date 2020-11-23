package dcp;

public class DCP202 {
    public static void main(String args[]) {

        int num = 678;

        try {
            isPalindrome(num);
            System.out.println("Is Palindrome");
        } catch (Exception e) {
            System.out.println("Not a Palindrome");
            e.printStackTrace();
        }
    }

    private static int isPalindrome(int num) throws Exception {

        if (num < 0) {
            num = -(num);
        }

        int dupNum = num;

        return isPaliUtil(num, dupNum);
    }

    private static int isPaliUtil(int num, int dup) throws Exception {
        if (num == 0) {
            return dup;
        } else {
            dup = isPaliUtil(num / 10, dup);
        }

        if (num % 10 == dup % 10) {
            return dup / 10;
        } else {
            throw new Exception();
        }

    }
}
