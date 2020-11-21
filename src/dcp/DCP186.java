package dcp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
        int otherSummedValue = arr[0];
        Set A = new HashSet<Integer>();
        Set B = new HashSet<Integer>();
        int sub[] = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            if (largestVariable < arr[i]) {
                B.remove(largestVariable);
                largestVariable = arr[i];
                B.add(largestVariable);
                A.add(arr[i]);
            } else {
                sub[i - 1] = arr[i];
                otherSummedValue += arr[i];
                if (otherSummedValue < largestVariable) {
                    A.add(arr[i]);
                } else {
                    B.add(arr[i]);
                }
            }
        }

        Iterator<Integer> it = A.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Iterator<Integer> its = B.iterator();
        while(its.hasNext()){
            System.out.println(its.next());
        }
        System.out.println(largestVariable);
    }
}
