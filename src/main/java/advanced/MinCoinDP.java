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

    public static int coinChange(int[] coins, int targetAmount) {
        int[] result = new int[targetAmount + 1];

        Arrays.fill(result, targetAmount + 1); //fill array with some random value greater than target amount
        result[0] = 0; //fewest # of coins to make 0 cents.

        // we are solving subproblems first for say amount 0, 1,.... upto 'amount'.
        // min coins that sum to i, 0 <= i <= amount
        for(int amount = 0; amount <= targetAmount; amount++) {
            //min coins required to give amount i
            for(int coinIdx = 0; coinIdx < coins.length; coinIdx++) {
                int coin = coins[coinIdx];
                //can only take this coin, if it is <= i
                if(coin <= amount) {
                    //minNoOfCoin[i] = min(randomValue, current coin + min coins required for sum (i - coins[j])
                    result[amount] = Math.min(result[amount], 1 + result[amount - coin]);
                }
            }
        }

        return result[targetAmount] > targetAmount ? -1 : result[targetAmount];
    }
}
