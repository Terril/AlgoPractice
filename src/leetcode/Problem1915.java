package leetcode;


import java.util.HashMap;

//Wonderful Substring
public class Problem1915 {
    public static void main(String args[]) {
        System.out.println(wonderfulSubstrings("aabb"));
    }

    public static long wonderfulSubstrings(String word) {

        long count = 0;

        int index = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);

//         while (index < word.length()) {
//             String formed = "";
//             HashSet<Character> set = new HashSet<>();
//             char a = word.charAt(index);
//             formed += a;
//             count += 1 ;
//             set.add(a);
//              for(int i = index + 1; i < word.length(); i++ ) {
//                 char b = word.charAt(i);
//                 if(a == b) {
//                   formed += b;
//                 }
//                 if((formed.length() % 2 == 1) && !set.contains(b)) {

//                 }
//                 else {
//                  count+=1;
//                 }

//                 set.add(b);
//              }

//             index++;
//         }

        for (char c : word.toCharArray()) {
            index = index ^ (1 << (c-'a'));
            count += map.getOrDefault(index, 0L);

            for(int i = 0 ; i < 10; i++) {
                index = index ^ (1 << i);
                count += map.getOrDefault(index, 0L);
                index = index ^ (1 << i);
            }

            map.put(index, map.getOrDefault(index, 0L) + 1);
        }

        return count;

    }
}
