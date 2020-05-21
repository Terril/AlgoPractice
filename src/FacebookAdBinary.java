public class FacebookAdBinary {

  public static void main(String args[]) {

    addBinary("1110", "0011");
  }

  static void addBinary(String s, String s1) {

    int n = s.length();

    int carry = 0;
    StringBuilder builder = new StringBuilder();
    for (int k = n - 1; k >= 0; k--) {
      char x = s.charAt(k);
      char y = s1.charAt(k);

      int bin1 = carry + (x - '0') + (y - '0');

      if (bin1 >= 2) {
        carry = 1;
        bin1 = 0;
      } else {
        carry = 0;
      }

      builder.append(bin1);
    }

    System.out.print(builder.reverse());
  }

  static String correctsolution(String a, String b) { // Initialize result
    String result = "";

    // Initialize digit sum
    int s = 0;

    // Traverse both strings starting
    // from last characters
    int i = a.length() - 1, j = b.length() - 1;
    while (i >= 0 || j >= 0 || s == 1) {

      // Comput sum of last
      // digits and carry
      s += ((i >= 0) ? a.charAt(i) - '0' : 0);
      s += ((j >= 0) ? b.charAt(j) - '0' : 0);

      // If current digit sum is
      // 1 or 3, add 1 to result
      result = (char) (s % 2 + '0') + result;

      // Compute carry
      s /= 2;

      // Move to next digits
      i--;
      j--;
    }

    return result;
  }
}
