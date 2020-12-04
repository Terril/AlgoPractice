package dcp;

import java.util.*;

/*
* This problem was asked by Yelp.
* The horizontal distance of a binary tree node describes how far left or right the node will be when the tree is printed out.
*
* More rigorously, we can define it as follows:
*
* The horizontal distance of the root is 0.
* The horizontal distance of a left child is hd(parent) - 1.
* The horizontal distance of a right child is hd(parent) + 1.
* For example, for the following tree, hd(1) = -2, and hd(6) = 0.

             5
          /     \
        3         7
      /  \      /   \
    1     4    6     9
   /                /
  0                8
* The bottom view of a tree, then, consists of the lowest node at each horizontal distance.
* If there are two nodes at the same depth and horizontal distance, either is acceptable.
*
* For this tree, for example, the bottom view could be [0, 1, 3, 6, 8, 9].
* Given the root to a binary tree, return its bottom view.
* */
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
