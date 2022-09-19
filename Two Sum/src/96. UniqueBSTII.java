
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList();

        return generationOfTrees(1, n);
    }

    public List<TreeNode> generationOfTrees(int start, int end) {
        List<TreeNode> newNode = new ArrayList();

        if (start == end) {
            newNode.add(new TreeNode(start));
            return newNode;

        }

        if (start > end) {
            newNode.add(null);
            return newNode;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSideTrees = generationOfTrees(start, i - 1);
            List<TreeNode> rightSideTrees = generationOfTrees(i + 1, end);

            for (TreeNode left : leftSideTrees) {
                for (TreeNode right : rightSideTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    newNode.add(root);
                }
            }

        }
        return newNode;
    }
}
