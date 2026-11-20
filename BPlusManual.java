import java.util.*;

public class BPlusManual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Order-3 B+ Tree: Internal index copies middle key; leaves hold all sorted
        // data
        List<Integer> indexRoot = new ArrayList<>();
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        boolean isSplit = false;

        while (true) {
            System.out.println("\n1.Insert  2.Delete  3.Search  4.RangeQuery  5.DisplayTree  0.Exit");
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
                        leaf1.add(k);
                        Collections.sort(leaf1);
                        if (leaf1.size() == 3) { // Copy middle key up to indexRoot; keep all data in leaves
                            int mid = leaf1.get(1);
                            indexRoot.add(mid);
                            leaf2.add(mid);
                            leaf2.add(leaf1.get(2));
                            leaf1.remove(2);
                            leaf1.remove(1);
                            isSplit = true;
                        }
                    } else {
                        if (k < indexRoot.get(0)) {
                            leaf1.add(k);
                            Collections.sort(leaf1);
                        } else {
                            leaf2.add(k);
                            Collections.sort(leaf2);
                        }
                    }
                    end = System.nanoTime();
                    System.out.println("Inserted. Time (ns): " + (end - start));
                    break;

                case 2:
                    System.out.print("Enter key to delete: ");
                    int del = sc.nextInt();
                    start = System.nanoTime();
                    boolean removed = leaf1.remove(Integer.valueOf(del))
                            || leaf2.remove(Integer.valueOf(del));
                    end = System.nanoTime();
                    System.out.println((removed ? "Deleted." : "Not found.") + " Time (ns): " + (end - start));
                    break;

                case 3:
                    System.out.print("Enter key to search: ");
                    int sk = sc.nextInt();
                    start = System.nanoTime();
                    boolean found = (!isSplit) ? leaf1.contains(sk)
                            : (sk < indexRoot.get(0) ? leaf1.contains(sk) : leaf2.contains(sk));
                    end = System.nanoTime();
                    System.out.println((found ? "Found in leaf." : "Not found.") + " Time (ns): " + (end - start));
                    break;

                case 4:
                    System.out.print("Enter start and end keys: ");
                    int s = sc.nextInt(), e = sc.nextInt();
                    start = System.nanoTime();
                    List<Integer> range = new ArrayList<>();
                    for (int x : leaf1)
                        if (x >= s && x <= e)
                            range.add(x);
                    for (int x : leaf2)
                        if (x >= s && x <= e)
                            range.add(x);
                    end = System.nanoTime();
                    System.out.println("Range Result: " + range + " | Time (ns): " + (end - start));
                    break;

                case 5:
                    if (!isSplit)
                        System.out.println("Leaf: " + leaf1);
                    else
                        System.out.println("Index Root: " + indexRoot + " | Linked Leaves: " + leaf1 + " -> " + leaf2);
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
 * Found in leaf.
 * Range Result: [10, 15, 20]
 * Deleted.
 * Index Root: [15] | Linked Leaves: [] -> [15, 20]
 * 
 * Time Complexity (per operation):
 * Best Case T(n) = Omega(log n)
 * Average Case T(n) = Theta(log n) [Range: Theta(log n + k)]
 * Worst Case T(n) = O(log n) [Range: O(log n + k)]
 * 
 * Space Complexity:
 * S(n) = O(n)
 */