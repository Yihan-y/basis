package han.Sort;

import han.Utils.ArrayUtils;

public class ShellSort extends ISort {
    @Override
    public int[] sort(int[] arr) {
        int len=arr.length,gap=len/2;
        while (gap>0) {
            for(int i=gap;i<len;i++) {
                int j=i;
                while (j-gap>=0&&arr[j]<arr[j-gap]) {
                    ArrayUtils.swap(arr,j,j-gap);
                    j-=gap;
                }
            }
            gap/=2;
        }
        return arr;
    }

    @Override
    public void timeCost(int[] source, boolean printSorted) {
        System.out.print("shell sorting: ");
        super.timeCost(source, printSorted);
    }
}
