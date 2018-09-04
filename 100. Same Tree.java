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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){return true;}
        if(p == null || q == null){return false;}
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode[]> stack = new ArrayDeque<>();
        stack.offerFirst(new TreeNode[]{p,q});
        while(!stack.isEmpty()){
            TreeNode[] cur = stack.pollFirst();
            if(cur[0] == null && cur[1] == null){
                continue;
            }
            if(cur[0] == null || cur[1] == null || cur[0].val != cur[1].val){
                return false;
            }
            stack.offerFirst(new TreeNode[]{cur[0].left, cur[1].left});
            stack.offerFirst(new TreeNode[]{cur[0].right, cur[1].right});
        }
        return true;
    }
}