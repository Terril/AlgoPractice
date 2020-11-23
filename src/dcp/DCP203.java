package dcp;

public class DCP203 {
    public static void main(String args[]) {
        int[] arr = {5, 7, 10, 3, 4};
        System.out.println(findMinimumElement(arr, 0, arr.length - 1));
    }

    private static int findMinimumElement(int[] arr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[high]) {
                high--;
            } else if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[high];
    }
}
