/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount];
        for (int j = 0; j < coins.length; j++) {
            if (coins[j] != 0 && coins[j] <= amount) {
                dp[coins[j] - 1] = 1;
            }
        }
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i + coins[j] < amount && i + coins[j] > 0 && dp[i] != 0) {
                    if (dp[i + coins[j]] == 0) {
                        dp[i + coins[j]] = dp[i] + 1;
                    }
                    else {
                        dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
                    }
                }
            }
            System.out.println(dp[i]);
        }
        if (dp[amount - 1] == 0) {
            return -1;
        }
        else {
            return dp[amount - 1];
        }
    }
}