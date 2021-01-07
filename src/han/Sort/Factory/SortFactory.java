package han.Sort.Factory;

import han.Sort.Enum.SortType;
import han.Sort.ISort.*;

public class SortFactory {

    public static ISort getSortByType(SortType type) {
        switch (type) {
            case BUBBLE:
                return new BubbleSort();
            case SELECTION:
                return new SelectionSort();
            case INSERT:
                return new InsertSort();
            case SHELL:
                return new ShellSort();
            case QUICK:
                return new QuickSort();
            case MERGE:
                return new MergeSort();
            case HEAP:
                return new HeapSort();
            default:
                return new BucketSort();
        }
    }
}
