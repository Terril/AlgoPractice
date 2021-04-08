import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemStatement {
    public static void main(String args[]) {
        List arr = new ArrayList();
        arr.add(5);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.add(1);
        arr.add(2);


       List<Integer> res =  minimalHeaviestSetA(arr);

        for (int r: res
             ) {
            System.out.println(r);
        }
    }

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {

        int i;
        if (arr.size() < 2) {
            return arr;
        }

        Collections.sort(arr);
        List<Integer> result = new ArrayList<Integer>();

        for (i = arr.size() - 2; i >= 0; i--) {
            int A = arr.get(i) + arr.get(arr.size() - 1);
            int B = 0;
            for (int j = 0; j < i; j++) {
                B += arr.get(j);
            }
            if (A > B) {
                result.add(arr.get(i));
                result.add(arr.get(arr.size() - 1));
                break;
            }

        }

        return result;
    }

}


//class Result {
//
//    /*
//     * Complete the 'minimalHeaviestSetA' function below.
//     *
//     * The function is expected to return an INTEGER_ARRAY.
//     * The function accepts INTEGER_ARRAY arr as parameter.
//     */
//
//    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
//
//        int i , first, second;
//        if(arr.size() < 2) {
//            return arr;
//        }
//
//        Collections.sort(arr);
//        List<Integer> result = new ArrayList<Integer>();
//
//        for(i = arr.size()-2 ; i >=0; i--) {
//            int A = arr.get(i) + arr.get(arr.size() - 1);
//            int B = 0;
//            for(int j = 0; j < i ; j++ ) {
//                B+=arr.get(j);
//                if(A>B) {
//                    result.add(arr.get(i));
//                    result.add(arr.get(arr.size() - 1));
//                    break;
//                }
//            }
//
//        }
//
//        return result;
//    }
//
//}
//
//public class Solution {