package dcp;

public class DCP212 {
    public static void main(String args[]) {
        int number = 27;
        findStringFromNumber(number);
    }

    private static void findStringFromNumber(int number) {

        StringBuilder builder = new StringBuilder();

        while (number > 0) {

            int rem = number % 26;

            if (rem == 0) {
                builder.append("Z");
                number = (number / 26) - 1;
            } else {
                builder.append((char) ((rem - 1) + 'A'));
                number = number / 26;
            }
        }
        System.out.println(builder.reverse());
    }
}
