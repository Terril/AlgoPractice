import java.util.*;
import java.util.stream.Collectors;

public class StringCompress {
    public static void main(String args[]) {
//        String input = "AAABBBBCC";
//
//        int count = 1;
//
//        char last = input.charAt(0);
//
//        StringBuilder output = new StringBuilder();
//
//        for(int i = 1; i < input.length(); i++){
//            if(input.charAt(i) == last){
//                count++;
//            }else{
//                if(count > 1){
//                    output.append(""+count+last);
//                }else{
//                    output.append(last);
//                }
//                count = 1;
//                last = input.charAt(i);
//            }
//        }
//        if(count > 1){
//            output.append(""+count+last);
//        }else{
//            output.append(last);
//        }
//        System.out.println(output.toString());

        String mess = "MLMMMLMMMM"; //"ABBBCCDDCCC";
//        String newM = remove_k_characters("MLMMMLMMMM", mess.length(), 2);
//        System.out.println(newM);

        // compressedString(mess, 2);
        subString("aa aa odg dog gdo");
        //sherlockAndAnagrams("aa aa odg dog gdo");
    }

    static class Entity {
        char character;
        int frequency;

        Entity(char p, int q) {
            character = p;
            frequency = q;
        }
    }

    static String remove_k_characters(String st1, int n, int k) {

        // Stack to store the character
        Stack<Entity> st = new Stack<Entity>();

        int i = 0;
        for (i = 0; i < n; i++) {

            // the current character
            char x = st1.charAt(i);

            // if the stack is not empty
            // and the frequency of the element
            // at the top of the stack is = k
            // then pop k elements
            if (st.size() > 0 && st.peek().frequency == k) {

                // stores the character at
                // the top of the stack
                char curr = st.peek().character;

                // while the the character
                // at the top of the stack is curr
                // pop the character from the stack
                while (st.size() > 0 && st.peek().character == curr)
                    st.pop();
            }

            // if the stack is not empty
            // and the top element of the
            // stack is = x,
            if (st.size() > 0 && st.peek().character == x) {

                // increase it's frequency and
                // push it to the stack
                Entity new_top = new Entity(x, st.peek().frequency + 1);
                st.push(new_top);
            }

            // if the current element is
            // not equal to the character
            // at the top of the stack
            else {
                Entity new_top = new Entity(x, 1);
                st.push(new_top);
            }
        }

        // if the last pushed character
        // has k frequency, then pop the
        // top k characters.
        if (st.size() > 0 && st.peek().frequency == k) {

            // get the character
            // at the top of the stack
            char curr = st.peek().character;

            // while the the character
            // at the top of the stack is
            // curr, pop it from the stack
            while (st.size() > 0 && st.peek().character == curr)
                st.pop();
        }

        // Stores the string in
        // reversed fashion from stack
        String stack_string = "";
        while (st.size() > 0)
            stack_string += st.pop().character;

        String reduced_string = "";

        // reverse the stack string
        for (i = stack_string.length() - 1; i >= 0; i--)
            reduced_string += stack_string.charAt(i);

        return stack_string;
    }

    static void compressedString(String x, int k) {

        HashMap<Character, Integer> mappedData = new HashMap<>();
        for (int i = 0; i < x.length(); i++) {
            int count = 1;
            char y = x.charAt(i);
            if (mappedData.containsKey(y)) {
                count = mappedData.get(y);
                count++;
                mappedData.put(y, count);
            } else {
                mappedData.put(y, count);
            }
        }

//        mappedData.forEach((key, value) -> {
//            System.out.print(value + "" + key);
//        });
    }

    static void subString(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] valC = s.substring(i, j + 1).toCharArray();
                Arrays.sort(valC);
                String val = new String(valC);
                if (map.containsKey(val))
                    map.put(val, map.get(val) + 1);
                else
                    map.put(val, 1);
            }
        }
        int anagramPairCount = 0;
        int n = 0;
        for (String key : map.keySet()) {
            n = map.get(key);
            anagramPairCount += (n * (n - 1)) / 2;

        }
        System.out.println(n);
        System.out.println(anagramPairCount);
    }

    static int sherlockAndAnagrams(String s) {

        int n = s.length();
        Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
        List<Integer> freq = new ArrayList<Integer>();
        for (int k = 0; k < 26; k++)
            freq.add(0);

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < 26; k++)
                freq.set(k, 0);

            for (int k = j; k < n; k++) {
                // update freq array of current
                // substring
                freq.set(s.charAt(k) - 'a', freq.get(s.charAt(k) - 'a') + 1);

                // increase count corresponding
                // to this freq array
                //freq.stream().collect(Collectors.toList());
                if (map.containsKey(freq)) map.replace(freq, map.get(freq) + 1);
                else map.put(freq.stream().collect(Collectors.toList()), 1);
                //if we use freq alone then it affects other values
            }
        }
        int result = 0;
        int fre = 0;
        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
            fre = entry.getValue();

            result += ((fre) * (fre - 1)) / 2;
        }

        System.out.println(fre);
        System.out.println(result);

        return result;
    }
}
