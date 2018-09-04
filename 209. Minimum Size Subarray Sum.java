class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = 0, res = Integer.MAX_VALUE;
        int curSum = 0;
        while(r < nums.length){
            curSum += nums[r++];  
            while(curSum >= s){
                res = Math.min(res, r - l);
                curSum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0: res;
    }
}