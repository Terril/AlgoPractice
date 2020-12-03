package dcp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
* This problem was asked by Snapchat.

* Given a string of digits, generate all possible valid IP address combinations.
* IP addresses must follow the format A.B.C.D, where A, B, C, and D are numbers between 0 and 255.
* Zero-prefixed numbers, such as 01 and 065, are not allowed, except for 0 itself.
* For example, given "2542540123", you should return ['254.25.40.123', '254.254.0.123'].
* */
public class DCP213 {
    public static void main(String args[]) {
        String value = "2542540123"; // Valid
        String value1 = "25505011535"; // Invalid
        List<String> res = findIPAddressFromTheString(value);

        for (String val: res) {
            System.out.println(val);
        }
    }

    private static ArrayList<String> findIPAddressFromTheString(String value) {

        if (value.length() < 3 || value.length() > 12) {
            return new ArrayList<>();
        }
        return convert(value);
    }

    private static ArrayList<String> convert(String value) {
        int len = value.length();
        String sNew = value;
        ArrayList<String> set = new ArrayList<>();

        for (int i = 1; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    sNew = sNew.substring(0, k) + (".") + sNew.substring(k);
                    sNew = sNew.substring(0, j) + (".") + sNew.substring(j);
                    sNew = sNew.substring(0, i) + (".") + sNew.substring(i);
                    if (isValid(sNew)) {
                        set.add(sNew);
                    }
                    sNew = value;
                }
            }
        }

        Collections.sort(set, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String arr1[] = o1.split("[.]");
                String arr2[] = o2.split("[.]");

                int result = -1;
                for (int i = 0; i < 4 && result != 0; i++) {
                    result = arr1[i].compareTo(arr2[2]);
                }
                return result;
            }
        });

        return set;
    }

    private static boolean isValid(String newVal) {
        String arr[] = newVal.split("[.]");
        if (arr.length > 0) {
            for (String sVal : arr) {
                int intChar = Integer.parseInt(sVal);
                if (intChar > 255 || intChar < 0 || sVal.length() > 3) {
                    return false;
                }
                if (sVal.length() > 1 && intChar == 0) {
                    return false;
                }
                if (sVal.length() > 1 && intChar != 0 && sVal.charAt(0) == '0') {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
