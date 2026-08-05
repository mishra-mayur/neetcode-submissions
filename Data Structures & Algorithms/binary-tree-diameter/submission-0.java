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

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int[] max = new int[1];

        dfs(root, max);

        return max[0];
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getDepth(root.left) , getDepth(root.right));

    }

    private void dfs(TreeNode node, int[] max) {
        if(node == null)
            return;
        dfs(node.left, max);
        max[0] = Math.max(max[0], getDepth(node.left)+ getDepth(node.right));
        dfs(node.right, max);

    }
}
