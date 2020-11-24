package dcp;

public class DCP201 {
    public static void main(String args[]) {
        int arr[][] = {{3, 0, 0, 0}, {7, 4, 0, 0}, {2, 4, 6, 0}, {8, 5, 9, 3}};

        System.out.println(findMaxWeightPath(arr, 3, 3));
    }

    private static int findMaxWeightPath(int arr[][], int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (arr[i + 1][j] > arr[i + 1][j + 1]) {
                    arr[i][j] += arr[i + 1][j];
                } else {
                    arr[i][j] += arr[i + 1][j + 1];
                }
            }
        }

        return arr[0][0];
    }
}
