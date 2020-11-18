package advanced;

/**
 * https://www.geeksforgeeks.org/wildcard-pattern-matching/
 * https://leetcode.com/problems/wildcard-matching/
 * https://www.youtube.com/watch?v=3ZDZ-N0EPV0
 *
 */
public class WildcardMatching {

    public static boolean isMatch(String s, String p) {

        if( p == null && p.length() == 0)
            return s == null && s.length() == 0;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        int m = s.length(), n = p.length();

        // empty pattern can match with empty string
        dp[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= n; j++)
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // character is ?
                if(p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j - 1) == '*') {
                    //dp[i][j-1] -> * resolves to empty
                    //dp[i - 1][j] -> * matched a character from input
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }
}
