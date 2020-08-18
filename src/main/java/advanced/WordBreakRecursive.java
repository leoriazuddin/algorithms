package advanced;

import java.util.Set;

/**
 * Time complexity is exponential
 */

public class WordBreakRecursive {

    public static void main(String[] args) {

    }

    static boolean wordBreak(String word, Set<String> d) {
        if(word == null || word.length() == 0)
            return true;

        int len = word.length();
        for(int i = 0; i < len; i++) {
            if(d.contains(word.substring(0, i)) && wordBreak(word.substring(i, len), d))
                return true;
        }

        return false;
    }
}
