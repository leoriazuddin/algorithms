package strings;

/**
 * find length of longest prefix which is also suffix and they dont overlap
 */
public class LongestPrefixSuffix {
    public static void main(String[] args) {
        longestPrefix("hsbathroombaths");
    }
    static void longestPrefix(String s) {
        int start = 0, len = s.length(), mid = len / 2;

        while(mid < len) {
            if(s.charAt(start) == s.charAt(mid)) {
                start++;
            } else {
                start = 0;
            }

            mid++;
        }

        System.out.println(start);
    }
}
