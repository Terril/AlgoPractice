package dcp;

/*
 * This problem was asked by PayPal.
 *
 * Given a binary tree, determine whether or not it is height-balanced.
 * A height-balanced binary tree can be defined as one in which the heights of the two
 * subtrees of any node never differ by more than one.
 * */
public class DCP247 {
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(15);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);
        tree.root.right.left = new Node(3);

        if (tree.isHeightBalancedtree(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");

    }

    static class Node {
        Node left, right;
        int value;

        Node(int val) {
            value = val;
            left = null;
            right = null;
        }
    }

    static class BinaryTree {
        Node root;

        boolean isHeightBalancedtree(Node node) {
            int lh, rh;
            if (node == null)
                return true;

            lh = height(node.left);
            rh = height(node.right);
            if (Math.abs(lh - rh) <= 1
                    && isHeightBalancedtree(node.left)
                    && isHeightBalancedtree(node.right))
                return true;

            return false;
        }

        int height(Node node) {
            /* base case tree is empty */
            if (node == null)
                return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
}
