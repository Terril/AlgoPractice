package dcp;

/*
 * This problem was asked by Amazon.
 *
 * Given an array of a million integers between zero and a billion,
 * out of order,
 * how can you efficiently sort it?
 * Assume that you cannot store an array of a billion elements in memory.
 * */
public class DCP251 {
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);

    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int a = 0, b = 0;

        // Initial index of merged subarry array
        int k = l;
        while (a < n1 && b < n2) {
            if (L[a] <= R[b]) {
                arr[k] = L[a];
                a++;
            }
            else {
                arr[k] = R[b];
                b++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (a < n1) {
            arr[k] = L[a];
            a++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (b < n2) {
            arr[k] = R[b];
            b++;
            k++;
        }

    }
}
