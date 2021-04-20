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

        List<Object> p = new ArrayList<>();
//        [5, 2, [7, -1],3, [6, [-13, 8],4]]
        p.add(5);
        p.add(2);
        List<Object> q = new ArrayList<>();
        q.add(7);
        q.add(-1);
        p.add(q);
        p.add(3);
        List<Object> r = new ArrayList<>();
        r.add(6);
        List<Object> s = new ArrayList<>();
        s.add(-13);
        s.add(8);
        r.add(s);
        r.add(4);
        p.add(r);
        System.out.println(productSum(p, 0));
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

}

