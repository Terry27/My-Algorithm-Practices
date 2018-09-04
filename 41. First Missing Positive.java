class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int slow = 0, fast = nums.length-1;
        while(slow <= fast){ //has to be equal, corner case when len==1
            while(slow <= fast && nums[slow] > 0){ slow++;}
            while(slow <= fast && nums[fast] <= 0){ fast--;}
            if(slow <= fast){
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
                fast--;
            }
        }
        
        for(int i = 0; i < slow; i++){
            int tmp = Math.abs(nums[i]) - 1;
            if(tmp < nums.length){
                nums[tmp] = -Math.abs(nums[tmp]);
            }
        }
        for(int i = 0; i < slow; i++){
            if(nums[i] >= 0){
                return i+1;
            }
        }
        return slow + 1;
    }
}