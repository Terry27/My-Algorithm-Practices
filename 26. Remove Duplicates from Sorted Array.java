class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int fast = 1, slow = 1;
        while(fast < nums.length){
            if(nums[fast-1] == nums[fast]){
                fast++;
            }else{
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
}