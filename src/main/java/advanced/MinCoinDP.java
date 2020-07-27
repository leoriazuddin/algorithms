package advanced;

import java.util.Arrays;

/**
 * Given array of coins and an amount, find min coins that make the target amount.
 * Assume infinite supply of each coin in array.
 * https://www.youtube.com/watch?v=1R0_7HqNaW0
 * Time: O(n*m), n coins and m target amount.
 * Space: O(m)
 */
public class MinCoinDP {

    public static int coinChange(int[] inputCoins, int amount) {
        int[] minCoins = new int[amount + 1];

        Arrays.fill(minCoins, amount + 1); //fill array with some random value greater than target amount
        minCoins[0] = 0; //fewest # of coins to make 0 cents.

        // we are solving subproblems first for say amount 0, 1,.... upto 'amount'.
        // min coins that sum to i, 0 <= i <= amount
        for(int i = 0; i <= amount; i++) {
            //min coins required to give amount i
            for(int j = 0; j < inputCoins.length; j++) {
                //can only take this coin, if it is <= i
                if(inputCoins[j] <= i) {
                    //minNoOfCoin[i] = min(randomValue, current coin + min coins required for sum (i - coins[j])
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - inputCoins[j]]);
                }
            }
        }

        return minCoins[amount] > amount ? -1 : minCoins[amount];
    }
}
