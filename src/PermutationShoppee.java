import java.util.ArrayList;
import java.util.List;
/*
* Permutation of elements in an Array
*
* Eg : {1,2,3}
*
* output : {1,2,3}, {2,1,3}, {3,2,1}, {2,3,1}, {3,1,2}, {1,3,2}
* */
public class PermutationShoppee {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
//        List<List<Integer>> output = permute(arr);
//
//        for (List result : output) {
//            System.out.println(result);
//        }
        permute(arr, 0, arr.length);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        dfs(nums, results, result);
        return results;
    }

    public static void dfs(int[] nums, List<List<Integer>> results, List<Integer> result) {
        if (nums.length == result.size()) {
            List<Integer> temp = new ArrayList<>(result);
            results.add(temp);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!result.contains(nums[i])) {
                result.add(nums[i]);
                dfs(nums, results, result);
                result.remove(result.size() - 1);
            }
        }
    }

    static void permute(int[] array, int i, int length) {
        if (length == i) {
            printArray(array, length);
            return;
        }
        int j = i;
        for (j = i; j < length; j++) {
            swap(array,i, j);
            permute(array, i + 1, length);
            swap(array, i, j);
        }
        return;
    }

    private static void printArray(int[] array, int length) {

        for (Integer it : array) {
            System.out.println(it);
        }
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
