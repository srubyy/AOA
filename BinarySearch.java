import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[0];
        while (true) {
            System.out.println("\n1.Enter Array  2.Search Element  0.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0)
                break;
            switch (ch) {
                case 1:
                    System.out.print("Enter size: ");
                    int n = sc.nextInt();
                    arr = new int[n];
                    System.out.print("Enter " + n + " elements: ");
                    for (int i = 0; i < n; i++)
                        arr[i] = sc.nextInt();
                    break;
                case 2:
                    System.out.print("Enter target: ");
                    int target = sc.nextInt();
                    long start = System.nanoTime();
                    int low = 0, high = arr.length - 1, pos = -1;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if (arr[mid] == target) {
                            pos = mid;
                            break;
                        } else if (arr[mid] < target)
                            low = mid + 1;
                        else
                            high = mid - 1;
                    }
                    long end = System.nanoTime();
                    System.out.println(pos != -1 ? "Found at index: " + (pos + 1) : "Not Found");
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
 * // --- FOR DESCENDING ORDER (e.g. 50 40 30 20 10), REPLACE THE WHILE LOOP
 * ABOVE WITH THIS ---
 * while (low <= high) {
 * int mid = (low + high) / 2;
 * if (arr[mid] == target) { pos = mid; break; }
 * else if (arr[mid] > target) low = mid + 1; // Changed '<' to '>'
 * else high = mid - 1;
 * }
 */

/*
 * Sample Input:
 * 1
 * 5
 * 10 20 30 40 50
 * 2
 * 40
 * 0
 * 
 * Sample Output:
 * Found at index: 3
 * 
 * Time Complexity:
 * Best Case T(n) = Omega(1)
 * Average Case T(n) = Theta(log n)
 * Worst Case T(n) = O(log n)
 * 
 * Space Complexity:
 * S(n) = O(1) auxiliary (O(n) input array)
 */