public class GoogleIntersectingNode {

  public static void main(String args[]) {

    LinkedList list = new LinkedList();
    //    list.head = new LinkedList.Node(3);
    //    LinkedList.Node sec = new LinkedList.Node(7);
    //    LinkedList.Node thir = new LinkedList.Node(8);
    //    LinkedList.Node four = new LinkedList.Node(10);
    //
    //    list.head.next = sec;
    //    sec.next = thir;
    //    thir.next = four;
    //
    //    list.head2 = new LinkedList.Node(99);
    //    LinkedList.Node sec1 = new LinkedList.Node(1);
    //    LinkedList.Node thir1 = new LinkedList.Node(8);
    //    LinkedList.Node four1 = new LinkedList.Node(10);
    //
    //    list.head.next = sec1;
    //    sec1.next = thir1;
    //    thir1.next = four1;

    list.head = new LinkedList.Node(3);
    list.head.next = new LinkedList.Node(7);
    list.head.next.next = new LinkedList.Node(8);
    list.head.next.next.next = new LinkedList.Node(10);

    // creating second linked list
    list.head2 = new LinkedList.Node(99);
    list.head2.next = new LinkedList.Node(1);
    list.head2.next.next = new LinkedList.Node(8);
    list.head2.next.next.next = new LinkedList.Node(10);
    System.out.println("The node of intersection is " + list.getNode());
  }

  static class LinkedList {
    Node head, head2;

    static class Node {

      int data;
      Node next;

      Node(int d) {
        data = d;
        next = null;
      }
    }

    /*function to get the intersection point of two linked
    lists head1 and head2 */
    int getNode() {
      int c1 = getCount(head);
      int c2 = getCount(head2);
      int d;

      if (c1 > c2) {
        d = c1 - c2;
        return _getIntesectionNode(d, head, head2);
      } else {
        d = c2 - c1;
        return _getIntesectionNode(d, head2, head);
      }
    }

    /* function to get the intersection point of two linked
    lists head1 and head2 where head1 has d more nodes than
    head2 */
    int _getIntesectionNode(int d, Node node1, Node node2) {
      int i;
      Node current1 = node1;
      Node current2 = node2;
      for (i = 0; i < d; i++) {
        if (current1 == null) {
          return -1;
        }
        current1 = current1.next;
      }
      while (current1 != null && current2 != null) {
        if (current1.data == current2.data) {
          return current1.data;
        }
        current1 = current1.next;
        current2 = current2.next;
      }

      return -1;
    }

    /*Takes head pointer of the linked list and
    returns the count of nodes in the list */
    int getCount(Node node) {
      Node current = node;
      int count = 0;

      while (current != null) {
        count++;
        current = current.next;
      }

      return count;
    }
  }
}
