package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given string find the longest substring with at most 2 distinct characters. IF all chars are same return null; IF
 * more than one string of same length return any one;
 */
public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0, len = Integer.MIN_VALUE;
        int k = 4;
        String input = "eeeceebdaaaaaaa";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (set.size() < k && !set.contains(c)) {
                set.add(c);
            } else if (!set.contains(c)) {
                start = i - 1;
                set.remove(input.charAt(i - 2));
                set.add(c);
            }

            end = i;
            len = Math.max(end - start + 1, len);

            //            System.out.println(String.format("%s %s %s %s",c, end, start, len));
        }

        if (set.size() <= 1) {
            System.out.println("Nothing to print");
        } else {
            System.out.println(String.format("Length %s, string %s", len, input.substring(start, end + 1)));
        }
    }
}
