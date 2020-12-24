package han.Knapsack;

public interface Knapsack {
    /*
    * Given N items and a knapsack with volume of W
    * Every item is labelled its volume of w and value of v
    *
    * Question:
    * How to choose those items to guarantee greatest value within maximum volume?
    * And what is that value?
    * */
    int knapsackWithTwoDim(int[] weights,int[] values,int N, int W);
    int knapsackWithOneDim(int[] weights,int[] values,int N, int W);

}
