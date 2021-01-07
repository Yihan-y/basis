package han.Math.Utils;

import han.Sort.Utils.ArrayUtils;

public class Random {
    
    /**
     * @Description return a random shuffling of the array
     * @author han
     * @date 2021/1/7
     */
    public static int[] shuffle(int[] arr) {
        java.util.Random random=new java.util.Random();
        int len=arr.length;
        for(int i=0;i<len;i++) {
            ArrayUtils.swap(arr,i,i+random.nextInt(len-i));
        }
        return arr;
    }
}
