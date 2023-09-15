package test.segmenttree;

class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n]; // Segment tree array
        buildTree(arr, 0, 0, n - 1);
    }

    private void buildTree(int[] arr, int treeIdx, int left, int right) {
        if (left == right) {
            tree[treeIdx] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;
        buildTree(arr, 2 * treeIdx + 1, left, mid); // Build left subtree
        buildTree(arr, 2 * treeIdx + 2, mid + 1, right); // Build right subtree
        tree[treeIdx] = tree[2 * treeIdx + 1] + tree[2 * treeIdx + 2]; // Combine values
    }

    public int query(int ql, int qr) {
        return query(0, 0, n - 1, ql, qr);
    }

    private int query(int treeIdx, int left, int right, int ql, int qr) {
        if (ql > right || qr < left) {
            return 0; // Outside the query range
        }

        if (ql <= left && qr >= right) {
            return tree[treeIdx]; // Fully inside the query range
        }

        int mid = left + (right - left) / 2;
        int leftSum = query(2 * treeIdx + 1, left, mid, ql, qr); // Query left subtree
        int rightSum = query(2 * treeIdx + 2, mid + 1, right, ql, qr); // Query right subtree
        return leftSum + rightSum; // Combine query results
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11}; // Example array
        SegmentTree segmentTree = new SegmentTree(arr);

        // Example tasks
        int sumInRange = segmentTree.query(1, 4); // Sum of elements in range [1, 4]
        System.out.println("Sum in range [1, 4]: " + sumInRange);

        int sumFromIndex = segmentTree.query(2, 5); // Sum of elements from index 2 to 5
        System.out.println("Sum from index 2 to 5: " + sumFromIndex);
    }
}