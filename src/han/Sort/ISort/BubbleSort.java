package han.Sort.ISort;

import han.Sort.Factory.ISort;
import han.Sort.Utils.ArrayUtils;

public class BubbleSort extends ISort {
    @Override
    public int[] sort(int[] arr) {
        int len=arr.length;
        for(int i=0;i<len;i++) {
            boolean flag=true;
            for(int j=1;j<len-i;j++) {
                if(arr[j-1]>arr[j]) {
                    ArrayUtils.swap(arr,j-1,j);
                    flag=false;
                }
            }
            if(flag) {
                break;
            }
        }
        return arr;
    }

    @Override
    public void timeCost(int[] arr,boolean printSorted) {
        System.out.print("bubble sorting: ");
        super.timeCost(arr,printSorted);
    }
}
