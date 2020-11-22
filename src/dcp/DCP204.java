package dcp;

public class DCP204 {
    public static void main(String args[]) {
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int countNodes(TreeNode node) {

        int height = getHeight(node);
        int total = (int) Math.pow(2, height) - 1;

        //get num missed
        int[] miss = new int[1];
        helper(node, 0, height, miss);

        return total - miss[0];
    }

    private static int getHeight(TreeNode node) {
        TreeNode p = node;
        int h = 0;
        while (p != null) {
            h++;
            p = p.left;
        }
        return h;
    }

    private static boolean helper(TreeNode node, int level, int height, int[] miss) {
        if (node != null) {
            level++;
        } else {
            return true;
        }

        if (level >= height) {
            return false;
        }
        if (level == height - 1) {
            if (node.right == null) {
                miss[0]++;
            }

            if (node.left == null) {
                miss[0]++;
            }

            if (node.left != null) {
                return false;
            }
        }

        boolean retR = helper(node.right, level, height, miss);
        if (retR) {
            boolean retL = helper(node.left, level, height, miss);
            return retL;
        }

        return true;
    }
}
