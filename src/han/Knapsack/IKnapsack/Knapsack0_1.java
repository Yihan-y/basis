package han.Knapsack.IKnapsack;

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
            for(int j=0;j<=W;j++) {
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
            for(int j=0;j<=target;j++) {
                if(j>=weight) {
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


    /*
    * leetcode:474
    * You are given an array of binary strings strs and two integers m and n.
    * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
    * A set x is a subset of a set y if all elements of x are also elements of y.
    *
    * Example 1:
    * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
    * Output: 4
    * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
    * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
    * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
    * */
    public static int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        // two-dimen
        /*int[][][] dp=new int[len+1][m+1][n+1];
        for(int i=1;i<=len;i++) {
            char[] chars=strs[i-1].toCharArray();
            int zero=0,one=0;
            for(char c:chars) {
                if(c=='0'){
                    zero++;
                }else {
                    one++;
                }
            }
            for(int x=0;x<=m;x++) {
                for(int y=0;y<=n;y++) {
                    if(x>=zero&&y>=one) {
                        dp[i][x][y]=Math.max(dp[i-1][x][y],dp[i-1][x-zero][y-one]+1);
                    }else{
                        dp[i][x][y]=dp[i-1][x][y];
                    }
                }
            }
        }
        return dp[len][m][n];*/
        // one-dimen
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=len;i++) {
            char[] chars=strs[i-1].toCharArray();
            int zero=0,one=0;
            for(char c:chars) {
                if(c=='0') {
                    zero++;
                }else {
                    one++;
                }
            }
            for(int x=m;x>=zero;x--) {
                for(int y=n;y>=one;y--) {
                    dp[x][y]=Math.max(dp[x][y],dp[x-zero][y-one]+1);
                }
            }
        }
        return dp[m][n];
    }

    /*
    * leetcode:494
    * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
    * Now you have 2 symbols + and -.
    * For each integer, you should choose one from + and - as its new symbol.
    * Find out how many ways to assign symbols to make sum of integers equal to target S.
    *
    * Example 1:
    * Input: nums is [1, 1, 1, 1, 1], S is 3.
    * Output: 5
    * Explanation:
    * -1+1+1+1+1 = 3
    * +1-1+1+1+1 = 3
    * +1+1-1+1+1 = 3
    * +1+1+1-1+1 = 3
    * +1+1+1+1-1 = 3
    * There are 5 ways to assign symbols to make the sum of nums be target 3.
    * */
    public int findTargetSumWays(int[] nums, int S) {
        int len=nums.length,max=0;
        for(int i:nums) {
            max+=i;
        }
        if(S>max||S<-max) {
            return 0;
        }
        // two-dimen
        /*int sum=max*2+1;
        int[][] dp=new int[len+1][sum];
        dp[0][max]=1;
        for(int i=1;i<=len;i++) {
            int weight=nums[i-1];
            for(int j=0;j<sum;j++) {
                dp[i][j]=(j+weight<sum?dp[i-1][j+weight]:0)+(j-weight>=0?dp[i-1][j-weight]:0);
            }
        }
        return dp[len][S+max];*/
        // one-dimen
        /*
        * sum(p) represents sets with plus ahead while sum(m) represents minus ones
        * s=sum(p)-sum(m)
        * and max=sum(p)+sum(m)
        * so sum(p)=(s+max)/2
        * thus problem can be converted into 0-1 knapsack
        * */
        if((S+max)%2==1) {
            return 0;
        }
        int p=(S+max)/2;
        int[] dp=new int[p+1];
        dp[0]=1;
        for(int i=1;i<=len;i++) {
            int weight=nums[i-1];
            for (int j=p;j>=weight;j--) {
                dp[j]+=dp[j-weight];
            }
        }
        return dp[p];
    }

}
