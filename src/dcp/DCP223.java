package dcp;

/*
 * This problem was asked by Palantir.
 *
 * Typically, an implementation of in-order traversal of a binary tree has O(h) space complexity,
 * where h is the height of the tree.
 *
 * Write a program to compute the in-order traversal of a binary tree using O(1) space.
 * */
public class DCP223 {
    TreeNode root;

    public static void main(String args[]) {
        DCP223 tree = new DCP223();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left
                = new TreeNode(4);
        tree.root.left.right
                = new TreeNode(5);
        tree.root.right.left
                = new TreeNode(6);
        tree.root.right.right
                = new TreeNode(7);
        tree.root.left.right.left
                = new TreeNode(8);
        tree.root.left.right.right
                = new TreeNode(9);

        inOrderTraversal(tree.root);
    }

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + " ";
        }
    }

    private static void inOrderTraversal(TreeNode node) {
        if (node == null)
            return;

        TreeNode current = null;
        TreeNode prevNode = null;
        TreeNode pre = null;
        TreeNode ptr = null;
        TreeNode netChild = null;
        TreeNode prevPtr = null;

        current = node;
        while (current != null) {
            if (current.left == null) {
                current.left = prevNode;
                // Set prevNode to current
                prevNode = current;
                current = current.right;
            } else {
                pre = current.left;
                // Find the right most child
                // in the left subtree
                while (pre.right != null
                        && pre.right != current)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    // Set the right most
                    // child's right pointer
                    // to NULL
                    pre.right = null;


                    ptr = pre;
                    netChild = pre;
                    prevPtr = pre;
                    while (ptr != null) {
                        if (ptr.right == netChild) {
                            System.out.print(ptr);
                            netChild = ptr;
                            prevPtr.left = null;
                        }

                        if (ptr == current.left)
                            break;
                        // Break the loop
                        // all the left subtree
                        // nodes of current
                        // processed

                        prevPtr = ptr;
                        ptr = ptr.left;
                    }
                    System.out.print(pre);
                    prevNode = current;
                    current = current.right;
                }
            }
        }

        System.out.print(prevNode);

        // Last path traversal
        // that includes the root.
        ptr = prevNode;
        netChild = prevNode;
        prevPtr = prevNode;
        while (ptr != null) {
            if (ptr.right == netChild) {
                System.out.print(ptr);
                netChild = ptr;
                prevPtr.left = null;
            }
            if (ptr == node)
                break;

            prevPtr = ptr;
            ptr = ptr.left;
        }
    }
}
