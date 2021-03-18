import java.util.*;

public class AccentureTestCode {

    public static void main(String args[]) {
        String[] arr = new String[]{"712", "246", "365", "312"};
        System.out.println(sumCount(arr));
    }

    static int sumCount(String[] arr) {
        int row = arr.length;
        int col = arr[0].length();

        List<List<Integer>> a = new ArrayList<>();
        for (int x = 0; x < row; x++) {
            String p = arr[x];
            ArrayList<Integer> n = new ArrayList<>();
            for (int y = 0; y < col; y++) {
                int d = Integer.parseInt(String.valueOf(p.charAt(y)));
                n.add(d);
            }
            a.add(n);
        }
        int k = col;
        int maxCount = 0;
        while (col > 0) {
            int tempCount = 0;
            for (int i = 0; i < a.size(); i++) {
                int pos = 0;
                int value = 0;
                List<Integer> arrayData = a.get(i);
                for (int j = 0; j < arrayData.size(); j++) {
                    int d = arrayData.get(j);
                    if (value < d) {
                        value = d;
                        pos = j;
                    }
                }
                if (tempCount < value) {
                    tempCount = value;
                }
                arrayData.remove(pos);
            }
            maxCount += tempCount;
            col--;
        }
        return maxCount;
    }
}
