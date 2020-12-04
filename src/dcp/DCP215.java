package dcp;

import java.util.*;

public class DCP215 {
    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        root.left.left.left = new Node(0);
        root.right.right.left = new Node(8);
        TreeNode tree = new TreeNode(root);
        tree.findBottomView();
    }

    static class Node {
        int data;
        int hd;
        Node left, right;

        Node(int data) {
            this.data = data;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    static class TreeNode {
        Node root;

        TreeNode(Node node) {
            root = node;
        }

        void findBottomView() {
            if (root == null) {
                return;
            }

            int hd = 0;
            Queue<Node> queue = new LinkedList<>();
            Map<Integer, Integer> map = new TreeMap<>();

            root.hd = hd;
            queue.add(root);

            while (!queue.isEmpty()) {

                Node temp = queue.remove();
                hd = temp.hd;

                map.put(hd, temp.data);

                if (temp.left != null) {
                    temp.left.hd = hd - 1;
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    temp.right.hd = hd + 1;
                    queue.add(temp.right);
                }
            }

            Set<Map.Entry<Integer, Integer>> set = map.entrySet();
            Iterator iterator = set.iterator();

            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> out = (Map.Entry<Integer, Integer>) iterator.next();
                System.out.println(out.getValue());
            }

        }
    }
}
