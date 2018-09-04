public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        int pre = lower-1; //INCLUSIVE IMPORTANT
        int after;
        for(int i=0;i<=nums.length;i++){
            after = i==nums.length? upper+1: nums[i];
            if(after - pre == 2){
                result.add(String.valueOf(pre+1));
            }else if(after - pre > 2){
                result.add(String.valueOf(pre+1)+"->"+String.valueOf(after-1));
            }
            pre = after;
        }
        return result;
    }
}