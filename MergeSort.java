import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Sort Array (Merge Sort)  0.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter size: ");
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    System.out.print("Enter elements: ");
                    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

                    long start = System.nanoTime();
                    int[] temp = new int[n];
                    for (int size = 1; size < n; size *= 2) {
                        for (int left = 0; left < n - 1; left += 2 * size) {
                            int mid = Math.min(left + size - 1, n - 1);
                            int right = Math.min(left + 2 * size - 1, n - 1);
                            int i = left, j = mid + 1, k = left;
                            while (i <= mid && j <= right)
                                temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
                            while (i <= mid) temp[k++] = arr[i++];
                            while (j <= right) temp[k++] = arr[j++];
                            for (i = left; i <= right; i++) arr[i] = temp[i];
                        }
                    }
                    long end = System.nanoTime();
                    System.out.println("Sorted: " + Arrays.toString(arr));
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
6
38 27 43 3 9 82
0

Sample Output:
Sorted: [3, 9, 27, 38, 43, 82]

Time Complexity:
Best Case T(n)    = Omega(n log n)
Average Case T(n) = Theta(n log n)
Worst Case T(n)   = O(n log n)

Space Complexity:
S(n) = O(n)
*/
