package dcp;

/*
*
* This problem was asked by LinkedIn.
* Given a linked list of numbers and a pivot k,
* partition the linked list so that all nodes less than k come before nodes greater than or equal to k.
* For example, given the linked list 5 -> 1 -> 8 -> 0 -> 3 and k = 3,
*  the solution could be 1 -> 0 -> 5 -> 8 -> 3.
* */
public class DCP208 {
    public static void main(String args[]) {
        Node head = newNode(5);
        head.next = newNode(1);
        head.next.next = newNode(8);
        head.next.next.next = newNode(0);
        head.next.next.next.next = newNode(3);

        int x = 3;
        head = partition(head, x);
        printList(head);
    }

    static class Node {
        int data;
        Node next;
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        return node;
    }

    static Node partition(Node head, int pivot) {

        Node smallHead = null;
        Node largeHead = null;
        Node largeLast = null;
        Node smallLast = null;
        while (head != null) {
            // If current node is equal to x, append it
            // to the list of x values
            if (head.data >= pivot) {
                if (largeHead == null)
                    largeLast = largeHead = head;
                else {
                    largeLast.next = head;
                    largeLast = head;
                }
            } else {
                if (smallHead == null)
                    smallLast = smallHead = head;
                else {
                    smallLast.next = head;
                    smallLast = head;
                }
            }
            head = head.next;
        }

        if(largeLast != null) {
            largeLast.next = null;
        }

//        if (smallHead == null)
//        {
//            if (largeLast == null)
//                return largeHead;
//            smallLast.next = largeHead;
//            return smallHead;
//        }
        smallLast.next = largeHead;
        return smallHead;
    }

    private static void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
