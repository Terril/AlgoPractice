import java.util.ArrayList;

public class Main {

  public static void main(String args[]) {

    int[] arr = new int[] {1, 2, 3, 4, 5};
    int k = 17;
    solutionTask2(arr);
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
}
