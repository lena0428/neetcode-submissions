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

    public int dfs(TreeNode root, int maxValue) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (maxValue <= root.val) {
            count++;
            maxValue = root.val;
        } 
        int left = dfs(root.left, maxValue);
        int right = dfs(root.right, maxValue);
        return left + right + count;
    }
}
