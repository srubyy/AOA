import java.util.*;

public class MasterMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Solve T(n)=aT(n/b)+O(n^k1)  0. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0)
                break;
            switch (ch) {
                case 1:
                    System.out.print("Enter a, b, k: ");
                    double a = sc.nextDouble(), b = sc.nextDouble(), k = sc.nextDouble();
                    long start = System.nanoTime();
                    double logba = Math.log(a) / Math.log(b);
                    if (logba > k)
                        System.out.printf("Case 1: T(n) = O(n^%.2f)\n", logba);
                    else if (Math.abs(logba - k) < 1e-9)
                        System.out.printf("Case 2: T(n) = O(n^%.2f log n)\n", k);
                    else
                        System.out.printf("Case 3: T(n) = O(n^%.2f)\n", k);
                    long end = System.nanoTime();
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
 * 2 2 1
 * 0
 * 
 * Sample Output:
 * Case 2: T(n) = O(n^1.00 log n)
 * 
 * Time Complexity:
 * Best Case T(n) = Omega(1)
 * Average Case T(n) = Theta(1)
 * Worst Case T(n) = O(1)
 * 
 * Space Complexity:
 * S(n) = O(1)
 */
