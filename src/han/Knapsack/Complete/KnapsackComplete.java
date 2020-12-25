package han.Knapsack.Complete;

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
}
