package han.Knapsack.O1;

import han.Knapsack.Knapsack;

public class Knapsack0_1 implements Knapsack {
    /*
    * each item can only be chosen once or less
    *
    * */

    /*
    * since item can be chosen once or less
    * it's fairly easy to define:
    * dp[i][j]=Max(dp[i-1][j],dp[i-1][j-w]+v)
    * dp[i-1][j] stands for not choosing the current item, whose value remains unchanged
    * while dp[i-1][j-w] means the current is to be chosen, and additional v needs to be considered
    * and the larger one turns out the result
    * */
    @Override
    public int knapsackWithTwoDim(int[] weights, int[] values, int N, int W) {
        int[][] dp=new int[N+1][W+1];
        for(int i=1;i<=N;i++) {
            int w=weights[i-1],v=values[i-1];
            for(int j=1;j<=W;j++) {
                if(j>=w) {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    /*
    * space complexity can be optimized to O(W)
    * */
    @Override
    public int knapsackWithOneDim(int[] weights, int[] values, int N, int W) {
        int[] dp=new int[W+1];
        for(int i=1;i<=N;i++) {
            int w=weights[i-1],v=values[i-1];
            for(int j=W;j>=w;j--) {
                dp[j]=Math.max(dp[j],dp[j-w]+v);
            }
        }
        return dp[W];
    }


    /*
    * leetcode:416
    * Given a non-empty array nums containing only positive integers
    * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal
    *
    * Example1:
    * Input: nums = [1,5,11,5]
    * Output: true
    * Explanation: The array can be partitioned as [1, 5, 5] and [11].
    * */
    public boolean canPartition(int[] nums) {
        int len=nums.length,sum=0,max=0;
        for(int i:nums) {
            sum+=i;
            max=Math.max(max,i);
        }
        if(sum%2==1||sum<2*max) {
            return false;
        }
        int target=sum/2;
        // two-dimen
        /*boolean[][] dp=new boolean[len+1][target+1];
        dp[0][0]=true;
        for(int i=1;i<=len;i++) {
            int weight=nums[i-1];
            for(int j=1;j<=target;j++) {
                if(weight>=j) {
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-weight];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[len][target];*/
        // one-dimen
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int i=1;i<=len;i++) {
            int weight=nums[i-1];
            for(int j=target;j>=weight;j--) {
                dp[j]=dp[j]||dp[j-weight];
                if(dp[target]) {
                    return true;
                }
            }
        }
        return false;
    }


}
