package ctci;

public class SumTheLinkList {
    public static void main(String args[]) {

        SumTheLinkList list = new SumTheLinkList();

        // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);

        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        System.out.print("Second List is ");
        list.printList(head2);

        Node rs = list.findTheSum(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }

    static Node head1, head2;

    static class Node {
        Node next;
        int v;

        Node(int val) {
            v = val;
            next = null;
        }
    }

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.v + " ");
            head = head.next;
        }
        System.out.println("");
    }


    static Node findTheSum(Node a, Node b) {

        int carry = 0;
        int sum;
        Node res = null;
        Node tem = null;
        Node prev = null;
        while (a != null || b != null) {
            sum = carry + ((a != null) ? a.v : 0) + ((b != null) ? b.v : 0);
            carry = sum >= 10 ? 1 : 0;

            sum = sum % 10;

            tem = new Node(sum);

            if (res == null) {
                res = tem;
            } else {
                prev.next = tem;
            }

            prev = tem;

            if (a != null) {
                a = a.next;
            }

            if (b != null) {
                b = b.next;
            }

            if (carry > 0) {
                tem.next = new Node(carry);
            }

        }

        return res;

    }
}
