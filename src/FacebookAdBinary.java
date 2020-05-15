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
}
