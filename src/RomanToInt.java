import java.util.HashMap;

public class RomanToInt {
    public static void main(String args[]) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if(s.length() == 1) {
            return map.get(s.charAt(0));
        }

        int num;
        int a = map.get(s.charAt(s.length() - 1));
        int b = map.get(s.charAt(s.length() - 2));
        if(a > b) {
            num = a - b;
        } else {
            num = a + b;
        }
        for(int i = s.length() - 3; i >= 0; i-- ) {
            int c = map.get(s.charAt(i));

            if(b > c) {
                num -= c;
            } else {
                num += c ;
            }

            b = c;
        }

        return num;
    }
}
