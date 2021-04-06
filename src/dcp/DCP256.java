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
//        Node n = new Node(1, null);
//        n.next = new Node(2, n);
//        n.next.next = new Node(3);
//        n.next.next.next = new Node(4);
//        n.next.next.next.next = new Node(5);
        //  rearrangeList(n);
        int[] keys = {1, 2, 3, 4, 5, 6, 7, 8};

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head = rearrange(head);
          printList(head);
        //printlist(head);
    }

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

//    static void rearrangeList(Node n) {
//
//        Node temp = null;
//        Node move = n.next;
//        Stack visited = new Stack<Boolean>();
//
//        Node curr = n;
//        while (n.next != null) {
//            if (!visited.empty() && visited.peek().equals(true)) {
//                if (n.next.val > n.val) {
//                    // swap(n, temp);
//
////                if (curr.next.val > curr.val) {
////                    temp = curr;
////                    curr = curr.next;
////                    curr.next = temp;
////                    visited.pop();
//                } else {
//                    visited.push(true);
//                }
//            } else {
//                visited.push(true);
//            }
//            //  curr = move;
//            n = n.next.next;
//        }
//    }

    public static Node rearrange(Node head) {
        // empty list
        if (head == null) {
            return null;
        }

        Node prev = head;
        Node curr = head.next;

        // start from the second node
        while (curr != null) {
            // if the previous node is greater than the current node,
            // swap their values
            if (prev.data > curr.data) {
                int temp = prev.data;
                prev.data = curr.data;
                curr.data = temp;
            }

            // if the next node is greater than the current node,
            // swap their values
            if (curr.next != null && curr.next.data > curr.data) {
                int temp = curr.next.data;
                curr.next.data = curr.data;
                curr.data = temp;
            }

            // update `prev` and `curr` node
            prev = curr.next;

            if (curr.next == null) {
                break;
            }

            curr = curr.next.next;
        }

        return head;
    }

//    private static void swap(Node node, Node temp) {
//        temp = node;
//        node = node.next;
//        node.next = temp;
//    }

    //    private static void printlist(Node node) {
//        if (node == null) {
//            return;
//        }
//        while (node != null) {
//            System.out.print(node.data + " -> ");
//            node = node.next;
//        }
//    }
    public static void printList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }


}
