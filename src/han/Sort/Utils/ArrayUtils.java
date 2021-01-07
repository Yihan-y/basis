package han.Sort.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayUtils {

    public static int[] autoArray(int size, int max) {
        int[] res=new int[size];
        for(int i=0;i<size;i++) {
            res[i]=(int) (Math.random()*max);
        }
        return res;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static int[] append(int[] arr,int i) {
        arr=arr==null?new int[0]:arr;
        arr=Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1]=i;
        return arr;
    }
}
