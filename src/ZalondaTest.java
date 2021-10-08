public class ZalondaTest {
    public static void main(String args[]) {
        System.out.println(solution(0));
    }

    static int solution (int N) {
        StringBuilder result = new StringBuilder();
        String convert = N +"";
        boolean oneTimeInsert = false;
        char firstNegative = convert.charAt(0);
        if(firstNegative == '-') {
            result = new StringBuilder("-5" + convert.substring(1, convert.length()));
            return Integer.parseInt(result.toString());
        }

        for(int i = 0; i < convert.length() ; i++ ) {
            char c = convert.charAt(i);
            if(c < '5' && !oneTimeInsert) {
                result.append("5");
                oneTimeInsert = true;
            }
            result.append(c);
        }
        return Integer.parseInt(result.toString());
    }
}
