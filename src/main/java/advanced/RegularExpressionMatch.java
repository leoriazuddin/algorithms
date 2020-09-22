package advanced;

/**
 * https://leetcode.com/problems/regular-expression-matching/submissions/
 *
 */
public class RegularExpressionMatch {
    public static boolean isMatch(String s, String p) {

        if(p == null || p.length() == 0)
            return s == null || s.length() == 0;

        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        dp[0][0] = true;

        for(int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*')
                dp[0][i] = true;
        }

        for(int i = 1; i <= sLen; i++) {
            for(int j = 1; j <= pLen; j++) {
                if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'));
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[sLen][pLen];
    }
}
