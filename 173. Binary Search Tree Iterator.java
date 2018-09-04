/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator { //good, O(log(n)) space, Amortized O(1) time

    Deque<TreeNode> queue;
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>(); 
        pushLeft(root);    
    }
    
    private void pushLeft(TreeNode root){
        while(root != null){
            queue.offerFirst(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = queue.pollFirst();
        pushLeft(node.right);
        return node.val;
    }
}

public class BSTIterator { //NOT good, O(n) space

    Deque<TreeNode> queue;
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>(); 
        inOrder(root);
    }
    
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        queue.offerLast(root);
        inOrder(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return queue.pollFirst().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */