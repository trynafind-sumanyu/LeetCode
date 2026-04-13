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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }

        if (root.left != null) {
            if (leftMax(root.left) >= root.val) {
                return false;
            }
        }

        if (root.right != null) {
            if (rightMin(root.right) <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left) && isValidBST(root.right);

    }

    private int leftMax(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val;
        }

        if (node.right == null) {
            return leftMax(node.left);
        }
        if (node.left == null) {
            return leftMax(node.right);
        } else {
            return Math.max(leftMax(node.left), leftMax(node.right));
        }
    }

    private int rightMin(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val;
        }

        if (node.right == null) {
            return rightMin(node.left);
        }
        if (node.left == null) {
            return rightMin(node.right);
        } else {
            return Math.min(rightMin(node.left), rightMin(node.right));
        }
    }
}