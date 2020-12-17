package han.Utils;

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
}
