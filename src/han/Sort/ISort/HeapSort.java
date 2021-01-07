package han.Sort.ISort;

import han.Sort.Factory.ISort;
import han.Sort.Utils.ArrayUtils;

public class HeapSort extends ISort {
    @Override
    public int[] sort(int[] arr) {
        buildMaxHeap(arr);

        int len=arr.length;
        while(len-->0) {
            ArrayUtils.swap(arr,0,len);
            heapify(arr,0,len);
        }
        return arr;
    }

    @Override
    public void timeCost(int[] source, boolean printSorted) {
        System.out.print("max heap sorting: ");
        super.timeCost(source, printSorted);
    }

    private void buildMaxHeap(int[] arr) {
        int len=arr.length;
        for(int i=len/2-1;i>=0;i--) {
            heapify(arr,i,len);
        }
    }

    private void heapify(int[] arr,int index,int length) {
        int left=index*2+1,right=index*2+2,largest=index;
        if(left<length&&arr[left]>arr[largest]) {
            largest=left;
        }
        if(right<length&&arr[right]>arr[largest]) {
            largest=right;
        }
        if(largest!=index) {
            ArrayUtils.swap(arr,index,largest);
            heapify(arr,largest,length);
        }
    }
}
