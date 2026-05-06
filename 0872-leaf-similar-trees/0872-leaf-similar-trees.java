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
    public boolean leafSimilar(TreeNode r1, TreeNode r2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        leaf(r1,l1);
        leaf(r2,l2);

        return l1.equals(l2);
    }

    private void leaf(TreeNode node, List<Integer> list){
        if(node.left == null && node.right == null){
            list.add(node.val);
            return;
        }

        if(node.left != null){
            leaf(node.left,list);
        }
        if(node.right != null){
            leaf(node.right,list);
        }
    }
}