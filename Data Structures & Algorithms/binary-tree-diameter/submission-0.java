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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       diameter(root);
       return res;
    }

    public void diameter(TreeNode root) {
        if (root == null) {
            return;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        res = Math.max(left + right, res);
        diameter(root.left);
        diameter(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return left > right ? (left + 1) : (right + 1);
    }
}
