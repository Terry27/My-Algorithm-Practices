class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0, secMax = 0, idx = -1;
        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(num > max){
                idx = i;
                secMax = max;
                max = num;
            }else if(num > secMax){
                secMax = num;
            }
        }
        return max >= 2 * secMax ? idx: -1;
    }
}