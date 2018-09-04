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
    int globalMax = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return globalMax;
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = root.left == null ? 0: 1 + helper(root.left);
        int right = root.right == null? 0: 1 + helper(root.right);
        globalMax = Math.max(globalMax, left + right);
        return Math.max(left, right);    
    }
    
}

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
    int globalMax = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root);
        return globalMax;
    }
    
    private int helper(TreeNode root){
        
        int left = root.left == null ? 0: 1 + helper(root.left);
        int right = root.right == null? 0: 1 + helper(root.right);
        globalMax = Math.max(globalMax, left + right);
        return Math.max(left, right);    
    }
    
}