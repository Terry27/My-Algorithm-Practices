class Solution {
    public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] clone = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            clone[i]=nums[i];
        }
        Arrays.sort(clone);
        for(int i = 0; i < clone.length; i++){
            map.put(clone[i],i+1);
        }
        String[] res = new String[clone.length];
        for(int i = nums.length-1; i >=0 ; i--){
            int ranking = map.get(nums[i]);
            if(ranking == nums.length){
                res[i] = "Gold Medal";
            }else if(ranking == nums.length-1){
                res[i] = "Silver Medal";
            }else if(ranking == nums.length-2){
                res[i] = "Bronze Medal";
            }else{
                res[i] = Integer.toString(nums.length-ranking+1);
            }
        }
        
        return res;
    }
}