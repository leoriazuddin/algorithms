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

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> patternMap = new HashMap<>();
        // add all t char to map
        for (char c : t.toCharArray()) {
            if (patternMap.containsKey(c)) {
                patternMap.put(c, patternMap.get(c) + 1);
            } else {
                patternMap.put(c, 1);
            }
        }

        int l = 0, min_left = 0, min_len = Integer.MAX_VALUE, cnt = 0;
        // keep going right till you find all char in t cnt == t when all found
        for (int r = 0; r < s.length(); r++) {
            char c_r = s.charAt(r);
            if (patternMap.containsKey(c_r)) {
                patternMap.put(c_r, patternMap.get(c_r) - 1);
                if (patternMap.get(c_r) >= 0) {
                    cnt++;
                }
            }

            while (cnt == t.length()) {
                // Is this the minimum window ?
                if (r - l + 1 < min_len) {
                    min_left = l;
                    min_len = r - l + 1;
                }
                // Shrink the left side of the window and reduce count if cl part of t
                char c_l = s.charAt(l);
                if (patternMap.containsKey(c_l)) {
                    patternMap.put(c_l, patternMap.get(c_l) + 1);
                    if (patternMap.get(c_l) > 0) {
                        cnt--;
                    }
                }
                l++;
            }
        }
        //System.out.println(min_left + " , " + min_len);
        return (min_len == Integer.MAX_VALUE) ? "" : s.substring(min_left, min_left + min_len);
    }


    public static void main(String[] args) {

        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String s = m.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

}
