import java.util.TreeMap;

public class ScootTest {
    public static void main(String args[]) {
        String in = "zasdaazzeerr";
        System.out.println(firstOcuurance(in));
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
}
