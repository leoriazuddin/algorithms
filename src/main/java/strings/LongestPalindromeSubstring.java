package strings;

/**
 * Given a string, find the longest substring which is palindrome.
 *
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 *
 * Brute force: time - O(n^3) with 3 loops
 * DP: Time - O(n^2), Space - O(n^2)
 * This: time - O(n^2), Space - O(1)
 * Manachers algorithm: O(n)
 */
public class LongestPalindromeSubstring {

    static int longestPalindromeSubstring(String s) {
        int len = s.length();
        int maxLength = 1;
        int start = 0;
        for(int i = 1; i < len; i++) {
            int low = i-1;
            int high = i;

            //check all even length palindromes and track maxLength
            while(low >=0 && high < len && s.charAt(low) == s.charAt(high)) {
                if(high -low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }

            low = i - 1;
            high = i + 1;
            //check all odd length palindromes
            while(low >=0 && high < len && s.charAt(low) == s.charAt(high)) {
                if(high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }
        }

        System.out.println(s.substring(start, start + maxLength));
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "forgeeksskeegfor";
        longestPalindromeSubstring(input);
    }
}
