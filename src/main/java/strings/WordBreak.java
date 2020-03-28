package strings;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given a string and dictionary, backTrackingAndRecursion the string as seprarated by valid words else backTrackingAndRecursion nothing.
 *
 * whatisjava -> true whatisj-> false
 *
 * Done using backtracking and recursion
 */
public class WordBreak {

    public static void main(String[] args) {
        WordBreak m = new WordBreak();
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
