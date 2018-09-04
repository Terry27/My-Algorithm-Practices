public class Solution { //DFS inorder traversal
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(root.left != null){
            stack.push(root.left);
            root = root.left;
        }
        
        while(!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            if(--k == 0){
                return curNode.val;
            }
            TreeNode right = curNode.right;
            while(right != null){
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode temp = root;
        while(temp != null){
            deque.offerLast(temp);
            temp = temp.left;
        }
        while(k != 0){
            TreeNode cur = deque.pollLast();
            k--;
            if(k == 0){ return cur.val;}
            TreeNode right = cur.right;
            while(right != null){
                deque.offerLast(right);
                right = right.left;
            }
        }
        
        return -1;
        
    }
}


public class Solution { //DFS + binary search
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if(k <= count){
            return kthSmallest(root.left, k);
        }else if( k > count+1){
            return kthSmallest(root.right, k-count-1);
        }
        return root.val;
    }
    
    public int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        return countNodes(root.left)+1+countNodes(root.right);
    }
}
