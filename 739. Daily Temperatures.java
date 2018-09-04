class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if(temperatures == null || temperatures.length == 0){
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!deque.isEmpty() && temperatures[deque.peekFirst()] < temperatures[i]){
                int oldIdx = deque.pollFirst();
                res[oldIdx] = i - oldIdx; 
            }
            deque.offerFirst(i);
        }
        return res;
    }
}