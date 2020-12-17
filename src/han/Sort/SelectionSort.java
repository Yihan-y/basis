package han.Sort;

import han.Utils.ArrayUtils;

public class SelectionSort extends ISort {
    @Override
    public int[] sort(int[] arr) {
        int len=arr.length;
        for(int i=0;i<len;i++) {
            int min=arr[i],index=i;
            for(int j=i+1;j<len;j++) {
                min= Math.min(arr[j],min);
                index=min==arr[j]?j:index;
            }
            ArrayUtils.swap(arr,i,index);
        }
        return arr;
    }

    @Override
    public void timeCost(int[] arr, boolean printSorted) {
        System.out.print("选择排序: ");
        super.timeCost(arr, printSorted);
    }
}
