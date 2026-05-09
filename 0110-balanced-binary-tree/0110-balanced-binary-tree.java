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
    public boolean isBalanced(TreeNode root) {
        return helper(root);
    }

    private int height(TreeNode node, int val){
        if(node == null){
            return val;
        }

        int left = height(node.left,val+1);
        int right = height(node.right,val+1);

        return Math.max(left,right);
    }

    private boolean helper(TreeNode node){
        if(node == null){
            return true;
        }
        int diff = Math.abs(height(node.left,0)-height(node.right,0));
        if(diff > 1){
            return false;
        }

        return helper(node.left) && helper(node.right);
    }
}