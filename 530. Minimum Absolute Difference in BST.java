/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode prev;
    int min;
    public int getMinimumDifference(TreeNode root) {
	min = Integer.MAX_VALUE;
	prev = null;
        diff(root);
        return min;
    }
    
    private void diff(TreeNode root){
        if(root == null){return;}
        diff(root.left);
        if(prev != null){
            min = Math.min(min, Math.abs(root.val - prev.val));
        }
        prev = root;
        diff(root.right);
    }
}