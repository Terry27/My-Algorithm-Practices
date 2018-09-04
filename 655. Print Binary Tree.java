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
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        List<List<String>> res= new ArrayList<>();
        int len = (int)Math.pow(2, h)-1;
        List<String> tmp = new ArrayList<String>();
        for(int j = 0; j < len; j++){
            tmp.add("");
        }
        for(int i = 0; i < h; i++){ //remember to initialize the arraylist first
            res.add(new ArrayList<>(tmp));
        }
        
        fillList(res, root, 0, 0, len);
        return res;
    }
    
    private void fillList(List<List<String>> res, TreeNode root, int level, int lo, int hi){
        if(lo > hi || root == null){ //or res.size() == level + 1
            return;
        }
        List<String> curList = res.get(level);
        int mid = lo + (hi - lo)/2;
        curList.set(mid, root.val+"");
        fillList(res, root.left, level+1, lo, mid-1);
        fillList(res, root.right, level+1, mid+1, hi);
    }
    
    private int height(TreeNode root){
        if(root == null){return 0;}
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}