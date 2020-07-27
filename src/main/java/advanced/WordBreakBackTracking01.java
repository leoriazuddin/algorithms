package advanced;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given a string and dictionary, return true if the string can be separated by valid words else nothing.
 *
 * whatisjava -> true whatisj-> false
 *
 * Done using backtracking and recursion
 */
public class WordBreakBackTracking01 {

    public static void main(String[] args) {
        WordBreakBackTracking01 m = new WordBreakBackTracking01();
        Set<String> dict = new HashSet<>(Arrays.asList("apple", "i", "is", "java", "what", "am", "ace"));

        for (String input : Arrays.asList("whatisjava", "iamace", "wh","ic")) {
            Deque<String> words = new LinkedList<>();

            m.backTrackingAndRecursion(input, dict, words, 0);

            if(words.isEmpty())
                System.out.println(input+" Nothing to print.");

            for(String word : words)
                System.out.print(word + " ");

            System.out.println();
        }
    }

    /*
        check for each substring if its in dictionary recursively
     */
    boolean backTrackingAndRecursion(String s, Set<String> dict, Deque<String> words, int start) {
        int length = s.length();

        for(int i = start; i <= length; i++) {
            String sub = s.substring(start, i);
            if(dict.contains(sub)) {
                words.addLast(sub);
                if(i == length || backTrackingAndRecursion(s, dict, words, i))
                    return true;
                words.removeLast();
            }
        }

        return false;
    }
}
