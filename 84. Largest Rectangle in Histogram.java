class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>(); //stack to store INDEX, which heights[INDEX] is Monotonically increasing
        int max = 0;
        int i = 0;
        while(i <= heights.length){
            int curHeight = i == heights.length ? 0: heights[i];
            if(stack.isEmpty() || curHeight >= heights[stack.peekFirst()]){
                stack.offerFirst(i++);
            }else{
                int area = 0;
                int topIdx = stack.pollFirst();
                if(stack.isEmpty()){ //means all index before i are higher than height[i]
                    area = i * heights[topIdx];
                }else{
                    area = heights[topIdx]*(i - stack.peekFirst() - 1); //elements i and peek() are smaller than height[topIdx]
                    //算夹在中间的面积
                }
                max = Math.max(max, area);
            }
            
        }
        
        return max;
    }
}