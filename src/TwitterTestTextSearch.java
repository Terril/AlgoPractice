import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TwitterTestTextSearch {

    public static void main(String args[]) {
        String[] text = new String[]{"dog", "deer", "deal"};
        String query = "de";
        TriNode node = new TriNode();
        //Node Ideal solution
//        PriorityQueue queue = new PriorityQueue();
        insertFirst(query, node);
        for (int i = 0; i < text.length; i++) {
            boolean arr = returnSearchResults(text[i], node);
            if (arr) {
                System.out.print(text[i]);
                System.out.print(", ");
            }
        }
    }

    static void insertFirst(String text, Queue queue) {
        // Using queue
        //   queue.add(text);
    }

    static void insertFirst(String text, TriNode root) {
        int length = text.length();
        TriNode crawl = root;
        int index;
        for (int i = 0; i < length; i++) {
            index = text.charAt(i) - 'a';
            if (crawl.children[index] == null) {
                crawl.children[index] = new TriNode();
            }
            crawl = crawl.children[index];
        }
        crawl.isEndOfWord = true;
    }

    private static boolean returnSearchResults(String query, TriNode root) {
        TriNode crawl = root;
        int index;
        for (int i = 0; i < query.length(); i++) {

            index = query.charAt(i) - 'a';

            if (crawl.children[index] == null)
                break;

            crawl = crawl.children[index];
        }

        return (crawl != null && crawl.isEndOfWord);

    }

    private static void returnSearchResults(String query, PriorityQueue root) {
//        int level;
//        int length = query.length();
//        int index;
//        TriNode pCrawl = root;


        Iterator ite = root.iterator();
        while (ite.hasNext()) {
            String value = String.valueOf(ite.next());
            if (value.contains(query)) {
                System.out.print(value);
            }
        }

//        for (level = 0; level < length; level++)
//        {
//            index = query.charAt(level);
//            if (pCrawl.node == null)
//                return false;
//
//            pCrawl = pCrawl.children[index];
//        }
    }

    static final int ALPHABET_SIZE = 26;

    static class TriNode {
        TriNode[] children = new TriNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TriNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }
}
