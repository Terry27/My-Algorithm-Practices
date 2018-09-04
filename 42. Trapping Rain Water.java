
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        int[] res = new int[len];
        int curMax = height[0];

        for(int i = 0; i < len; i++){
            int curHeight = height[i];
            if(curMax < curHeight){
                curMax = curHeight;
            }
            res[i] = curMax;
        }
        curMax = height[len-1];
        int trap = 0;
        for(int i = len-1; i >=0; i--){
            int curHeight = height[i];
            if(curMax < curHeight){
                curMax = curHeight;
            }
            trap += Math.min(curMax, res[i]) - curHeight;
        }
        return trap;
    }
}



public class Solution {  runtime O(n) one pass, O(1) space
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int result = 0;
        int left = 0, right = height.length-1;
        int leftMax = height[left], rightMax = height[right];
        while(left<right){ //equals means
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if(height[left]<rightMax){
                result+= leftMax-height[left];
                left++;
            }else{
                result += rightMax-height[right];
                right--;
            }
        }

        return result;
    }

}

public class Solution {  //stack solution
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i < height.length){
            if(stack.isEmpty() || height[i] <= height[stack.peek()]){
                stack.push(i);
                i++;
            }else{ //if current one is rising
                int lastOne = stack.pop();
                int currentWater = 0;
                if(!stack.isEmpty()){
                    currentWater = (Math.min(height[stack.peek()], height[i])-height[lastOne])*(i-lastOne);
                }
                result += currentWater;
            }
        }
        return result;
    }

}
