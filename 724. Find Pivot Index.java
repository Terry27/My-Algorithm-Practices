class Solution { //O(n), O(1) space 
    public int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for(int num: nums){sum += num;}
        for(int i = 0; i < nums.length; i++){
            if(i != 0){left += nums[i-1];}
            // num1, num2, num3
            // sum = num1+num2+num3;
            // when i = 1, left = sum1,
            // to check left == right, 
            // sum - left - NUM2!!
            if(sum - left - nums[i] == left){return i;}
        }
        return -1;
        
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length];
        
        for(int i = nums.length-2; i >= 0; i--){
            sum[i] = sum[i+1]+nums[i+1];
        }
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            left += i-1 >= 0 ? nums[i-1]: 0; //when case like 0,1,-1
            if(left == sum[i]){
                return i;
            }
        }
        return -1;
        
    }
}