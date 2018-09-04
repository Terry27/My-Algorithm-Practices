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
    int max;
    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int curLeft = 0, curRight = 0;
        if(root.left != null && root.left.val == root.val){
            curLeft += left+ 1;
        }
        if(root.right != null && root.right.val == root.val){
            curRight += right+1;
        }
        // path that goes through this node
        max = Math.max(max, curLeft + curRight);
        //parent node only cares about the longest path on one side
        return Math.max(curLeft, curRight);
    }
}

