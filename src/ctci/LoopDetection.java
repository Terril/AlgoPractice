package ctci;

public class LoopDetection {
    public static void main(String args[]) {

        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(4);
        a.next.next.next.next = new Node(5);
        a.next.next.next.next.next = a.next.next;

        boolean is = isCircular(a);

        System.out.println(is);
    }

    static class Node {
        int d;
        Node next;

        Node(int v) {
            d = v;
            next = null;
        }
    }

    static boolean isCircular(Node n) {
        if (n == null) {
            return true;
        }

        Node slow = n;
        Node fast = n.next;

        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            } else if (slow == fast || fast.next == slow) {
                return true;
            }
            //for moving forward through linked list.
            else {
                slow = slow.next;
                //fast traverses way ahead so it distinguishes loops out of circular list.
                fast = fast.next.next;
            }
        }
    }
}
