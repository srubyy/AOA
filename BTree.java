import java.util.*;

public class BTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> btree = new TreeSet<>();
        while (true) {
            System.out.println("\n1.Insert  2.Delete  3.Search  4.Display  0.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 0) break;
            long start, end;
            switch (ch) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    int ins = sc.nextInt();
                    start = System.nanoTime();
                    btree.add(ins);
                    end = System.nanoTime();
                    System.out.println("Inserted. Time (ns): " + (end - start));
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    int del = sc.nextInt();
                    start = System.nanoTime();
                    boolean rem = btree.remove(del);
                    end = System.nanoTime();
                    System.out.println((rem ? "Deleted." : "Not found.") + " Time (ns): " + (end - start));
                    break;
                case 3:
                    System.out.print("Enter key to search: ");
                    int key = sc.nextInt();
                    start = System.nanoTime();
                    boolean found = btree.contains(key);
                    end = System.nanoTime();
                    System.out.println((found ? "Found." : "Not found.") + " Time (ns): " + (end - start));
                    break;
                case 4:
                    start = System.nanoTime();
                    System.out.println("B-Tree Keys (Inorder): " + btree);
                    end = System.nanoTime();
                    System.out.println("Time (ns): " + (end - start));
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
1 20
1 10
1 30
3 10
2 20
4
0

Sample Output:
Inserted.
Inserted.
Inserted.
Found.
Deleted.
B-Tree Keys (Inorder): [10, 30]

Time Complexity (per operation):
Best Case T(n)    = Omega(1)
Average Case T(n) = Theta(log n)
Worst Case T(n)   = O(log n)

Space Complexity:
S(n) = O(n)
*/
