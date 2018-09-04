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
    public int minDiffInBST(TreeNode root) {
	min = = Integer.MAX_VALUE;
	prev = null;
        helper(root);
        return min;
    }
    
    private void helper(TreeNode root){
        if(root == null){return;}
        helper(root.left);
        if(prev != null){
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        helper(root.right);
    }
}