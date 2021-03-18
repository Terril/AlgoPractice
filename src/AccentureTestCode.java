import java.util.HashSet;
import java.util.Set;

public class AccentureTestCode {

    public static void main(String args[]) {
        int n = 3;

        String[] arr = new String[]{"712", "345", "546", "446", "135"};
        //sumCount(arr);
        System.out.println(sumCount(arr));
        //System.out.println(findLogic(n));
    }

    static int sumCount(String[] arr) {
        int row = arr.length;
        int col = arr[0].length();

        int k = col;
        int maxCount = 0;
        Set<Integer> s = new HashSet<>();
        while (k > 0) {
            int value = 0;
            for (int i = 0; i < row; i++) {
                String m = arr[i];
                int x = 0;
                for (int j = 0; j < col; j++) {
                    int d = Integer.parseInt(String.valueOf(m.charAt(j)));
                     if (!s.contains(d)) {
                        if (value < d) {
                            value = d;
                        }
                    }
                    if (x < d) {
                        x = d;
                    }
                }
                s.add(x);
            }
            maxCount += value;
            k--;
        }
        return maxCount;
    }

    static int findLogic(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return findLogic(n - 2) + findLogic(n - 1);
        }

    }
}
