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
    public TreeNode createBinaryTree(int[][] d) {
        Set<Integer> setP = new HashSet<>(); //parent set
        Set<Integer> setC = new HashSet<>(); // Child set

        for(int[] n : d){ // n -> node in description array
            setP.add(n[0]);
            setC.add(n[1]);
        } // Whichever node won't be available in the child set will be the root node.

        Map<Integer, TreeNode> map = new HashMap<>();

        for(int[] n : d){
            int p = n[0];
            int c = n[1];
            boolean left = n[2] == 1 ? true : false;
            
            if( !map.containsKey(p) ){
                map.put(p,new TreeNode(p));
            }

            if( !map.containsKey(c) ){
                map.put(c, new TreeNode(c));
            }

            if(left){
                map.get(p).left = map.get(c);
            }
            else{
                map.get(p).right = map.get(c);
            }
        }

        for(int i : setP){
            if(!setC.contains(i)){
                return map.get(i);
            }
        }

        return new TreeNode(0);
    }
}