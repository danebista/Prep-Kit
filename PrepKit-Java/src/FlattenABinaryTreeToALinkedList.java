public class FlattenABinaryTreeToALinkedList {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        TreeNode copy = root;
        for (int i = 2; i <= 5; i++) {
            if (i % 2 == 0)
                root.left = new TreeNode(i);
            if (i % 2 == 1 && i != 5) {
                root.right = new TreeNode(i);
                root.right.left = new TreeNode(5);
                root.right.right = new TreeNode(6);
                root = root.left;
            }
            if (i == 5) {
                root.right = new TreeNode(i);
            }

        }

    }

    public static void flattenedTree(TreeNode root) {
        while (root.left != null) {
            TreeNode prev = root.left;
            while (prev.right != null) {
                prev.right = root.right;
                root.left = null;
                root.right = root.left;
            }
            root = root.right;
        }
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }
}
