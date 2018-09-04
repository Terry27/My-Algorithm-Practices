class MinStack {
    
    Deque<Integer> stack;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        // store min when it is smaller or equal than current min
        // curVal
        // min
        if(x <= min){
            stack.offerFirst(min);
            min = x;
        }
        stack.offerFirst(x);
    }
    
    public void pop() {
        if(stack.size() > 1){
            int cur = stack.pollFirst();
            // if a curVal that is also the min is popped, pop min also
            if(cur == min){
                min = stack.pollFirst();
            }
        }
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */