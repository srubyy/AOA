import java.util.*;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Solve 0/1 Knapsack (DP)  0.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0)
                break;
            switch (ch) {
                case 1:
                    System.out.print("Enter number of items: ");
                    int n = sc.nextInt();
                    int[] val = new int[n], wt = new int[n];
                    System.out.println("Enter profit and weight for each item:");
                    for (int i = 0; i < n; i++) {
                        val[i] = sc.nextInt();
                        wt[i] = sc.nextInt();
                    }
                    System.out.print("Enter capacity W: ");
                    int W = sc.nextInt();

                    long start = System.nanoTime();
                    int[][] dp = new int[n + 1][W + 1];
                    for (int i = 1; i <= n; i++) {
                        for (int w = 1; w <= W; w++) {
                            if (wt[i - 1] <= w)
                                dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                            else
                                dp[i][w] = dp[i - 1][w];
                        }
                    }
                    long end = System.nanoTime();
                    System.out.println("Max Profit = " + dp[n][W]);
                    System.out.println("Execution Time (ns): " + (end - start));
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
/*
 * Sample Input:
 * 1
 * 4
 * 1 1
 * 4 3
 * 5 4
 * 7 5
 * 7
 * 0
 * 
 * Sample Output:
 * Max Profit = 9
 * 
 * Time Complexity:
 * Best Case T(n) = Omega(n * W)
 * Average Case T(n) = Theta(n * W)
 * Worst Case T(n) = O(n * W)
 * 
 * Space Complexity:
 * S(n) = O(n * W)
 */
