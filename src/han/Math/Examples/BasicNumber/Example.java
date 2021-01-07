package han.Math.Examples.BasicNumber;

import han.Math.Utils.Math;

import java.util.Arrays;

public class Example {
    /*
    * leetcode:204
    * Count the number of prime numbers less than a non-negative number, n.
    *
    * Example 1:
    * Input: n = 10
    * Output: 4
    * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
    * */
    public int countPrimes(int n) {
        // bad solution
//        int res=0;
//        for(int i=2;i<n;i++) {
//            res+=Math.isPrime(i)?1:0;
//        }
//        return res;
        if(n<=2) {
            return 0;
        }
        boolean[] prime=new boolean[n];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        int res=0;
        for(int i=2;i<n;i++) {
            if(prime[i]) {
                res++;
                for(int j=2;i*j<n;j++) {
                    prime[i*j]=false;
                }
            }
        }
        return res;
    }

    /*
    * leetcode:503
    * Given an integer, return its base 7 string representation.
    *
    * Example 1:
    * Input: 100
    * Output: "202"
    * */
    public String convertToBase7(int num) {
        return Math.convert2BaseN(num,7);
    }


    /*
    * leetcode:238
    * Given an array nums of n integers where n > 1,
    * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
    *
    * Example:
    * Input:  [1,2,3,4]
    * Output: [24,12,8,6]
    * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
    * Note: Please solve it without division and in O(n).
    * */
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] res=new int[len];
        res[0]=1;
        for(int i=1;i<len;i++) {
            res[i]=res[i-1]*nums[i-1];
        }
        int cur=1;
        for(int i=len-2;i>=0;i--) {
            cur*=nums[i+1];
            res[i]*=cur;
        }
        return res;
    }

    

}
