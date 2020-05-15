import java.util.Scanner;

public class Rotate2DArrayGFG {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();

    for (int y = 0; y < x; y++) {
      int n = sc.nextInt();
      int arr[][] = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          arr[i][j] = sc.nextInt();
        }
      }
      int[][] res = rotateTheArray(arr);
      for (int i = 0; i < res.length; i++) {
        for (int j = 0; j < res.length; j++) {
          System.out.print(res[i][j]);
        }
      }
    }
  }

  private static int[][] rotateTheArray(int[][] arr) {

    int n = arr.length;
    int i = 0, j = 0, a = 0, b = 0;
    arr[a][b] = arr[i][j];
    for (i = 0; i < n; i++) {

      for (j = n - 1; j >= 0; j--) {
        System.out.println(arr[j][i]);
      }
    }

    return arr;
  }
}
