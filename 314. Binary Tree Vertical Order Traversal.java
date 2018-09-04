/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class ColNode{
    TreeNode node;
    int col;
    public ColNode(TreeNode node, int col){
        this.node = node;
        this.col = col;
    }

}

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Deque<ColNode> deque = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int colMin =0, colMax = 0;
        deque.offerLast(new ColNode(root, 0));
        // List<Integer> list = new ArrayList<>();
        // list.add(root.val);
        //map.put(0, list);
        while(!deque.isEmpty()){
            ColNode cNode = deque.pollFirst();
            TreeNode tNode = cNode.node;
            int col = cNode.col;
            List<Integer> list = map.get(col);
            if(list == null){
                list = new ArrayList<>();
                list.add(tNode.val);
                map.put(col, list);
            }else{
                list.add(tNode.val);
            }
            if(tNode.left != null){
                deque.offerLast(new ColNode(tNode.left, col-1));

            }
            if(tNode.right != null){
                deque.offerLast(new ColNode(tNode.right, col+1));

            }
            colMin = Math.min(colMin, col);
            colMax = Math.max(colMax, col);
        }

        for(int i = colMin; i<=colMax; i++){
            res.add(map.get(i));
        }

        return res;
    }
}


Option2: column queue
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        int min = 0, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<TreeNode> treeQueue = new ArrayDeque<>();
        Deque<Integer> colQueue = new ArrayDeque<>();

        treeQueue.offerLast(root);
        colQueue.offerLast(0);
        while(!treeQueue.isEmpty()){
            int curC = colQueue.pollFirst();
            TreeNode curNode = treeQueue.pollFirst();
            map.putIfAbsent(curC, new ArrayList<Integer>());
            map.get(curC).add(curNode.val);

            if(curNode.left != null){
                colQueue.offerLast(curC - 1);
                min = Math.min(min, curC-1);
                treeQueue.offerLast(curNode.left);
            }
            if(curNode.right != null){
                colQueue.offerLast(curC + 1);
                max = Math.max(max, curC+1);
                treeQueue.offerLast(curNode.right);
            }

        }

        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }

        return res;
    }
}
