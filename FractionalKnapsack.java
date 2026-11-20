import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Solve Fractional Knapsack  0.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter number of items: ");
                    int n = sc.nextInt();
                    double[] p = new double[n], w = new double[n];
                    System.out.println("Enter profit and weight for each item:");
                    for (int i = 0; i < n; i++) {
                        p[i] = sc.nextDouble();
                        w[i] = sc.nextDouble();
                    }
                    System.out.print("Enter capacity: ");
                    double cap = sc.nextDouble();

                    long start = System.nanoTime();
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (p[i] / w[i] < p[j] / w[j]) {
                                double tp = p[i]; p[i] = p[j]; p[j] = tp;
                                double tw = w[i]; w[i] = w[j]; w[j] = tw;
                            }
                        }
                    }
                    double maxProfit = 0;
                    for (int i = 0; i < n; i++) {
                        if (cap >= w[i]) { cap -= w[i]; maxProfit += p[i]; }
                        else { maxProfit += p[i] * (cap / w[i]); break; }
                    }
                    long end = System.nanoTime();
                    System.out.println("Max Profit = " + maxProfit);
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
Sample Input:
1
3
60 10
100 20
120 30
50
0

Sample Output:
Max Profit = 240.0

Time Complexity:
Best Case T(n)    = Omega(n log n) [O(n^2) here due to simple sort]
Average Case T(n) = Theta(n log n) [O(n^2) here]
Worst Case T(n)   = O(n^2)

Space Complexity:
S(n) = O(n)
*/
