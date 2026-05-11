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

    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        if (root.val >= max) {
            max = root.val;
            int left = dfs(root.left, max);
            int right = dfs(root.right, max);
            return left + right + 1;
        } else {
            int left = dfs(root.left, max);
            int right = dfs(root.right, max);
            return left + right;
        }
       
        
    }
}
