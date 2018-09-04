class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0; 
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        double maxSum = sum; //must do this here, use separate loop
        for(int i = k; i < nums.length; i++){
            sum -= nums[i-k];
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum/k;
    }
}

