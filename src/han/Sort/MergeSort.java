package han.Sort;


public class MergeSort extends ISort {
    @Override
    public int[] sort(int[] arr) {
        merge(arr,0,arr.length-1);
        return arr;
    }

    @Override
    public void timeCost(int[] source, boolean printSorted) {
        System.out.print("归并排序: ");
        super.timeCost(source, printSorted);
    }

    private void merge(int[] arr,int left,int right) {
        if(left>=right) {
            return;
        }
        int mid=(left+right)>>1;
        merge(arr,left,mid);
        merge(arr,mid+1,right);
        int[] tmp=new int[right-left+1];
        int index=0,i=left,j=mid+1;
        while(i<=mid&&j<=right) {
            if(arr[i]>arr[j]) {
                tmp[index++]=arr[j++];
            }else {
                tmp[index++]=arr[i++];
            }
        }
        while(i<=mid) {
            tmp[index++]=arr[i++];
        }
        while(j<=right) {
            tmp[index++]=arr[j++];
        }
        index--;
        while(index>=0) {
            arr[right--]=tmp[index--];
        }
    }
}
