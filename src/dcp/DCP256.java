package dcp;

import java.util.Stack;

/*
 * This problem was asked by Fitbit.
 *
 * Given a linked list,
 * rearrange the node values such that they appear in alternating low -> high -> low -> high ... form.
 * For example, given 1 -> 2 -> 3 -> 4 -> 5, you should return 1 -> 3 -> 2 -> 5 -> 4.
 *
 * */
public class DCP256 {
    public static void main(String args[]) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(5);
        rearrangeList(n);
        printlist(n);
    }

    static class Node {
        int val;
        Node next;

        Node(int value) {
            val = value;
            next = null;
        }
    }

    static void rearrangeList(Node n) {

        Node temp = null;
        Node move = n.next;
        Stack visited = new Stack<Boolean>();

        Node curr = n;
        while (curr.next != null) {
            if (!visited.empty() && visited.peek().equals(true)) {
                if (curr.next.val > curr.val) {
                    temp = curr;
                    curr = curr.next;
                    curr.next = temp;
                    visited.pop();
                } else {
                    visited.push(true);
                }
            } else {
                visited.push(true);
            }
            curr = curr.next;
        }
    }

    static void printlist(Node node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

}
