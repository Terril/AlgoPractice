package algoexpert;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String args[]) {
        int [] res = nextGreaterElement(new int[] {2, 5, -3, -4, 6, 7, 2});
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] nextGreaterElement(int[] array) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        int[] out = new int[array.length];
        Arrays.fill(out, -1);
        for(int i = 0 ; i < 2 * array.length; i++) {
            int index = i % array.length;

            while(!stack.isEmpty() && array[stack.peek()] < array[index]) {
                int top = stack.pop();
                out[top] = array[index];
            }

            stack.push(index);

        }
        return out;
    }

}
