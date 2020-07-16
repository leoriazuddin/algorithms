package dp;

import java.util.Arrays;

/**
 * Given array of coins and an amount, find min coins that make the target amount.
 * Assume infinite supply of each coin in array.
 * https://www.youtube.com/watch?v=1R0_7HqNaW0
 * Time: O(n*m), n coins and m amount.
 * Space: O(m)
 */
public class MinCoinDP {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1); //fill array with some random value greater than target amount
        dp[0] = 0; //fewest # of coins to make 0 cents.

        // we are solving subproblems first for say amount 0, 1,.... upto 'amount'.
        // min coins that sum to i, 0 <= i <= amount
        for(int i = 0; i <= amount; i++) {
            //min coins required to give amount i
            for(int j = 0; j < coins.length; j++) {
                //can only take this coin, if it is <= i
                if(coins[j] <= i) {
                    //minNoOfCoin[i] = min(randomValue, current coin + min coins required for sum (i - coins[j])
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
