/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { //BFS, find range at same time, map to record col->list
//Do not use Arrays.asList();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){return res;} //defensive check
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        Deque<Integer> colQueue = new ArrayDeque<>();
        int min = 0, max = 0; //col number range
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        nodeQueue.offerLast(root);
        colQueue.offerLast(0);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(root.val);
        map.put(0, arr);
        
        while(!nodeQueue.isEmpty()){
            TreeNode cur = nodeQueue.pollFirst();
            int curCol = colQueue.pollFirst();
            if(cur.left != null){
                nodeQueue.offerLast(cur.left);
                colQueue.offerLast(curCol - 1);
                min = Math.min(min, curCol -1);
                List l = map.get(curCol -1);
                if(l == null){
                    l = new ArrayList<Integer>();
                    l.add(cur.left.val);
                    map.put(curCol -1, l);
                }else{
                    l.add(cur.left.val);
                }
            }
            if(cur.right != null){
                nodeQueue.offerLast(cur.right);
                colQueue.offerLast(curCol + 1);
                max = Math.max(max, curCol + 1);
                List l = map.get(curCol + 1);
                if(l == null){
                    l = new ArrayList<Integer>();
                    l.add(cur.right.val);
                    map.put(curCol + 1, l);
                }else{
                    l.add(cur.right.val);
                }
            }
        }
        
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        
        return res;
        
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
class Solution { //cleaner version
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){return res;} //defensive check
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        Deque<Integer> colQueue = new ArrayDeque<>();
        int min = 0, max = 0; //col number range
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        nodeQueue.offerLast(root);
        colQueue.offerLast(0);
        
        while(!nodeQueue.isEmpty()){
            TreeNode cur = nodeQueue.pollFirst();
            int curCol = colQueue.pollFirst();
            
            List l = map.get(curCol);
            if(l == null){
                l = new ArrayList<Integer>();
                l.add(cur.val);
                map.put(curCol, l);
            }else{
                l.add(cur.val);
            }
            if(cur.left != null){
                nodeQueue.offerLast(cur.left);
                colQueue.offerLast(curCol - 1);
                min = Math.min(min, curCol -1);
            }
            if(cur.right != null){
                nodeQueue.offerLast(cur.right);
                colQueue.offerLast(curCol + 1);
                max = Math.max(max, curCol + 1);
            }
        }
        
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        
        return res;
    }
}