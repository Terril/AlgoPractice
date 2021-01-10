package dcp;

/*
 * This problem was asked by Twitter.
 *
 * You are given an array of length 24,
 * where each element represents the number of new subscribers during the corresponding hour.
 * Implement a data structure that efficiently supports the following:
 *
 * update(hour: int, value: int): Increment the element at index hour by value.
 *
 * query(start: int, end: int): Retrieve the number of subscribers that have signed up between start and end (inclusive).
 *
 * You can assume that all values get cleared at the end of the day,
 * and that you will not be asked for start and end values that wrap around midnight.
 * */
public class DCP242 {
    public static void main(String args[]) {
        int N = 24;
        int[] arr = {2, 3, 4, 5, 6, 7, 12, 22, 19, 10, 2, 3, 4, 5, 6, 7, 12, 22, 19, 10, 34, 43, 12, 33};

        System.out.println(query(2, 21, arr));
        System.out.println(update(2, 11, arr));
    }

    static int update(int hour, int val, int[] arr) {
       return arr[hour] = arr[hour] + val;
    }

    static int query(int start, int end, int arr[]) {
        int val = 0;
        for (int i = start; i < arr.length; i++) {
            if (i == end) {
                break;
            }
            val = val + arr[i];
        }

        return val;
    }
}
