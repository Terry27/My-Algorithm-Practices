class Solution { //O(nlogn), dumb way
    public int findUnsortedSubarray(int[] nums) {
        int[] cArr = nums.clone();
        Arrays.sort(cArr);
        int i = nums.length - 1, j = 0;
        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] != cArr[idx]){
                i = Math.min(i, idx);
                j = Math.max(j, idx);
            }
        }
        return i >= j ? 0: j - i + 1;
    }
}

//stack O(n), O(n)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int left = nums.length -1, right = 0;
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[i] < nums[stack.peekFirst()]){
                left = Math.min(left, stack.pollFirst());
            }
            stack.offerFirst(i);
        }
        
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] > nums[stack.peekFirst()]){
                right = Math.max(right, stack.pollFirst());
            }
            stack.offerFirst(i);
        }
        return right - left >= 0 ? 0 : right - left + 1;
    
    }
    
}

public class Solution { //4 four loops O(n), space O(1)
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                min = Math.min(min, nums[i]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]){
                max = Math.max(max, nums[i]);
            }
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
