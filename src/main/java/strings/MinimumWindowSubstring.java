package strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        // add all t char to map
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int l = 0, min_left = 0, min_len = Integer.MAX_VALUE, cnt = 0;
        // keep going right till you find all char in t cnt == t when all found
        for (int r = 0; r < s.length(); r++) {
            char cr = s.charAt(r);
            if (map.containsKey(cr)) {
                map.put(cr, map.get(cr) - 1);
                if (map.get(cr) >= 0) {
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
                char cl = s.charAt(l);
                if (map.containsKey(cl)) {
                    map.put(cl, map.get(cl) + 1);
                    if (map.get(cl) > 0) {
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
