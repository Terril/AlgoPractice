import java.util.Stack;

public class TwitterEcommerceLastElement {

    public static void main(String args[]) {

        LogDataStructure dataStructure = new LogDataStructure(4);
        dataStructure.record(3);
        dataStructure.record(1);
        dataStructure.record(4);
        System.out.println(dataStructure.getLast(3));
    }

    static class LogDataStructure {
        private int maxSize;
        private int[] circularBuffer;
        private int currIdx;

        LogDataStructure(int n) {
            this.maxSize = n;
            this.circularBuffer = new int[n];
            this.currIdx = 0;
        }

        void record(int orderId) {
            circularBuffer[currIdx] = orderId;
            currIdx = (currIdx + 1) % maxSize;
        }

        int getLast(int i) {
            return circularBuffer[(currIdx - i + maxSize) % maxSize];
        }
    }

}
