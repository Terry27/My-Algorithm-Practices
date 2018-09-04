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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> visited = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.offerFirst(root);
                root = root.left;
            }
            root = stack.pollFirst(); //always use root variable as reference
            if(visited.contains(k - root.val)){
                return true;
            }
            visited.add(root.val);
            root = root.right;
        }
        return false;
    }
}