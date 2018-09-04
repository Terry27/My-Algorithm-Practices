class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int cur = Math.abs(nums[i]);
            nums[cur-1] = -Math.abs(nums[cur-1]); //first pass mark exisited element as negative
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }
}