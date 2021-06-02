package ctci;

import java.util.Random;

public class RandomNode {
    public static void main(String args[]) {
        Tree tree = new Tree();
        tree.insertNode(20);
        tree.insertNode(10);
        tree.insertNode(30);
        tree.insertNode(35);
        tree.insertNode(15);
        tree.insertNode(17);
        tree.insertNode(5);
        tree.insertNode(3);
        tree.insertNode(7);


        System.out.println(tree.getRandomNode().getData());

    }

    static class Tree {
        TreeNode node;

        public int size() {
            return node == null ? 0 : node.getSize();
        }

        public TreeNode getRandomNode() {
            if (node == null) return null;

            Random random = new Random();
            int index = random.nextInt(size());

            return node.getIndexNode(index);
        }

        public void insertNode(int data) {
            if (node == null) {
                node = new TreeNode(data);
            } else {
                node.insertNodeData(data);
            }
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        int size = 0;

        TreeNode(int d) {
            data = d;
            size = 1;
        }

        public void insertNodeData(int d) {
            if (d <= data) {
                if (left == null) {
                    left = new TreeNode(d);
                } else {
                    left.insertNodeData(d);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(d);
                } else {
                    right.insertNodeData(d);
                }
            }

            size++;
        }

        public int getSize() {
            return size;
        }

        public int getData() {
            return data;
        }

        public TreeNode getIndexNode(int index) {
            int leftSize = left == null ? 0 : left.getSize();

            if (index < leftSize) {
                return left.getIndexNode(index);
            } else if (index == leftSize) {
                return this;
            } else {
                return right.getIndexNode(index - (leftSize + 1));
            }
        }

        public TreeNode find(int d) {
            if (d < data) {
                return left != null ? left.find(d) : null;
            } else if (d == data) {
                return this;
            } else if (d > data) {
                return right != null ? right.find(d) : null;
            }

            return null;
        }
    }
}
