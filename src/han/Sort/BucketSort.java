package han.Sort;

import han.Enum.SortType;
import han.Utils.ArrayUtils;

public class BucketSort extends ISort {
    private final ISort inner=SortFactory.getSortByType(SortType.QUICK);

    @Override
    public int[] sort(int[] arr) {
        int len=arr.length;
        int min=arr[0],max=arr[0];
        for(int i:arr) {
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        // fairly a good way to initialize gap & bucket count
        int gap=(max-min)/len+1,bucketCount=(max-min)/gap+1;
        int[][] buckets=new int[bucketCount][];

        for(int i:arr) {
            int index=(i-min)/gap;
            buckets[index]=ArrayUtils.append(buckets[index],i);
        }
        int index=0;
        for(int[] bucket:buckets) {
            if(bucket!=null) {
                inner.sort(bucket);
                for(int i:bucket) {
                    arr[index++]=i;
                }
            }
        }
        return arr;
    }

    @Override
    public void timeCost(int[] source, boolean printSorted) {
        System.out.print("bucket sorting: ");
        super.timeCost(source, printSorted);
    }
}
