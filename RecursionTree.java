import java.util.*;

public class RecursionTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Solve Recurrence T(n)=aT(n/b)+n^k  0. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter a, b, k, n: ");
                    int a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt(), n = sc.nextInt();
                    long start = System.nanoTime();
                    int level = 0, curr = n;
                    double total = 0;
                    while (curr >= 1) {
                        long nodes = (long) Math.pow(a, level);
                        double work = nodes * Math.pow(curr, k);
                        total += work;
                        System.out.println("Level " + level + ": Nodes=" + nodes + " Size=" + curr + " Work=" + work);
                        if (curr == 1) break;
                        curr /= b;
                        level++;
                    }
                    long end = System.nanoTime();
                    System.out.println("Total Work = " + total);
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
2 2 1 8
0

Sample Output:
Level 0: Nodes=1 Size=8 Work=8.0
Level 1: Nodes=2 Size=4 Work=8.0
Level 2: Nodes=4 Size=2 Work=8.0
Level 3: Nodes=8 Size=1 Work=8.0
Total Work = 32.0

Time Complexity:
Best Case T(n)    = Omega(log_b n)
Average Case T(n) = Theta(log_b n)
Worst Case T(n)   = O(log_b n)

Space Complexity:
S(n) = O(1)
*/
