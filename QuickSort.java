import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Sort Array (Quick Sort)  0.Exit");
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
                    if (n > 1) {
                        Stack<Integer> st = new Stack<>();
                        st.push(0);
                        st.push(n - 1);
                        while (!st.isEmpty()) {
                            int high = st.pop(), low = st.pop();
                            int pivot = arr[high], i = low - 1;
                            for (int j = low; j < high; j++) {
                                if (arr[j] <= pivot) {
                                    i++;
                                    int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
                                }
                            }
                            int t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
                            int p = i + 1;
                            if (p - 1 > low) { st.push(low); st.push(p - 1); }
                            if (p + 1 < high) { st.push(p + 1); st.push(high); }
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
10 7 8 9 1 5
0

Sample Output:
Sorted: [1, 5, 7, 8, 9, 10]

Time Complexity:
Best Case T(n)    = Omega(n log n)
Average Case T(n) = Theta(n log n)
Worst Case T(n)   = O(n^2)

Space Complexity:
S(n) = O(log n) average, O(n) worst
*/
