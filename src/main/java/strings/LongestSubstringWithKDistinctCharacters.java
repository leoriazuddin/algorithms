package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given string find the longest substring with at most K distinct characters. IF all chars are same return null; IF
 * more than one string of same length return any one;
 *
 * O(n)
 *
 * use two pointers start and end. track K and character count in a map.
 * if map.size() == K, begin deleting chars from start,
 * keep updating maxLen when end changes.
 */
public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, rStart = 0, rEnd = 0, end = 0, len = Integer.MIN_VALUE;
        int k = 4;
        String input = "eeeceebdaaaaaaaketchup";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (map.size() < k || map.containsKey(c)) {
                map.compute(c, (key, v) -> v == null ? 1 : v + 1);
            } else if (!map.containsKey(c)) {

                while(map.size() >= k && start < end){
                    char s = input.charAt(start);
                    if(map.get(s) == 1)
                        map.remove(s);
                    else
                        map.put(s, map.get(s)-1);
                    start++;
                }

                map.put(c, 1);
            }

            end = i;
            if (len < end - start + 1) {
                rStart = start;
                rEnd = end;
                len = end - start + 1;
            }

            System.out.println(String.format("%s %s %s %s %s", map, start, end, len, end - start + 1));
        }

        if (map.size() < k) {
            System.out.println("Nothing to print");
        } else {
            System.out.println(String.format("Length %s, string %s", len, input.substring(rStart, rEnd + 1)));
        }
    }
}
