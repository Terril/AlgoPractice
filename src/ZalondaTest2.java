import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZalondaTest2 {
    public static void main(String args[]) {
        int[] in = {2,-2,3,0,4,-7};
        int[] in2 = {0,0,0,0,0,0,0,5,0,0,0,0,0};
        //System.out.println(numberOfRanges(in2));
        System.out.println(findSubArrays(in2, in2.length));
    }

    static int numberOfRanges(int[] array) {
        List<int[]> result = new ArrayList<int[]>();
        for (int i = 0; i < array.length; i++) {     // go from 0 to N-1  --> i
            for (int j = i; j < array.length; j++) {  // go from i to N-1  --> j
                int sum = 0;

                // sum the values up from "i" to "j"
                for (int k = i; k <= j; k++) {
                    sum += array[k];
                }

                if (sum == 0) {
                    int[] indices = new int[]{i, j};
                    result.add(indices);
                }
            }
        }
        return result.size();

    }

    static int findSubArrays(int[] arr, int n)
    {
        // create an empty map
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        // create an empty vector of pairs to store
        // subarray starting and ending index
        ArrayList<Pair> out = new ArrayList<>();

        // Maintains sum of elements so far
        int sum = 0;
        boolean flag = false;
        boolean justZeros = true;
        for (int i = 0; i < n; i++)
        {
            // add current element to sum
            if(arr[i] == 0 && justZeros) {
                flag = true;
            } else {
                flag = false;
                justZeros = false;
            }
            sum += arr[i];

            // if sum is 0, we found a subarray starting
            // from index 0 and ending at index i
            if (sum == 0)
                out.add(new Pair(0, i));
            ArrayList<Integer> al = new ArrayList<>();

            // If sum already exists in the map there exists
            // at-least one subarray ending at index i with
            // 0 sum
            if (map.containsKey(sum))
            {
                // map[sum] stores starting index of all subarrays
                al = map.get(sum);
                for (int it = 0; it < al.size(); it++)
                {
                    out.add(new Pair(al.get(it) + 1, i));
                }
            }
            al.add(i);
            map.put(sum, al);
        }

        if(arr[arr.length - 1] == 0 && flag) {
            return -1;
        }
        return out.size();
    }
    static class Pair
    {
        int first, second;
        Pair(int a, int b)
        {
            first = a;
            second = b;
        }
    }
}
