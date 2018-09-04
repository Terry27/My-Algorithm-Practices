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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){return res;}
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        List<Integer> curList = new ArrayList<Integer>();
        curList.add(root.val);
        
        while(!queue.isEmpty()){
            res.add(0, curList); //beautiful!
            int size = queue.size();
            curList = new ArrayList<Integer>();
            while(size-- > 0){
                TreeNode cur = queue.pollFirst();
                if(cur.left != null){
                    queue.offerLast(cur.left);
                    curList.add(cur.left.val);
                }
                if(cur.right != null){
                    queue.offerLast(cur.right);
                    curList.add(cur.right.val);
                }
            }
        }
        return res;
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){return res;}
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        List<Integer> curList = new ArrayList<Integer>();
        curList.add(root.val);
        
        while(!queue.isEmpty()){
            res.add(curList);
            int size = queue.size();
            curList = new ArrayList<Integer>();
            while(size-- > 0){
                TreeNode cur = queue.pollFirst();
                if(cur.left != null){
                    queue.offerLast(cur.left);
                    curList.add(cur.left.val);
                }
                if(cur.right != null){
                    queue.offerLast(cur.right);
                    curList.add(cur.right.val);
                }
            }
        }
        Collections.reverse(res); //better no using linkedlist
        return res;
    }
}