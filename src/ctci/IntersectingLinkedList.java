package ctci;

public class IntersectingLinkedList {
    public static void main(String args[]) {

        IntersectingLinkedList list = new IntersectingLinkedList();
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);

        list.head2 = new Node(8);
        list.head2.next = new Node(9);
        System.out.print("Second List is ");
        list.printList(head2);

        boolean is = list.isTheListIntersecting(head1, head2);
        System.out.println(is);
    }

    static Node head1, head2;

    static class Node {
        int d;
        Node next;

        Node(int v) {
            d = v;
            next = null;
        }
    }

    static void printList(Node n) {
        while (n != null) {
            System.out.println(n.d);
            n = n.next;
        }
    }

    boolean isTheListIntersecting(Node h1, Node h2) {

        boolean isIntersecting = false;
        Node h2I = h2;
        while (h1 != null) {
            while (h2I != null) {
                if (h1.d == h2I.d) {
                    isIntersecting = true;
                    break;
                }
                h2I = h2I.next;
            }
            h2I = h2;
            h1 = h1.next;
        }

        return isIntersecting;
    }
}
