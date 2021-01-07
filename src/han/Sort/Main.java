package han.Sort;

import han.Sort.Enum.SortType;
import han.Sort.Factory.SortFactory;
import han.Sort.Utils.ArrayUtils;

public class Main {

    public static void main(String[] args) {
        int[] arr= ArrayUtils.autoArray(50000,100000);

        SortFactory.getSortByType(SortType.BUBBLE).timeCost(arr,false);
        SortFactory.getSortByType(SortType.SELECTION).timeCost(arr,false);
        SortFactory.getSortByType(SortType.INSERT).timeCost(arr,false);
        SortFactory.getSortByType(SortType.SHELL).timeCost(arr,false);
        SortFactory.getSortByType(SortType.QUICK).timeCost(arr,false);
        SortFactory.getSortByType(SortType.MERGE).timeCost(arr,false);
        SortFactory.getSortByType(SortType.HEAP).timeCost(arr,false);
        SortFactory.getSortByType(SortType.BUCKET).timeCost(arr,true);
    }
}
