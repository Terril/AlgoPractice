public class DeliveryHeroProblem {
    public static void main(String args[]) {

        int input = 105;
        System.out.println(findFirstBadVersion(input));
    }

    private static int findFirstBadVersion(int in) {
        int mid = in / 2;
        boolean check = isBadVersion(mid);
        int start , end;
        if(check) {
            start = 1;
            end = mid;
        } else {
            start = mid + 1 ;
            end = in;
        }

        while (start < end) {
            mid = ((start + end)) / 2;
            check = isBadVersion(mid);
            if(check) {
                end--;
            } else {
                start++;
            }
        }

        return mid + 1;
    }


    private static boolean isBadVersion(int version) {
        return version >= 41;
    }
}
