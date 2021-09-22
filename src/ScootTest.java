import java.util.TreeMap;

public class ScootTest {
    public static void main(String args[]) {
        String in = "zasdaazzeerr";
        System.out.println(firstOcuurance(in));
        System.out.println(fistOccuranceSol2(in));
    }

    private static String firstOcuurance(String in) {

        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        for(char c : in.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String res = "";
        for(char c : map.keySet()) {
            if(map.get(c) > 1) {
                res = Character.toString(c);
                break;
            }
        }

        return res;
    }

    private static String fistOccuranceSol2(String i) {
        int max[] = new int[26];
        for(char c : i.toCharArray()) {
            max[c - 'a']++;
        }

        String res = "";
        for (int j = 0 ; j < max.length; j++) {
            if(max[j] > 1) {
                res = String.valueOf((char)(j + 97));
                break;
            }
        }

        return res;
    }
}
