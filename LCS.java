import java.util.*;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Find LCS (DP)  0.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0)
                break;
            switch (ch) {
                case 1:
                    System.out.print("Enter string 1: ");
                    String s1 = sc.next();
                    System.out.print("Enter string 2: ");
                    String s2 = sc.next();

                    long start = System.nanoTime();
                    int m = s1.length(), n = s2.length();
                    int[][] dp = new int[m + 1][n + 1];

                    for (int i = 1; i <= m; i++) {
                        for (int j = 1; j <= n; j++) {
                            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                                dp[i][j] = 1 + dp[i - 1][j - 1];
                            else
                                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        }
                    }

                    // Backtrack from dp[m][n] to reconstruct the LCS string
                    String lcs = "";
                    int i = m, j = n;
                    while (i > 0 && j > 0) {
                        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                            lcs = s1.charAt(i - 1) + lcs;
                            i--;
                            j--;
                        } else if (dp[i - 1][j] > dp[i][j - 1]) {
                            i--;
                        } else {
                            j--;
                        }
                    }
                    long end = System.nanoTime();

                    System.out.println("LCS Length = " + dp[m][n]);
                    System.out.println("LCS String = " + lcs);
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
 * AGGTAB
 * GXTXAYB
 * 0
 * 
 * Sample Output:
 * LCS Length = 4
 * LCS String = GTAB
 * 
 * Time Complexity:
 * Best Case T(n) = Omega(m * n)
 * Average Case T(n) = Theta(m * n)
 * Worst Case T(n) = O(m * n)
 * 
 * Space Complexity:
 * S(n) = O(m * n)
 */