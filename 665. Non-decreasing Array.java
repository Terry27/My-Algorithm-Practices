class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0; //the number of changes
        for (int i = 1; i < nums.length; i++) {
            if (count > 1) {
                return false;
            }

            if (nums[i - 1] > nums[i]) {
                count++;
                if (i == 1 || nums[i - 2] <= nums[i]){
                    nums[i - 1] = nums[i]; //modify nums[i-1] of a priority
                }else{
                    nums[i] = nums[i - 1]; //have to modify nums[i]
                }
            }
        }
        return count <= 1;
    }
}