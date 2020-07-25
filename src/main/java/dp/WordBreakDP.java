package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * given string and dictionary, check if string can be broken down into words from dictionary
 * Time: O(n^3), Space: O(n^2)
 * https://www.techiedelight.com/word-break-problem/
 */
public class WordBreakDP {

    public static void main(String[] args) {
        String input = "";
        Set<String> dict = new HashSet<>();
        int[] dp = new int[input.length()];
        System.out.println(wordBreak(input, dp, dict));
    }

    static boolean wordBreak(String word, int[] dp, Set<String> d) {
        if (word.length() == 0) return true;

        int len = word.length() - 1;
        if (dp[len] == -1) {
            //mark as visited
            for (int i = 0; i < len; i++) {
                if (d.contains(word.substring(0, i)) && wordBreak(word.substring(i), dp, d)) {
                    dp[len] = 1;
                    return true;
                }
            }
        }

        return dp[len] == 1;
    }
}
