public class DCP186 {
    public static void main(String args[]) {

        int arr[] = {5, 10, 15, 20, 25};
        int diff = calculateSmallestSubset(arr, arr.length);

        System.out.println(diff);

        findTheSubSets(arr);
    }

    private static int calculateSmallestSubset(int[] arr, int n) {
        int sumTotal = 0;
        for (int i = 0; i < n; i++)
            sumTotal += arr[i];

        // Compute result using recursive function
        return findMinRec(arr, n, 0, sumTotal);
    }

    private static int findMinRec(int arr[], int i,
                                  int sumCalculated,
                                  int sumTotal) {
        // If we have reached last element.
        // Sum of one subset is sumCalculated,
        // sum of other subset is sumTotal-
        // sumCalculated.  Return absolute
        // difference of two sums.
        if (i == 0)
            return Math.abs((sumTotal - sumCalculated) -
                    sumCalculated);


        // For every item arr[i], we have two choices
        // (1) We do not include it first set
        // (2) We include it in first set
        // We return minimum of two choices
        return Math.min(findMinRec(arr, i - 1, sumCalculated
                        + arr[i - 1], sumTotal),
                findMinRec(arr, i - 1,
                        sumCalculated, sumTotal));
    }

    private static void findTheSubSets(int arr[]) {
        int largestVariable = arr[0];
        int sub[] = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            if (largestVariable < arr[i]) {
                largestVariable = arr[i];
            } else {
                sub[i - 1] = arr[i];
                System.out.println(sub[i - 1]);
            }
        }

        System.out.println(largestVariable);
    }
}
