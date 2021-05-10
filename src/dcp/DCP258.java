package dcp;

import java.util.Stack;

/*
*
* This problem was asked by Morgan Stanley.
*
* In Ancient Greece, it was common to write text with the first line going left to right,
* the second line going right to left, and continuing to go back and forth.
* This style was called "boustrophedon".
*
* Given a binary tree, write an algorithm to print the nodes in boustrophedon order.

For example, given the following tree:

       1
    /     \
  2         3
 / \       / \
4   5     6   7
*
* You should return [1, 3, 2, 4, 5, 6, 7].
* */
public class DCP258 {
    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        //val.add(node.val);
      //  printSpiral(node);
        getBoustrophedonOrderFromATreeSolution2(node);

//        for (int x : val
//        ) {
//            System.out.println(x);
//        }
    }


    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int value) {
            val = value;
            left = null;
            right = null;
        }
    }


    static void getBoustrophedonOrderFromATree(TreeNode node, int level, boolean ltr) {
//        if (node.left == null && node.right == null) {
//            return;
//        }
//
//        if (node.right != null) {
//            val.add(node.right.val);
//            getBoustrophedonOrderFromATree(node.left, i, ltr);
//        }
//        if (node.left != null) {
//            val.add(node.left.val);
//            getBoustrophedonOrderFromATree(node.right, i, ltr);
//        }

        if (node == null)
            return;
        if (level == 1)
            System.out.println(node.val);
        else if (level > 1) {
            if (ltr) {
                getBoustrophedonOrderFromATree(node.right, level - 1, ltr);
                getBoustrophedonOrderFromATree(node.left, level - 1, ltr);
            } else {
                getBoustrophedonOrderFromATree(node.left, level - 1, ltr);
                getBoustrophedonOrderFromATree(node.right, level - 1, ltr);
            }
        }
    }

    static int height(TreeNode node) {
        if (node == null)
            return 0;
        else {
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else return (rheight + 1);
        }
    }

    static void printSpiral(TreeNode root) {
        int h = height(root);
        int i;

	/*ltr -> Left to Right. If this variable is set,
	then the given level is traverseed from left to right. */
        boolean ltr = false;
        for (i = 1; i <= h; i++) {
            getBoustrophedonOrderFromATree(root, i, ltr);

            /*Revert ltr to traverse next level in opposite order*/
            ltr = !ltr;
        }
    }

    /*
     * Solution 2
     * */

    private static void getBoustrophedonOrderFromATreeSolution2(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> curNode = new Stack<>();
        Stack<TreeNode> nexNode = new Stack<>();

        curNode.push(node);

        boolean leftRight = true;
        while (!curNode.isEmpty()) {

            TreeNode cNode = curNode.pop();
            System.out.println(cNode.val);
            if (leftRight) {

                if (cNode.left != null) {
                    nexNode.push(cNode.left);
                }

                if (cNode.right != null) {
                    nexNode.push(cNode.right);
                }
            } else {
                if (cNode.right != null) {
                    nexNode.push(cNode.right);
                }

                if (cNode.left != null) {
                    nexNode.push(cNode.left);
                }
            }

            if (curNode.isEmpty()) {
                leftRight = !leftRight;
                Stack<TreeNode> temp = curNode;
                curNode = nexNode;
                nexNode = temp;
            }
        }
    }
}
