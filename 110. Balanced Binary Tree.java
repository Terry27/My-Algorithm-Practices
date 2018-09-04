/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution { //O(n)
    
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    
    private int helper(TreeNode root){
        if(root == null){return 0;}
        int left = helper(root.left);
        if(left == -1){return -1;}
        int right = helper(root.right);
        if(right == -1){return -1;}
        if(Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right)+1;
    }
}



class Solution { //O(n)
    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        if(root == null){
            return true;
        }
        helper(root);
        return isBalanced;
    }
    
    private int helper(TreeNode root){
        if(root == null){return 0;}
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left - right) <= 1){
            isBalanced = isBalanced && true;
        }else{
            isBalanced = false;
        }
        return Math.max(left, right)+1;
    }
}