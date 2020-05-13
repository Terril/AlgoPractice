import java.util.Random;

public class FacebookRandomStreamElement {

    public static void main(String args[]) {

        int[] arr = new int[]{1, 5, 3, 4};
        for (int i = 0; i < arr.length; i++) {
            int res = pickingUpRandomNumberFromStream(arr[i]);
            System.out.println(pickingUpRandomNumberFromStream(arr[i]));
        }

    }

    static int res = 0;    // The resultant random number
    static int count = 0;

    private static int pickingUpRandomNumberFromStream(int number) {

        count++;
        if (count == 1) {
            res = number;
        } else {
            Random random = new Random();
            int randomNumber = random.nextInt(count);
            if (randomNumber == count - 1) {
                res = number;
            }

        }
        return res;
    }
}
