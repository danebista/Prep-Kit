/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */

public class Solution {
    /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        if (root == null)
            return result;
        if (!isLeaf(root))
            result.add(root.val);
        addLeft(root.left, result);
        inorderTraversal(root, result);
        addRight(root.right, temp);

        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }

        return result;
    }

    public void addLeft(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        if (!isLeaf(root))
            result.add(root.val);
        if (root.left != null) {
            addLeft(root.left, result);
        } else {
            addLeft(root.right, result);
        }
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (isLeaf(root)) {
            result.add(root.val);
            return;
        }
        if (root.left != null)
            inorderTraversal(root.left, result);
        if (root.right != null)
            inorderTraversal(root.right, result);
    }

    public void addRight(TreeNode root, List<Integer> temp) {
        if (root == null)
            return;
        if (!isLeaf(root))
            temp.add(root.val);
        if (root.right != null) {
            addRight(root.right, temp);
        } else {
            addRight(root.left, temp);
        }
    }

    public boolean isLeaf(TreeNode node) {
        if (node != null && node.left == null && node.right == null)
            return true;

        return false;
    }
}
