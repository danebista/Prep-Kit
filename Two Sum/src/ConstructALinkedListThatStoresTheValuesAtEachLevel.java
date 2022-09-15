import java.util.*;

public class ConstructALinkedListThatStoresTheValuesAtEachLevel {

    public static void main(String args[]) {
        TreeNode tree = new TreeNode(1);

        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        ArrayList<LinkedList<TreeNode>> ans = linkedlistAnswers(tree);
        System.out.println(ans.get(0).poll());
    }

    public static ArrayList<LinkedList<TreeNode>> linkedlistAnswers(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> newList = new LinkedList<>();

        if (root != null) {
            newList.add(root);
        }
        while (newList.size() != 0) {
            result.add(newList);

            LinkedList<TreeNode> parents = newList;
            newList = new LinkedList<>();
            for (TreeNode curr : parents) {
                if (curr.left != null) {
                    newList.add(curr);
                }

                if (curr.right != null) {
                    newList.add(curr);
                }
            }
        }

        return result;
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}
