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
     public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        if (node.val >= maxSoFar) {
            maxSoFar = node.val;
            return 1 + dfs(node.left, maxSoFar) + dfs(node.right, maxSoFar);
        } else {
            return dfs(node.left, maxSoFar) + dfs(node.right, maxSoFar);
        }
    }
}
