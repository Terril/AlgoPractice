import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String args[]) {

    int[] arr = new int[] {2, 3, -7, 6, 8, 1, -10, 15 };
    int k = 17;
    // solutionTask2(arr);
    int count = findMissingNumber(arr);//frogRecursionProblem(11);
    System.out.println(count);
  }

  //  private static void solutionTask1(int[] arr, int k) {
  //    ArrayList<Integer> result = new ArrayList<Integer>();
  //    for (int i = 0; i < arr.length; i++) {
  //      for (int j = i + 1; j < arr.length; j++) {
  //        if ((arr[i] + arr[j]) == k) {
  //          result.add(arr[i]);
  //          result.add(arr[j]);
  //        }
  //      }
  //    }
  //
  //    for (int items : result) {
  //      System.out.println(items);
  //    }
  //  }

  private static void solutionTask2(int[] arr) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      int multiplier = 1;
      for (int j = arr.length - 1; j >= 0; j--) {
        if (arr[i] != arr[j]) {
          multiplier = multiplier * arr[j];
        }
      }
      result.add(multiplier);
    }

    for (int items : result) {
      System.out.println(items);
    }
  }

  void foldingProblemSolution() {

    class LLNode {
      int val;
      LLNode next;
    }

    class Solution {
      public LLNode solve(LLNode node) {
        // Write your code here
        int a = lengthOfNode(node);
        if (a <= 1) {
          return node;
        }

        int halfNode = a / 2;

        int position = 0;
        LLNode nextNode = null;
        LLNode tail = node;

        while (position < halfNode) {
          LLNode temp = new LLNode();
          temp.next = nextNode;
          temp.val = tail.val;
          nextNode = temp;

          tail = tail.next;

          position++;
        }

        LLNode p = new LLNode();
        if (a % 2 == 1) {
          p.val = tail.val;
          tail = tail.next;
        }

        LLNode addNode = p;
        while (tail != null) {
          addNode.next = new LLNode();
          addNode = addNode.next;
          addNode.val = tail.val + nextNode.val;
          nextNode = nextNode.next;
          tail = tail.next;
        }

        if (a % 2 == 0) {
          return p.next;
        } else {
          return p;
        }
      }

      int lengthOfNode(LLNode node) {
        int len = 0;
        while (node != null) {
          len += 1;
          node = node.next;
        }
        return len;
      }
    }
  }

  //  void solutionApasDay1() {
  //    class Node {
  //      int value;
  //      Node next;
  //    }
  //    class Solution {
  //      Node solution(Node n) {
  //        int a = lengthOfNode(n);
  //        if (a <= 1) {
  //          return n;
  //        }
  //
  //        Node nextNode = null;
  //        Node r = n;
  //        int pos = 0;
  //        while (pos <= a) {
  //          Node temp = new Node();
  //          temp.value = r.value;
  //          temp.next = nextNode;
  //
  //          r = r.next;
  //          pos++;
  //        }
  //      }
  //
  //      int lengthOfNode(Node node) {
  //        int len = 0;
  //        while (node != null) {
  //          len += 1;
  //          node = node.next;
  //        }
  //        return len;
  //      }
  //    }
  //  }

  void countNodes() {

    class Node {
      int val;
      Node next;
    }

    class Solution {
      private void countNodes(Node head) {

        int nodes = lengthOfNodes(head);
      }

      int lengthOfNodes(Node node) {

        int count = 0;
        while (node.next != null) {
          node = node.next;
          count += 1;
        }

        return count;
      }
    }
  }

  static int frogRecursionProblem(int formidablePos) {
    //
    //    if (formidablePos == 0) {
    //      return 0;
    //    }
    //    if (formidablePos == 1) {
    //      return 1;
    //    }
    //    return frogRecursionProblem(formidablePos - 1) + frogRecursionProblem(formidablePos - 2);
    if (formidablePos > 0) {
      return frogRecursionProblem(formidablePos - 1) + frogRecursionProblem(formidablePos - 2);
    } else {
      return 1;
    }
  }
//
//  static String longestString(String data) {
//
//    for (char c : data.toCharArray()) {
//      char temp = c;
//    }
//  }

  private void numWays(String digits) {
    int length = digits.length();
    if (length >= 0) {
      char a = digits.charAt(length);
      numWays(digits.substring(0, digits.length() - 1));
    }
  }

  static int findMissingNumber(int[] arr) {
  boolean[] items = new boolean[arr.length + 1];
    for (int i = 0; i < arr.length; i++) {

      if (arr[i] > 0 && arr[i] <= arr.length) {
        items[arr[i]] =  true;
      }
    }
    for (int j = 1; j <= arr.length; j++) {
      if (!items[j]) {
        return j;
      }
    }

    return arr.length + 1;
  }
}
