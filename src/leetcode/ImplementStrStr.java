package leetcode;

public class ImplementStrStr {
    public static void main(String args[]) {
        System.out.println(strStr("mississippi", "issipi"));
    }

    public static int strStr(String haystack, String needle) {

        if(needle.length() == 0 ) {
            return 0;
        }

        if(needle.length() > haystack.length()) {
            return -1;
        }

        int index = -1;
        for(int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            boolean pass = true;
            if(c == needle.charAt(0)) {
                int j = 0;
                while(j < needle.length() &&
                        haystack.substring(i).length() >= needle.length() ) {
                    char n = needle.charAt(j);
                    char h = haystack.charAt(i + j);
                    if(n != h) {
                        pass = false;
                    }
                    j++;
                }
                if(pass && j == needle.length()) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }
}
