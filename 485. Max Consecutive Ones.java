class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int consec = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                consec++;
                res = Math.max(consec, res);
            }else{
                consec = 0;
            }
        }
        
        return res;
    }
}