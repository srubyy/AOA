import java.util.*;

public class JobSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Solve Job Sequencing  0.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter number of jobs: ");
                    int n = sc.nextInt();
                    String[] id = new String[n];
                    int[] d = new int[n], p = new int[n];
                    int maxD = 0;
                    System.out.println("Enter JobID, Deadline, Profit:");
                    for (int i = 0; i < n; i++) {
                        id[i] = sc.next();
                        d[i] = sc.nextInt();
                        p[i] = sc.nextInt();
                        if (d[i] > maxD) maxD = d[i];
                    }

                    long start = System.nanoTime();
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (p[i] < p[j]) {
                                int tp = p[i]; p[i] = p[j]; p[j] = tp;
                                int td = d[i]; d[i] = d[j]; d[j] = td;
                                String tid = id[i]; id[i] = id[j]; id[j] = tid;
                            }
                        }
                    }
                    String[] slot = new String[maxD + 1];
                    int total = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = d[i]; j >= 1; j--) {
                            if (slot[j] == null) { slot[j] = id[i]; total += p[i]; break; }
                        }
                    }
                    long end = System.nanoTime();
                    System.out.print("Selected Jobs: ");
                    for (int i = 1; i <= maxD; i++) if (slot[i] != null) System.out.print(slot[i] + " ");
                    System.out.println("\nTotal Profit = " + total);
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
4
A 2 100
B 1 19
C 2 27
D 1 25
0

Sample Output:
Selected Jobs: C A
Total Profit = 127

Time Complexity:
Best Case T(n)    = Omega(n log n)
Average Case T(n) = Theta(n^2)
Worst Case T(n)   = O(n^2)

Space Complexity:
S(n) = O(n)
*/
