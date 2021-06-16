public class TheTimeInWords {
    public static void main(String args[]) {
        int hour = 5;
        int minutes = 47;
        System.out.println(timeInWords(hour, minutes));
    }

    public static String timeInWords(int h, int m) {
        // Write your code here
        String[] v = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"};

        String time;

        if (m <= 30) {
            if (m == 0)
                time = v[h] + " o' clock";
            else if (m == 15)
                time = "quarter past " + v[h];
            else if (m == 30)
                time = "half past " + v[h];
            else if (m == 1)
                time = v[m] + " minute past " + v[h];
            else
                time = v[m] + " minutes past " + v[h];
        } else {
            if (m == 45)
                time = "quarter to " + v[h + 1];
            else if (m == 59)
                time = v[60 - m] + " minute to " + v[h + 1];
            else
                time = v[60 - m] + " minutes to " + v[h + 1];
        }
        return time;
    }
}
