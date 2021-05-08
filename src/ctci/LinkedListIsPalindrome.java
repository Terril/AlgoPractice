package ctci;

import java.util.Stack;

public class LinkedListIsPalindrome {
    public static void main(String args[]) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        Node eight = new Node(4);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;

        boolean is = isPalindrome(one);
        System.out.println(is);
    }

    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    static boolean isPalindrome(Node node) {

        Node slow = node;
        boolean ispalin = true;
        Stack<Integer> n = new Stack<>();

        while (slow != null) {
            n.push(slow.data);
            slow = slow.next;
        }

        while (node != null) {
            int v = n.pop();

            if (node.data == v) {
                ispalin =  true;
            } else {
                ispalin = false;
                break;
            }
            node = node.next;
        }

        return ispalin;
    }
}
