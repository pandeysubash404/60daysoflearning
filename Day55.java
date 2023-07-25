/* 0 - 1 Knapsack Problem */

public class Day55 {
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Base case: If the knapsack capacity is 0 or the number of items is 0, the maximum value is 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0;
        }

        // Fill the dp table using bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The result will be in the bottom-right cell of the dp table
        return dp[n][W];
    }//knapSack method
    
    public static void main(String[] args) {
        int[] val = { 60, 100, 120 }; // Example values
        int[] wt = { 10, 20, 30 }; // Example weights
        int W = 50; // Knapsack capacity

        int n = val.length;
        int maxValue = knapSack(W, wt, val, n);
        System.out.println("The maximum value in the knapsack is: " + maxValue);
        /*
         OutPut :
         The maximum value in the knapsack is: 220
         */
    }


}

