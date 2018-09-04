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
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>(); //K:prefix sum, V: ways to achieve this sum
        map.put(0,1); //if node.val == target
        return helper(map, root, 0, sum);
    }
    
    private int helper(HashMap<Integer, Integer> map, TreeNode root, int curSum, int target){
        if(root == null){return 0;}
        curSum += root.val;
        int res = map.getOrDefault(curSum - target, 0); //MUST BE in this order
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += helper(map, root.left, curSum, target) + helper(map, root.right, curSum, target);
        map.put(curSum, map.get(curSum)-1);
        return res;
    }
}