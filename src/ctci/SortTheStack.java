package ctci;

import java.util.Stack;

/*
* Sort the Stack and Reverse the stack
* */
public class SortTheStack {
    static Stack<Integer> st;
    public static void main(String args[]) {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // This is the temporary stack
       st = sortStack(input);
        System.out.println("Sorted numbers are:");
        System.out.print(st);
//        while (!tmpStack.empty()) {
//            System.out.print(tmpStack.peek() + " ");
//        }

        System.out.println();
        reversStack();

        System.out.println("Reversed Sorted numbers are:");
        System.out.print(st);

    }


    private static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> temp = new Stack<>();

        while (!input.isEmpty()) {
            int in = input.pop();
            while (!temp.isEmpty() && temp.peek() > in) {
                int i = temp.pop();
                input.push(i);
            }
            temp.push(in);
        }

        return temp;
    }

    private static void reversStack() {
        if (st.size() > 0) {
            int x = st.peek();
            st.pop();
            reversStack();

            insertItem(x);
        }

    }

    private static void insertItem(int x) {
        if (st.isEmpty()) {
            st.push(x);
        } else {
            int y = st.peek();
            st.pop();

            insertItem(x);
            st.push(y);
        }

    }
}
