public class ConstructMinimalBSTfromSortedTree {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String args[]) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        Node minimalBst = constructMinimalBST(arr, 0, arr.length - 1);
        System.out.println(minimalBst.toString());
    }

    public static Node constructMinimalBST(int[] arr, int low, int high) {
        if (high < low)
            return null;

        int mid = (low + high) / 2;
        Node root = new Node(arr[mid]);
        root.left = constructMinimalBST(arr, low, mid - 1);
        root.right = constructMinimalBST(arr, mid + 1, high);

        return root;
    }
}
