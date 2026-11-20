import java.util.*;

public class BTreeManual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Order-3 B-Tree: Root holds max 2 keys; splits into Root + Left + Right
        List<Integer> root = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        boolean isSplit = false;

        while (true) {
            System.out.println("\n1.Insert  2.Delete  3.Search  4.Display  0.Exit");
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
                    if (!isSplit) {
                        root.add(k);
                        Collections.sort(root);
                        if (root.size() == 3) { // Split root on 3rd key
                            left.add(root.get(0));
                            right.add(root.get(2));
                            int mid = root.get(1);
                            root.clear();
                            root.add(mid);
                            isSplit = true;
                        }
                    } else {
                        if (k < root.get(0)) {
                            left.add(k);
                            Collections.sort(left);
                        } else {
                            right.add(k);
                            Collections.sort(right);
                        }
                    }
                    end = System.nanoTime();
                    System.out.println("Inserted. Time (ns): " + (end - start));
                    break;

                case 2:
                    System.out.print("Enter key to delete: ");
                    int del = sc.nextInt();
                    start = System.nanoTime();
                    boolean removed = root.remove(Integer.valueOf(del))
                            || left.remove(Integer.valueOf(del))
                            || right.remove(Integer.valueOf(del));
                    end = System.nanoTime();
                    System.out.println((removed ? "Deleted." : "Not found.") + " Time (ns): " + (end - start));
                    break;

                case 3:
                    System.out.print("Enter key to search: ");
                    int sk = sc.nextInt();
                    start = System.nanoTime();
                    boolean found = root.contains(sk)
                            || (isSplit && sk < root.get(0) && left.contains(sk))
                            || (isSplit && sk > root.get(0) && right.contains(sk));
                    end = System.nanoTime();
                    System.out.println((found ? "Found." : "Not found.") + " Time (ns): " + (end - start));
                    break;

                case 4:
                    start = System.nanoTime();
                    if (!isSplit)
                        System.out.println("Root: " + root);
                    else
                        System.out.println("Root: " + root + " -> Left: " + left + ", Right: " + right);
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
 * Sample Input:
 * 1 10
 * 1 20
 * 1 5
 * 3 5
 * 4
 * 2 20
 * 4
 * 0
 * 
 * Sample Output:
 * Inserted.
 * Inserted.
 * Inserted.
 * Found.
 * Root: [10] -> Left: [5], Right: [20]
 * Deleted.
 * Root: [10] -> Left: [5], Right: []
 * 
 * Time Complexity (per operation):
 * Best Case T(n) = Omega(1)
 * Average Case T(n) = Theta(log n)
 * Worst Case T(n) = O(log n)
 * 
 * Space Complexity:
 * S(n) = O(n)
 */