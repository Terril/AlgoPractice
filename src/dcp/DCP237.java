package dcp;

/*
* This problem was asked by Amazon.
*
* A tree is symmetric if its data and shape remain unchanged when it is reflected about the root node.
* The following tree is an example:

        4
      / | \
    3   5   3
  /           \
9              9
* Given a k-ary tree, determine whether it is symmetric.
* */
public class DCP237 {
    public static void main(String args[]) {
        Node node = new Node(4);
        node.left = new Node(3);
        node.left.left = new Node(9);
        node.right = new Node(3);
        node.right.right = new Node(9);

        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.left.right = new Node(3);
        node1.right = new Node(2);
        node1.right.right = new Node(3);

        boolean is = isSymmetric(node1);
        if(is) {
            System.out.println("Is symmetric");
        } else {
            System.out.println("Not Symmetric");
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private static boolean isSymmetric(Node node) {
        return isMirror(node, node);
    }

    private static boolean isMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 != null && node2 != null && node1.data == node2.data)
            return (isMirror(node1.left, node2.right)
                    && isMirror(node1.right, node2.left));

        return false;
    }
}
