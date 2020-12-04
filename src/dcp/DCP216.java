package dcp;
/*
* This problem was asked by Facebook.
*
* Given a number in Roman numeral format, convert it to decimal.
*
* The values of Roman numerals are as follows:

{
    'M': 1000,
    'D': 500,
    'C': 100,
    'L': 50,
    'X': 10,
    'V': 5,
    'I': 1
}
* In addition, note that the Roman numeral system uses subtractive notation for numbers such as IV and XL.
* For the input XIV, for instance, you should return 14.
* */
public class DCP216 {
    public static void main(String args[]) {
        String in = "XIV";
        String in1 = "MCMIV";
        System.out.println(convertRomanNumeralsIntoInt(in));
    }

    static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    private static int convertRomanNumeralsIntoInt(String numeral) {
        int res = 0;
        for (int i = 0; i < numeral.length(); i++) {
            int val = value(numeral.charAt(i));

            if (i + 1 < numeral.length())
            {
                int nexVal = value(numeral.charAt(i + 1));
                if (val >= nexVal)
                {
                    res = res + val;
                }
                else
                {
                    res = res + nexVal - val;
                    i++;
                }
            }
            else {
                res = res + val;
            }
        }

        return res;
    }
}
