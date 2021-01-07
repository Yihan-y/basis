package han.Knapsack.IKnapsack;

import han.Knapsack.Knapsack;

public class KnapsackComplete implements Knapsack {
    /*
    * one item can be chosen multiple times
    *
    * */

    /*
    * difference between 0-1 and complete is limitation on the choices
    * assuming that item i can be chosen k times (k>=0&&k<=W/w)
    * dp[i][j]=Max(dp[i-1][j],dp[i-1][j-w]+v,dp[i-1][j-2w]+2v,...,dp[i-1][j-kw]+kw)
    * however, if total volume W approaches infinite while item's volume is infinitely small
    * comparison times will also become infinite, whose cost is beyond acceptable range
    *
    * with a deeper understanding of this issue, it can be revealed:
    * as dp[i][j-w] was being taken into consideration, dp[i-1][j-w], dp[i-1][j-2w]+v,... had already been considered
    * so state transition equation can be optimized as:
    * dp[i][j]=Max(dp[i-1][j],dp[i][j-w]+v)
    * */
    @Override
    public int knapsackWithTwoDim(int[] weights, int[] values, int N, int W) {
        int[][] dp=new int[N+1][W+1];
        for(int i=1;i<=N;i++) {
            int w=weights[i-1],v=values[i-1];
            for(int j=0;j<=W;j++) {
                if(j>=w) {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-w]+v);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    /*
    * same, space complexity can be optimized to O(W)
    * reason why forward traversal is a must is apparent
    * as information of former j-w is needed
    * */
    @Override
    public int knapsackWithOneDim(int[] weights, int[] values, int N, int W) {
        int[] dp=new int[W+1];
        for(int i=1;i<=N;i++) {
            int w=weights[i-1],v=values[i-1];
            for(int j=w;j<=W;j++) {
                dp[j]=Math.max(dp[j],dp[j-w]+v);
            }
        }
        return dp[W];
    }

    /*
    * leetcode:322
    * You are given coins of different denominations and a total amount of money amount.
    * Write a function to compute the fewest number of coins that you need to make up that amount.
    * If that amount of money cannot be made up by any combination of the coins, return -1.
    * You may assume that you have an infinite number of each kind of coin.
    *
    * Example 1:
    * Input: coins = [1,2,5], amount = 11
    * Output: 3
    * Explanation: 11 = 5 + 5 + 1
    * */
    public int coinChange(int[] coins, int amount) {
        int len=coins.length;
        // two-dimen
        /*int[][] dp=new int[len+1][amount+1];
        for(int i=0;i<=amount;i++) {
            dp[0][i]=amount+1;
        }
        dp[0][0]=0;
        for(int i=1;i<=len;i++) {
            int weight=coins[i-1];
            for(int j=0;j<=amount;j++) {
                if(j>=weight) {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-weight]+1);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[len][amount]==amount+1?-1:dp[len][amount];*/
        // one-dimen
        int[] dp=new int[amount+1];
        for(int i=1;i<=amount;i++) {
            dp[i]=amount+1;
        }
        for(int i=1;i<=len;i++) {
            int weight=coins[i-1];
            for(int j=weight;j<=amount;j++) {
                dp[j]=Math.min(dp[j],dp[j-weight]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }

    /*
    * leetcode:518
    * You are given coins of different denominations and a total amount of money.
    * Write a function to compute the number of combinations that make up that amount.
    * You may assume that you have infinite number of each kind of coin.
    *
    * Example 1:
    * Input: amount = 5, coins = [1, 2, 5]
    * Output: 4
    * Explanation: there are four ways to make up the amount:
    * 5=5
    * 5=2+2+1
    * 5=2+1+1+1
    * 5=1+1+1+1+1
    * */
    public int change(int amount, int[] coins) {
        int len=coins.length;
        // two-dimen
        /*int[][] dp=new int[len+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<=len;i++) {
            int weight=coins[i-1];
            for(int j=0;j<=amount;j++) {
                if(j>=weight) {
                    dp[i][j]=dp[i-1][j]+dp[i][j-weight];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[len][amount];*/
        // one-dimen
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=1;i<=len;i++) {
            int weight=coins[i-1];
            for(int j=weight;j<=amount;j++) {
                dp[j]+=dp[j-weight];
            }
        }
        return dp[amount];
    }

    /**
     * special one
     * leetcode:377
     * Given an integer array with all positive numbers and no duplicates,
     * find the number of possible combinations that add up to a positive integer target.
     *
     * Example:
     * nums = [1, 2, 3]
     * target = 4
     * The possible combination ways are:
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * Note that different sequences are counted as different combinations.
     * Therefore the output is 7.
     *
     * Solution:
     * different from complete knapsack problem, which examines combination
     * the core of this problem is permutation
     * dp[i-num] represents number of sets which end up with num
     * so dp[i]=Sum(dp[i-num1],dp[i-num2],...)
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++) {
            for(int num:nums) {
                if(num<=i) {
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
