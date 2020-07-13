package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WordBreakBackTracking02 {
    public static void main(String[] args) {
        String s = "applepenapple";
//        Set<String> d = new HashSet<>(Arrays.asList("what", "is", "java"));
        Set<String> d = new HashSet<>(Arrays.asList("apple", "pen"));
        Stack<Integer> idx = new Stack<>();
        int i = 0, len = s.length(), start = 0;

        boolean result = false;
        while (i >= 0) {
            result = wordBreak(s, d, idx, start, i, len);
            System.out.println(idx);

            if (result) {
                System.out.println("Success found!!!");
                return;
            }

            if (idx.size() < 2) {
                System.out.println("No word break");
                return;
            }

            i = idx.pop();
            start = idx.pop();
        }

        System.out.println("No word break");
    }

    static boolean wordBreak(String s, Set<String> d, Stack<Integer> idx, int start, int i, int len) {

        while (i < len) {
            String word = s.substring(start, i + 1);
            if (d.contains(word)) {
                if (i + 1 == len) return true;
                idx.push(start);
                start = i + 1;
            }

            i++;
        }

        return false;
    }
}
