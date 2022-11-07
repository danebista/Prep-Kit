/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if (root == null)
            return "#";
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("# ");
                continue;
            }
            sb.append(curr.val + " ");
            queue.offer(curr.left);
            queue.offer(curr.right);

        }
        System.out.println(sb.toString());
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList();
        String[] dataStream = data.split(" ");
        if (dataStream[0].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(dataStream[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() || i < dataStream.length) {
            TreeNode curr = queue.poll();

            if (!dataStream[i].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(dataStream[i]));
                queue.add(curr.left);
                i++;
            } else {
                curr.left = null;
                i++;
            }

            if (!dataStream[i].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(dataStream[i]));
                queue.add(curr.right);
                i++;
            } else {
                curr.right = null;
                i++;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
