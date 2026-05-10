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
    int prev = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        boolean isValid = true;
        if (prev == Integer.MIN_VALUE) {
            prev = root.val;
        } else {
            if (prev >= root.val) {
                isValid = false;
            }
            prev = root.val;
        }
        boolean right = isValidBST(root.right);
        return isValid && left && right;
    }
}
