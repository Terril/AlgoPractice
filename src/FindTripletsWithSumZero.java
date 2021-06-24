import java.util.ArrayList;
import java.util.Collections;

public class FindTripletsWithSumZero {
    public static void main(String args[]) {
        ArrayList<Integer> inp = new ArrayList<>();
        inp.add(6);
        inp.add(0);
        inp.add(3);
        inp.add(-3);
        inp.add(4);
        inp.add(3);

        ArrayList<ArrayList<Integer>> res = findTriplets(inp);
        System.out.println(res.size());
        for (ArrayList<Integer> out : res) {
            for (Integer r : out) {
                System.out.print(r + ",");
            }
            System.out.println();
        }
    }

    // Input: [6, 0, 3, -3 , 4, -3 ]


    // 6
// 0
//
    private static ArrayList<ArrayList<Integer>> solution(ArrayList<Integer> input) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        if (input == null || input.size() == 0) {
            return output;
        }

        int len = input.size(); //6
        for (int i = 0; i < len; i++) {
            int vali = input.get(i);
            for (int j = i + 1; j < len; j++) {
                int valj = input.get(j);
                // len = (len - i - j); // -1
                for (int k = 0; k < input.size(); k++) {
                    int valk = input.get(k);
                    int sum = vali + valj + valk;

                    if (sum == 0 && !isAvailable(output, vali, valj, valk)) {
                        ArrayList<Integer> sumList = new ArrayList<>();
                        sumList.add(vali);
                        sumList.add(valj);
                        sumList.add(valk);

                        output.add(sumList);
                    }
                }
            }

        }

        return output;

    }

    private static boolean isAvailable(ArrayList<ArrayList<Integer>> out, int i, int j, int k) {

        int count = 0;
        for (ArrayList<Integer> list : out) {

            for (Integer res : list) {
                if (res == i || res == j || res == k) {
                    count++;
                }
            }

        }

        return count >= 3;
    }

    private static ArrayList<ArrayList<Integer>> findTriplets(ArrayList<Integer> input) {

        Collections.sort(input);

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        int n = input.size();
        for (int i = 0; i <  n -1; i++) {
            int l = i + 1;
            int r = n - 1;
            int x = input.get(i);

            while (l < r) {
                if (x + input.get(l) + input.get(r) == 0) {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(x);
                    res.add(input.get(l));
                    res.add(input.get(r));

                    output.add(res);
                    l++;
                    r--;
                } else if (x + input.get(l) + input.get(r) < 0) {
                    l++;
                } else {
                    r--;
                }
            }

        }

        return output;
    }


}

