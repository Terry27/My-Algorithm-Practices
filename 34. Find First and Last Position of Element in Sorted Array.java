class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = {-1,-1};
        if(nums == null || nums.length == 0){ //IMPORTANT! avoid idxOutOfBound
            return res;
        }
        
        int start = 0, end = nums.length - 1;
        //find lower range
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= target){
                end = mid;
            }else if(nums[mid] < target){
                start = mid;
            }
        }
        if(nums[start] == target ){
            res[0] = start;
        }else if(nums[end] == target){
            res[0] = end;
        }//else{
        //     res[0] = -1;
        // }
        
        //find higher range
        start = 0;
        end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] <= target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[end] == target ){
            res[1] = end;
        }else if(nums[start] == target){
            res[1] = start;
        }//else{
        //     res[1] = -1;
        // }
        
        return res;
        
    }
}