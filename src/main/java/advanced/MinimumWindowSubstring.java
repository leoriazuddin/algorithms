package advanced;

import java.util.HashMap;
import java.util.Map;
/*
* Given a string S and a string T, find the minimum window in S which will contain all the characters
*   in T in complexity O(n)
* https://leetcode.com/problems/minimum-window-substring/
*
* Build patternMap
* iterate through input characters
    if character found in patternMap decrement its count, same time count how many characters were found (cnt).
    Shrink the size of substring found so far
* 
*/
public class MinimumWindowSubstring {

    public String minWindow(String input, String pattern) {
        if (input == null || input.length() == 0 || input.length() < pattern.length()) {
            return "";
        }
        Map<Character, Integer> patternMap = new HashMap<>();
        // add all t char to map
        for (char c : pattern.toCharArray()) {
            if (patternMap.containsKey(c)) {
                patternMap.put(c, patternMap.get(c) + 1);
            } else {
                patternMap.put(c, 1);
            }
        }

        int left = 0, min_left = 0, min_len = Integer.MAX_VALUE, cnt = 0;
        // keep going right till you find all char in t cnt == t when all found
        for (int right = 0; right < input.length(); right++) {
            char rightChar = input.charAt(right);
            if (patternMap.containsKey(rightChar)) {
                patternMap.put(rightChar, patternMap.get(rightChar) - 1);
                if (patternMap.get(rightChar) >= 0) {
                    cnt++;
                }
            }

            while (cnt == pattern.length()) {
                // Is this the minimum window ?
                if (right - left + 1 < min_len) {
                    min_left = left;
                    min_len = right - left + 1;
                }
                // Shrink the left side of the window and reduce count if cl part of t
                char leftChar = input.charAt(left);
                if (patternMap.containsKey(leftChar)) {
                    patternMap.put(leftChar, patternMap.get(leftChar) + 1);
                    if (patternMap.get(leftChar) > 0) {
                        cnt--;
                    }
                }
                left++;
            }
        }
        //System.out.println(min_left + " , " + min_len);
        return (min_len == Integer.MAX_VALUE) ? "" : input.substring(min_left, min_left + min_len);
    }


    public static void main(String[] args) {

        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String s = m.minWindow("AAOBECODEBAAC", "AAA");
        System.out.println(s);
    }

}
