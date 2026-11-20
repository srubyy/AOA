import java.util.*;

public class BPlusTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> bpTree = new TreeSet<>();
        while (true) {
            System.out.println("\n1.Insert  2.Delete  3.Search  4.RangeQuery  5.DisplayLeaves  0.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0)
                break;
            long start, end;
            switch (ch) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    int k = sc.nextInt();
                    start = System.nanoTime();
                    bpTree.add(k);
                    end = System.nanoTime();
                    System.out.println("Inserted. Time (ns): " + (end - start));
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    int del = sc.nextInt();
                    start = System.nanoTime();
                    boolean rem = bpTree.remove(del);
                    end = System.nanoTime();
                    System.out.println((rem ? "Deleted." : "Not found.") + " Time (ns): " + (end - start));
                    break;
                case 3:
                    System.out.print("Enter key to search: ");
                    int sk = sc.nextInt();
                    start = System.nanoTime();
                    boolean found = bpTree.contains(sk);
                    end = System.nanoTime();
                    System.out.println((found ? "Found." : "Not found.") + " Time (ns): " + (end - start));
                    break;
                case 4:
                    System.out.print("Enter start and end keys: ");
                    int s = sc.nextInt(), e = sc.nextInt();
                    start = System.nanoTime();
                    System.out.println("Range: " + bpTree.subSet(s, true, e, true));
                    end = System.nanoTime();
                    System.out.println("Time (ns): " + (end - start));
                    break;
                case 5:
                    System.out.println("Leaf Level: " + bpTree);
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
 * 1 10
 * 1 20
 * 1 15
 * 3 15
 * 4 10 20
 * 2 10
 * 5
 * 0
 * 
 * Sample Output:
 * Inserted.
 * Inserted.
 * Inserted.
 * Found.
 * Range: [10, 15, 20]
 * Deleted.
 * Leaf Level: [15, 20]
 * 
 * Time Complexity (per operation):
 * Best Case T(n) = Omega(log n)
 * Average Case T(n) = Theta(log n) [Range: Theta(log n + k)]
 * Worst Case T(n) = O(log n) [Range: O(log n + k)]
 * 
 * Space Complexity:
 * S(n) = O(n)
 */