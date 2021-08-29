package leetcode;

import java.util.stream.IntStream;

public class Problem5856 {
    public static void main(String args[]) {
        int[] in = {9, 6, 9};
        System.out.println(minSessions(in, 14));
    }

    public static int minSessions(int[] tasks, int sessionTime) {

        if(tasks.length == 0 || sessionTime == 0) {
            return 0;
        }


        int count = 0;
        int cal = 0;
//         while(count < tasks.length) {
//             int session = tasks[count];
//             cal+=session;
//             if(cal == sessionTime) {
//                 minSession+=1;
//             } else if(session == sessionTime) {
//                 minSession+=1;
//             }

//             count++;
//         }

//         if(minSession == 0) {
//             return 1;
//         }

        int sum = IntStream.of(tasks).sum();

        double minSession = Math.ceil((double) sum / sessionTime);

        return (int) minSession;

    }
}
