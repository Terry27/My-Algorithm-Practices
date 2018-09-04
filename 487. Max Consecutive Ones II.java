class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int lastZero = -1, res = 0;
        for(int slow = 0, fast = 0; fast < nums.length; fast++){
            if(nums[fast] == 0){
                slow = lastZero + 1;
                lastZero = fast;
            }
            res = Math.max(res, fast - slow + 1);
        }
        return res;
    }
}