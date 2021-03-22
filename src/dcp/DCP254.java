package dcp;

/*
* This problem was asked by Yahoo.
*
* Recall that a full binary tree is one in which each node is either a leaf node,
* or has two children. Given a binary tree, convert it to a full one by removing nodes with only one child.

For example, given the following tree:

         0
      /     \
    1         2
  /            \
3                 4
  \             /   \
    5          6     7
You should convert it to:

     0
  /     \
5         4
        /   \
       6     7

*
* */
public class DCP254 {
    public static void main(String args[]) {

        Node node = new Node(0);
        node.left = new Node(1);
        node.left.left = new Node(3);
        node.left.left.right = new Node(5);

        node.right = new Node(2);
        node.right.right = new Node(4);
        node.right.right.left = new Node(6);
        node.right.right.right = new Node(7);

        createFullBinarytree(node);
    }

    private static void createFullBinarytree(Node node) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.right != null) {
            System.out.print(node.val + " ");
        } else if (node.left == null && node.right == null) {
            System.out.print(node.val + " ");
        }

        createFullBinarytree(node.left);

        /* now recur on right child */
        createFullBinarytree(node.right);

    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }
}
