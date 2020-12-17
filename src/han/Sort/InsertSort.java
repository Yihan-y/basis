package han.Sort;

import han.Utils.ArrayUtils;

public class InsertSort extends ISort {
    @Override
    public int[] sort(int[] arr) {
        int len=arr.length;
        for(int i=1;i<len;i++) {
            int j=i;
            while (j-1>=0&&arr[j]<arr[j-1]) {
                ArrayUtils.swap(arr,j,j-1);
                j--;
            }
        }
        return arr;
    }

    @Override
    public void timeCost(int[] source, boolean printSorted) {
        System.out.print("插入排序: ");
        super.timeCost(source, printSorted);
    }
}
