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
    //sol1: one pass, O(n) space. replace mode list while building the tree
    Integer prev;
    int max;
    int curCount;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        
        prev = null;
        max = 0;
        curCount = 1;
        
        inorder(root, res);
        int[] l = new int[res.size()];
        int i = 0;
        while(i< res.size()){
            l[i] = res.get(i);
            i++;
        }
        return l;
    }
    
    private void inorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left, res);
        if(prev != null){
            if(prev != root.val){
                curCount = 1;
            }else{
                curCount++;
            }
        }
        if(curCount > max){
            max = curCount;
            res.clear();
            res.add(root.val);
        }else if(curCount == max){
            res.add(root.val);
        }            
        
        prev = root.val;
        inorder(root.right, res);
    }
    
}


//sol2: two pass, O(1) space. Find mode occur first, then collect all values with mode in the second pass
