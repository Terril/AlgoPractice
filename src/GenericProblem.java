import java.util.*;

import static java.lang.Math.abs;

public class GenericProblem {
    public static void main(String args[]) {
//        BST b = new BST(10);
//        b.left = new BST(5);
//        b.left.left = new BST(2);
//        b.left.left.left = new BST(1);
//        b.left.right = new BST(5);
//        b.right = new BST(15);
//        b.right.left = new BST(13);
//        b.right.right = new BST(22);
//        b.right.left.right = new BST(14);

//
//        BST b = new BST(100);
//        b.left = new BST(5);
//        b.left.left = new BST(2);
//        b.left.left.left = new BST(1);
//        b.left.right = new BST(5);
//        b.right = new BST(502);
//        b.right.left = new BST(204);
//        b.right.right = new BST(55000);
//        b.right.left.left = new BST(203);
//        b.right.left.right = new BST(205);
//        b.right.left.left.right = new BST(207);
//        b.right.left.left.right.left = new BST(206);
//        b.right.left.left.right.right = new BST(208);
//        b.right.right.left = new BST(1001);
//        b.right.right.left.right = new BST(4500);
//        System.out.println(findClosestValueInBst(b, 2000));

        //    System.out.println(getNthFib(6));

//        int[] c = {1, 6, 3, 1, 2, 5};
//        int v = 20;
//
//        int[] c1 = {1, 3, 2, 4, 1};
//        int v1 = 7;
//
//        int[] c2 = {10, 6, 8, 7, 7, 8};
//        int v2 = 5;
//
//        int[] c3 = {7, 3, 3, 6, 6, 6, 10, 5, 9, 2};
//        int v3 = 56;
//        System.out.println(maxIceCream(c, v));

//        List<Object> p = new ArrayList<>();
////        [5, 2, [7, -1],3, [6, [-13, 8],4]]
//        p.add(5);
//        p.add(2);
//        List<Object> q = new ArrayList<>();
//        q.add(7);
//        q.add(-1);
//        p.add(q);
//        p.add(3);
//        List<Object> r = new ArrayList<>();
//        r.add(6);
//        List<Object> s = new ArrayList<>();
//        s.add(-13);
//        s.add(8);
//        r.add(s);
//        r.add(4);
//        p.add(r);
//        System.out.println(productSum(p, 0));

//
//        int arr[] = {8, 5, 2, 9, 5, 6, 3};
//        int[] out = insertionSort(arr);
//
//        for (int i: out) {
//            System.out.println(i);
//        }

//        int key = 2;
//        String d = "xyz";
//
//        System.out.println(caesarCypherEncryptor(d, key));
//
//        String in = "........______=========AAAA   AAABBBB   BBB";
//        System.out.println(runLengthEncoding(in));

//        int[] a = {12, 3, 1, 2, -6, 5, -8, 6};
//        int t = 0;
//        int[] a1 = {1, 2, 3};
//        int t1 = 6;
//        List<Integer[]> o = threeNumberSum(a1, t1);
//
//        for (Integer[] c : o) {
//            for (Integer x : c) {
//                System.out.println(x);
//            }
//        }

//        int[] arrayOne = {10, 0, 20, 25};
//        int[] arrayTwo = {1005, 1006, 1014, 1032, 1031};
//
//        int x[] = smallestDifference(arrayOne, arrayTwo);
//
//        for (int y : x) {
//            System.out.println(y);
//        }
//        List<Integer> arr = new ArrayList<>();
//        arr.add(2);
//        arr.add(1);
//        arr.add(2);
//        arr.add(2);
//        arr.add(2);
//        arr.add(3);
//        arr.add(4);
//        arr.add(2);
//        int a = 2;
//
//        List<Integer> res = moveElementToEnd(arr, a);
//        for (Integer k :
//                res) {
//            System.out.println(k);
//        }
//
//        System.out.println(isUpperCase("J'ai besoin de pâtes"));

        int[] arr = {2, 5, 5, 5, 3, 8, 8};
        int[] res = solve(arr);

        for (int j:
             res) {
            System.out.println(j);

        }
    }

    private static PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    static int small = Integer.MIN_VALUE;
    static int diff = Integer.MAX_VALUE;

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        if (tree == null) {
            return -1;
        }

        if (diff > 0) {
            int currentDiff = tree.value - target;
            if (currentDiff < diff) {
                diff = currentDiff;
                small = tree.value;
            }
            if (!q.isEmpty()) {
                int val = q.peek();
                if (val <= tree.value) {
                    small = val;
                } else {
                    q.poll();
                    q.add(tree.value);
                }
            } else {
                q.add(tree.value);
            }
        } else {
            if (small < target) {
                small = tree.value;
            }
        }

        if (tree != null && tree.value <= target) {
            findClosestValueInBst(tree.right, target);
        } else {
            findClosestValueInBst(tree.left, target);
        }

        return small;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int getNthFib(int n) {
        // Write your code here.
        if (n <= 1) {
            return n;
        }
        return getNthFib(n - 1) + getNthFib(n - 2);
    }


    Set<Integer> ch = new HashSet<>();

    public boolean checkIfPangram(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            int c = (int) sentence.charAt(i);
            if (!ch.contains(c)) {
                ch.add(c);
            }
        }


        Arrays.sort(ch.toArray());

