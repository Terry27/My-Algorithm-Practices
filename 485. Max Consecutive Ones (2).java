class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int consec = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] == 1){
                consec++;
            }else{
                consec = 0;
            }
            max = Math.max(max, consec);
            
        }
        return max;
    }
}