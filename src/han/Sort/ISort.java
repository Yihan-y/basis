package han.Sort;

import han.Utils.ArrayUtils;
import java.util.Arrays;

public class ISort {

    public int[] sort(int[] arr) {
        return null;
    }


    public void timeCost(int[] source,boolean printSorted) {
        int[] arr= Arrays.copyOf(source,source.length);
        long start= System.currentTimeMillis();
        sort(arr);
        long end= System.currentTimeMillis();
        System.out.println("运行时间: "+(end-start)+"ms");
        if(printSorted) {
            ArrayUtils.print(arr);
        }
    }


}
