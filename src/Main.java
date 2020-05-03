import java.util.*;

public class Main {

    public static void main(String args[]) {

        int[] arr = new int[]{2, 3, -7, 6, 8, 1, -10, 15};
        int k = 17;
        // solutionTask2(arr);
//        int count = findMissingNumber(arr);//frogRecursionProblem(11);
//        System.out.println(count);
        int sum = 84;
        int[] arr1 = new int[]{2, -5, -8, -11, -13, 14, 15, -19, -21, 22, -23, 24, -25, -26, 27, 29, 30, 34, 35, -36, 37, -40, -42, 43, 45, 46, -49, -50, -56, -57, 58, 59, 62, -63, -64, -67, 68, -69, 70, -72, -73, -76, -77, 78, -80, 81, 82, -84, 86, -87, 88, -90, 91, 92, -93, 95, 96, 98};
        int[] arr2 = new int[]{0, -1, -2, 3, -6, 8, -9, 12, -15, -17, -18, 19, -21, 23, -24, 26, -27, 28, 29, -31, 32, -34, 39, 40, 41, 44, 45, -46, -49, 50, -51, 52, 53, 54, 55, -56, 60, 64, 65, 67, -68, -70, 71, 75, 76, -78, -79, -80, 81, -83, 86, 88, 89, -92, 93, 94, -95, -96, -97, 99};

        //int sum = 9;
        //   int arr1[] = new int[]{1, 2, 4, 5, 7};
        // int arr2[] = new int[]{5, 6, 3, 4, 8};
        //subArraySum(arr1, arr1.length, sum);
        //numItems(sum, arr1);
        // pairsOfSum(arr1, arr2, sum);
        //  closestSumPair(arr1, arr2, sum);


       // String data = "1221235";
        //   int result = characterDecode(data, data.length());
     //   rearrangedString("asd");
        //  System.out.println(result);

        int val = findFibnacci(9);
       // System.out.println(val);
       boolean va =  isFibonacci(13);
        System.out.println(va);
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
                items[arr[i]] = true;
            }
        }
        for (int j = 1; j <= arr.length; j++) {
            if (!items[j]) {
                return j;
            }
        }

        return arr.length + 1;
    }


    static void numItems(int sum, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sumPos = arr[i];
            for (int j = i + 1; j < arr.length; j++) {

                sumPos += arr[j];
                if (sumPos == sum) {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }

    static void subArraySum(int arr[], int n, int sum) {
        int curr_sum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum) {
                int p = i - 1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
                break;
            } else if (i > n - 1) {
                System.out.println("-1");
                break;
            }

            // Add this element to curr_sum
            if (i < n)
                curr_sum = curr_sum + arr[i];

        }
//        if (curr_sum < sum) {
//            System.out.println("-1");
//        }
    }

    static void pairsOfSum(int[] arr1, int[] arr2, int sum) {

        Set set = new HashSet();
        Set set1 = new HashSet();
        String pairedString = "";
        for (int item : arr2) {
            set.add(item);
        }

        for (int item : arr1) {
            set1.add(item);
        }
        StringBuilder builder = new StringBuilder();
        Iterator<Integer> it = set1.iterator();
        int k = 0;
        Hashtable<Integer, Integer> pair = new Hashtable();
        while (it.hasNext()) {
            int value = it.next();
            int sumPos = (sum) - value;
            if (set.contains(sumPos)) {
                // pairedString = value + " " + sumPos + ", ";
                pair.put(k, value);
                pair.put(k + 1, value);
                k += 2;
                //builder.append(pairedString).append(", ");
            }

        }

        for (int i : pair.values()) {
            System.out.print(i);
        }
//        if (pairedString.isEmpty()) {
//            System.out.println("-1");
//        } else {
        // builder.deleteCharAt(builder.toString().trim().length() - 1);
        //System.out.println(builder.toString());
//            System.out.println(pairedString);
//            pairedString = "";
//        }
    }


    public static void closestSumPair(int[] a1, int[] a2, int target) {
        int[] a1Sorted = Arrays.copyOf(a1, a1.length);
        Arrays.sort(a1Sorted);
        int[] a2Sorted = Arrays.copyOf(a2, a2.length);
        Arrays.sort(a2Sorted);

        int i = 0;
        int j = a2Sorted.length - 1;
        int smallestDiff = Math.abs(a1Sorted[0] + a2Sorted[0] - target);
        int[] closestPair = {a1Sorted[0], a2Sorted[0]};

        while (i < a1Sorted.length && j >= 0) {
            int v1 = a1Sorted[i];
            int v2 = a2Sorted[j];
            int currentDiff = v1 + v2 - target;
//            if (Math.abs(currentDiff) < smallestDiff) {
//                smallestDiff = Math.abs(currentDiff);
//                closestPair[0] = v1; closestPair[1] = v2;
//            }

            if (currentDiff == 0) {
                System.out.println("The pair is : ("
                        + v1 + ", " + v2 + ")");
                break;
            } else if (currentDiff < 0) {
                i += 1;
            } else {
                j -= 1;
            }
        }

        System.out.println("-1");
    }

    static int characterDecode(String data, int k) {

        if (data == null) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }
        int s = data.length() - k;
        char initial = data.charAt(s);
        if (initial == '0') {
            return 0;
        }
        int result = characterDecode(data, k - 1);
        if (!(s == data.length() - 1)) {
            char second = data.charAt(s + 1);
            String newType = initial + "" + second;
            if (k >= 2 && (Integer.parseInt(newType) <= 26)) {
                result = result + characterDecode(data, k - 2);
            }
        }
        return result;
    }

    static String rearrangedString(String content) {
        content = "DORWBL4A16H1"; //"AC2BEW3";

        int[] alpha = new int[26];
        int sum = 0;
        for (char c :
                content.toCharArray()) {
            int j = (int) c;
            if (j >= 65 && j <= 90) {
                alpha[j - 65]++;
            } else {
                sum = sum + (j - 48);
            }
        }

        //  Collections.sort(alpha);
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= alpha[i]; j++)
                System.out.print((char) (i + 65));
        }
        // System.out.println(alpha.toString() );
        System.out.print(sum);

        Scanner sc = new Scanner(System.in);
        return content;
    }

    private static int[] runningMedian(int[] a) {
        int length = a.length;
        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return -1 * integer.compareTo(t1);
            }
        }); // Max Heap
        PriorityQueue<Integer> highers = new PriorityQueue<>(); // Min Heap
        int[] medians = new int[length];
        for (int i = 0; i < length; i++) {
            int number = a[i];
            addNumbers(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }

    private static void addNumbers(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.isEmpty() || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static int getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() == smallerHeap.size()) {
            return (biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }


    static int findFibnacci(int n) {

        int[] ns = new int[n + 1];

        ns[0] = 0;
        ns[1] = 1;

        for (int i = 2; i <= n; i++) {
            ns[i] = ns[i - 1] + ns[i - 2];
        }

        return ns[n];
    }

    static  boolean isPerfectSquare(int x)
    {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }

    // Returns true if n is a Fibonacci Number, else false
    static boolean isFibonacci(int n)
    {
        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both
        // is a perfect square
        return isPerfectSquare(5*n*n + 4) ||
                isPerfectSquare(5*n*n - 4);
    }
}


//else if (sumPos > sum) {
//        break;
//        } else {
//        continue;
//        }


