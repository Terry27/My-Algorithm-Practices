class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int low = Integer.MIN_VALUE;
        for(int val: preorder){
            if(val < low){return false;}
            while(!stack.isEmpty() && val > stack.peekFirst()){
                low = stack.pollFirst();
            }
            stack.offerFirst(val);
        }
        return true;
    }
}

public boolean verifyPreorder(int[] preorder) { //O(1) space
    int low = Integer.MIN_VALUE, i = -1;
    for (int p : preorder) {
        if (p < low)
            return false;
        while (i >= 0 && p > preorder[i])
            low = preorder[i--];
        preorder[++i] = p;
    }
    return true;
}