        for (int j = 97; j <= 122; j++) {
            if (!ch.contains(j)) {
                return false;
            }
        }
        return true;
    }


    public static int maxIceCream(int[] costs, int coins) {
        int[][] val = new int[costs.length][costs.length];

        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            int itemCost = costs[i];
            int count = coins > itemCost ? 1 : 0;
            for (int j = 0; j < costs.length; j++) {
                itemCost = itemCost + costs[j];
                if (val[i][j] == count) {

                } else if (itemCost <= coins) {
                    val[i][j] = count++;
                } else if (i > 0 && j > 0) {
                    val[i][j] = Math.max(val[i - 1][j - 1], count);
                } else {
                    val[i][j] = count;
                }
            }

        }

        return val[costs.length - 1][costs.length - 1];
    }

    static int finalSum = 0;
    static int depth = 1;

    public static int productSum(List<Object> array, int sum) {
        // Write your code here.
        for (int i = 0; i < array.size(); i++) {
            Object k = array.get(i);
            if (k instanceof ArrayList) {
                depth += 1;
                productSum((List<Object>) k, 0);
            } else {
                sum += (int) k;
            }
            finalSum = depth * sum;
        }
        return finalSum;
    }

    public static int[] insertionSort(int[] array) {
        // Write your code here.

        for (int i = 1; i < array.length; i++) {
            int u = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > u) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = u;
        }
        return array;
    }


    public static String caesarCypherEncryptor(String str, int key) {
        int size = str.length();
        String out = "";
        for (int i = 0; i < size; i++) {
            char x = str.charAt(i);
            int c = (int) str.charAt(i);
            c = ((c + key - 97) % 26 + 97);
            x = (char) c;
            out += x;

        }
        return out;
    }

    public static String runLengthEncoding(String string) {
        // Write your code here.
        int len = string.length();
        int count = 0;
        String out = "";
        char x = string.charAt(0);
        for (int i = 0; i < len; i++) {
            char y = string.charAt(i);
            if (count == 9) {
                out = out + count + x;
                count = 0;
                x = y;
            }
            if (x == y) {
                count += 1;
            } else {
                out = out + count + x;
                count = 1;
                x = y;
            }
        }

        return out + count + x;
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        int len = array.length;
        List<Integer[]> a = new ArrayList<Integer[]>();
        for (int j = 0; j < len; j++) {
            int left = j + 1;
            int right = len - 1;
            while (left < right) {
                int sum = array[j] + array[left] + array[right];
                if (sum == targetSum) {
                    a = threeNumberSumUtil(targetSum, array[j], array[left], array[right], a);
                    left++;
                    right--;
                } else if (sum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return a;
    }

    private static List<Integer[]> threeNumberSumUtil(int target, int one, int two, int three, List<Integer[]> a) {

        Integer[] x = new Integer[3];
        x[0] = one;
        x[1] = two;
        x[2] = three;
        a.add(x);

        return a;
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int[] out = new int[2];

        int len1 = arrayOne.length;
        int len2 = arrayTwo.length;

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int val = Integer.MAX_VALUE;
        int temp = Integer.MAX_VALUE;
//        for(int i = 0; i < len1; i++) {
//            int item1 = arrayOne[i];
//            int temp = Integer.MAX_VALUE ;
//            for (int j = 0; j < len2; j++) {
//                int item2 = arrayTwo[j];
//                int diff = Math.abs(item1) % Math.abs(item2);
//                if (temp != diff && temp >= diff) {
//                    val = temp;
//                    out[0] = item1;
//                    out[1] = item2;
//                }
//                temp = diff;
//
//            }
//        }


        int diff = Integer.MAX_VALUE;
        int val1 = 0;
        int val2 = 0;
        for (int i = 0; i < len1; i++) {
            int j = 0;
            int item1 = arrayOne[i];
            while (j < len2) {
                int item2 = arrayTwo[j];
                if (item1 > item2) {
                    diff = item1 - item2;
                } else if (item2 > item1) {
                    diff = item2 - item1;
                } else {
                    out[0] = item1;
                    out[1] = item2;
                }

                if (temp > diff) {
                    temp = diff;
                    val1 = item1;
                    val2 = item2;
                }
                j++;
            }
            if (val > temp) {
                val = temp;
                out[0] = val1;
                out[1] = val2;
            }

        }
        return out;
    }


    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int len = array.size() - 1;
        for (int i = 0; i <= len; i++) {
            int item = array.get(i);
            if (item == toMove) {
                while (len > i) {
                    int item1 = array.get(len);
                    if (item1 != item) {
                        int temp = item1;
                        item1 = item;
                        item = temp;
                        array.set(len, item1);
                        array.set(i, item);
                        break;
                    }
                    len--;
                }
            }
        }
        return array;
    }


    private static boolean isUpperCase(String s) {
        char c = s.charAt(0);

        if (Character.isUpperCase(c)) {
            return true;
        }

        return false;
    }

    public static int[] solve(int[] nums) {
        int len = nums.length;
        if(len < 3) {
            return new int[0];
        }

        int[] peaks = new int[len-2];

        int c = 1;
        int prev = nums[0];
        while(c < len-1) {
            int cur = nums[c];
            int nex = nums[c+1];
            if(cur >= prev && cur >= nex) {
                peaks[c-1] = c;
            }
            prev = cur;
            c++;
        }
        return peaks;
    }
}

