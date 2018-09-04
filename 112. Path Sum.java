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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){return false;}
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> valStack = new ArrayDeque<>();
        stack.offerFirst(root);
        valStack.offerFirst(root.val);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollFirst();
            int curSum = valStack.pollFirst();
            if(node.left == null && node.right == null && curSum == sum){
                return true;
            }
            if(node.left != null){
                stack.offerFirst(node.left);
                valStack.offerFirst(curSum + node.left.val);
            }
            if(node.right != null){
                stack.offerFirst(node.right);
                valStack.offerFirst(curSum + node.right.val);
            }
        }
        return false;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){return false;}
        if(root.val == sum && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
   
}