package han.Sort;

import han.Utils.ArrayUtils;

public class QuickSort extends ISort {
    @Override
    public int[] sort(int[] arr) {
        quick(arr,0,arr.length-1);
        return arr;
    }

    @Override
    public void timeCost(int[] source, boolean printSorted) {
        System.out.print("quick sorting: ");
        super.timeCost(source, printSorted);
    }

    private void quick(int[] arr,int left,int right) {
        if(left<right) {
            int partitionIndex=partition(arr,left,right);
            quick(arr,left,partitionIndex-1);
            quick(arr,partitionIndex+1,right);
        }
    }

    private int partition(int[] arr,int left,int right) {
        int pivot=left,index=left+1;
        for(int i=index;i<=right;i++) {
            if(arr[i]<arr[pivot]) {
                ArrayUtils.swap(arr,i,index);
                index++;
            }
        }
        ArrayUtils.swap(arr,pivot,index-1);
        return index-1;
    }
}
