public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        //find first position i which nums[i-1] < nums[i]
        int i = nums.length-1;
        for(;i>=1;i--){
            if(nums[i-1]<nums[i]){
                break;    
            }
        }
        if(i == 0){
            
        }
    }
    
    private void reverse(int[] nums, int start, int end){
        int mid = start+ (end-start)/2;
        while(start <= mid){
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}